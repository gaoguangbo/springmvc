package com.guangbo.pachong.eventHandler;


import com.guangbo.pachong.auxiwork.HttpParserAll;
import com.guangbo.pachong.auxiwork.MySplit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TxtButtonHandler {


	private String filePath;
	private LinkedList<LinkedList<String>> wordListList;   //保存分词后的结果
	private LinkedList<String> result;                   //保存分类结果
	private Map<String,float[]> bayesMap;      //bayes模型
	private LinkedList<String> httpList;       // 保存url链接地址
	private LinkedList<String> fileNameList;   //保存爬虫获得的文件名
	private LinkedList<Boolean> httpFlagList;   //保存url地址判断标识
	private LinkedList<String> urlJudgerList;   // 保存地址返回错误类型
	public TxtButtonHandler(String filePath,Map<String,float[]> bayesmap){

		this.filePath=filePath;
		this.bayesMap=bayesmap;
		result=new LinkedList<String>();
		wordListList=new LinkedList<LinkedList<String>>();
		httpList=new LinkedList<String>();
		fileNameList=new LinkedList<String>();
		httpFlagList=new LinkedList<Boolean>();
		urlJudgerList=new LinkedList<String>();

	}

	public String readFileContent(){
		File file=new File(filePath);
		try{
			FileInputStream inputstream=new FileInputStream(file);
			BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
			String tempString=reader.readLine();
			while(tempString!=null){

				if(tempString.matches("\\s*"))  //过滤掉空行
				{
					tempString=reader.readLine();
					continue;
				}

				//此处需要继续对输入内容是否为网址进行判断，是则加入到linkedList中
				tempString=tempString.trim();
				httpList.add(tempString);
				tempString=reader.readLine();
			}

			reader.close();
		}catch(Exception e){
			System.out.println("file is not found or IO problem");
		}
		return "链接地址读取完毕，即将进行网页爬虫.......";
	}


	public String dohttpConnect(){


		Iterator<String> iter=httpList.iterator();
		while(iter.hasNext()){
			String temp=iter.next();
			temp=temp.trim();
			HttpParserAll myparser=new HttpParserAll(temp);
			String urljudger=myparser.urlJudge();
			if(urljudger!=null){
				boolean tempFlag=false;
				httpFlagList.add(tempFlag);
				urlJudgerList.add(urljudger);
			}
			else{
				boolean tempFlag=true;
				httpFlagList.add(tempFlag);
				myparser.extractTextByTag();
				fileNameList.add(myparser.getFileFromHttp());
			}
		}
		return "网页爬虫结束，即将进行分词.......";
	}

	public String doSplit(){

		LinkedList<String> wordList=new LinkedList<String>();

		Iterator<String> iter=fileNameList.iterator();

		while(iter.hasNext()){
			String fileToSplit=iter.next();
			fileToSplit=fileToSplit.trim();
			try {
				MySplit mysplit=new MySplit(fileToSplit);
				mysplit.fileSplit_List();
				wordList=mysplit.getWordList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			wordListList.add(wordList);
		}
		return "分词结束，即将进行网页分类.....";
	}

	public String doClassify(){

		for(int i=0;i<wordListList.size();i++){

			float[] totalProb={0,0,0,0,0,0,0};
			Iterator<String> iter=wordListList.get(i).iterator();
			while(iter.hasNext()){
				String tempString=iter.next();
				if(bayesMap.containsKey(tempString)){
					for(int j=0;j<7;j++){
						totalProb[j]=totalProb[j]+bayesMap.get(tempString)[j];
					}
				}
			}

			float temp=totalProb[0];
			for(int h=0;h<totalProb.length;h++){
				if(totalProb[h]>=temp)
					temp=totalProb[h];
			}

			int flag=0;
			for(int j=0;j<totalProb.length;j++){
				if(temp==totalProb[j]){
					flag=j;
					break;
				}
			}

			String tempresult;
			switch(flag){
				case 0:
					tempresult="财经";
					result.add(tempresult);
					break;
				case 1:
					tempresult="IT";
					result.add(tempresult);
					break;
				case 2:
					tempresult="汽车";
					result.add(tempresult);
					break;
				case 3:
					tempresult="旅游";
					result.add(tempresult);
					break;
				case 4:
					tempresult="体育";
					result.add(tempresult);
					break;
				case 5:
					tempresult="教育";
					result.add(tempresult);
					break;
				case 6:
					tempresult="其他";
					result.add(tempresult);
					break;
				default:
					tempresult="程序运行出错";
					result.add(tempresult);
			}
		}
		return "分类完毕,结果为：";
	}

	public LinkedList<Boolean> getFlagList(){
		return httpFlagList;
	}

	public LinkedList<String> getUrlJudger(){
		return urlJudgerList;
	}
	public LinkedList<String> getResult(){
		return result;
	}
}
