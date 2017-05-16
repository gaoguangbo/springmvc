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
	  
	 // String fileFromHttp=doHttpConnect();   //�����õ���txt�ļ���
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
	  return "�ɹ����зִʣ��������з���......";
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
		     result="�ƾ�";
		     break;
	     case 1:
	    	 result="IT";
	    	 break;
	     case 2:
	    	 result="����";
	    	 break;
	     case 3:
	    	 result="����";
	    	 break;
	     case 4:
	    	 result="����";
	    	 break;
	     case 5:
	    	 result="����";
	    	 break;
	     case 6:
	    	 result="����";
	    	 break;
	     default:
	    	 result="�������г���";	 
	  }
	  
	  return "�����Ѿ���ɣ�";
  }
  
  public String getResult(){
	  return result;
  }
  
  public boolean getFlag(){
	  return httpFlag;
  }
}
