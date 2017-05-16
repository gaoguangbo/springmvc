package com.guangbo.pachong.feactureExtraction;

public class StopWordsHandler {

	private static String[] stopWordList={"的", "我们","你","她","他","他们","要","它","自己","之","将","“","”","，","（","）","后","应","到","某","后","个","是","位","新","一","两","在","中","或","有","更","好",""};
	
	public static boolean isStopWord(String word){
		for(int i=0;i<stopWordList.length;i++){
		   if(word.equalsIgnoreCase(stopWordList[i]))
			   return true;		
	    }
		return false;
  }
}