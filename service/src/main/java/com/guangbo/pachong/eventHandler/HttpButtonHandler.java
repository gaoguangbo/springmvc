package com.guangbo.pachong.eventHandler;


import com.guangbo.pachong.auxiwork.HttpParserAll;
import com.guangbo.pachong.auxiwork.MySplit;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class HttpButtonHandler {

  private String httpAddress;
  private LinkedList<String> wordList;
  private String result;
  private Map<String,float[]> bayesMap;
  private boolean httpFlag;
  
  public HttpButtonHandler(String httpAddress,Map<String,float[]> probMap) throws Exception{
	 
	  this.httpAddress=httpAddress;
	  this.bayesMap=probMap;
	  wordList=new LinkedList<String>();
	  httpFlag=true;
	  
	 // String fileFromHttp=doHttpConnect();   //爬虫后得到的txt文件名
	 // if(httpFlag){
	  //   doSplit(fileFromHttp); 
	  //   doClassify();
	  //}
  }
  
  public String doHttpConnect(){
	  
	  /*
	  MyHttpParser myparser=new MyHttpParser(httpAddress);
	  String fileName=myparser.getFileFromHttp();
	  return fileName;
	  */
	  
	  HttpParserAll myparser=new HttpParserAll(httpAddress);
	  String urljudger=myparser.urlJudge();
	  if(urljudger!=null){
		  httpFlag=false;
		  return urljudger;
	  }
	  else{
		  httpFlag=true;
		  myparser.extractTextByTag();
		  return myparser.getFileFromHttp();
	  }
	  
  }
  
  public String doSplit(String fileName) throws Exception{
	  MySplit mysplit=new MySplit(fileName);
	  mysplit.fileSplit_List();
	  wordList= mysplit.getWordList();
	  return "成功进行分词，即将进行分类......";
  }
  
  public String doClassify(){
	  
	  float[] totalProb={0,0,0,0,0,0,0};
	  Iterator<String> iter=wordList.iterator();
	  while(iter.hasNext()){
		  String tempString=iter.next();
		  if(bayesMap.containsKey(tempString)){
			  for(int i=0;i<7;i++){
				  totalProb[i]=totalProb[i]+bayesMap.get(tempString)[i];
			  }
		  }
	  }
	  
	  float temp=totalProb[0];
	  for(int i=0;i<totalProb.length;i++){
		  if(totalProb[i]>=temp)
			  temp=totalProb[i];
	  }
	  
	  int flag=0;
	  for(int j=0;j<totalProb.length;j++){
		  if(temp==totalProb[j]){
			  flag=j;
			  break;
		  }
	  }
	  
	  switch(flag){
	     case 0:
		     result="财经";
		     break;
	     case 1:
	    	 result="IT";
	    	 break;
	     case 2:
	    	 result="汽车";
	    	 break;
	     case 3:
	    	 result="旅游";
	    	 break;
	     case 4:
	    	 result="体育";
	    	 break;
	     case 5:
	    	 result="教育";
	    	 break;
	     case 6:
	    	 result="其他";
	    	 break;
	     default:
	    	 result="程序运行出错";	 
	  }
	  
	  return "分类已经完成：";
  }
  
  public String getResult(){
	  return result;
  }
  
  public boolean getFlag(){
	  return httpFlag;
  }
}
