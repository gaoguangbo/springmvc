package com.guangbo.pachong.feactureExtraction;

public class StopWordsHandler {

	private static String[] stopWordList={"��", "����","��","��","��","����","Ҫ","��","�Լ�","֮","��","��","��","��","��","��","��","Ӧ","��","ĳ","��","��","��","λ","��","һ","��","��","��","��","��","��","��",""};
	
	public static boolean isStopWord(String word){
		for(int i=0;i<stopWordList.length;i++){
		   if(word.equalsIgnoreCase(stopWordList[i]))
			   return true;		
	    }
		return false;
  }
}