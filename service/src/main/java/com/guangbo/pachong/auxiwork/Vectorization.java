package com.guangbo.pachong.auxiwork;

import java.io.*;
import java.util.LinkedList;

public class Vectorization {
  
	private LinkedList<String> feactureList;
	private String trainDataFile;
	
	public Vectorization() throws Exception{
		
		trainDataFile="E:\\私人空间\\学习\\课程学习\\现代信息检索\\SogouC_splited_line";
		feactureList=new LinkedList<String>();
		File feactureFile=new File("./wordMap/feacture_1000_new.txt");
		FileInputStream inputstream=new FileInputStream(feactureFile);
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
		String tempString=reader.readLine();
		while(tempString!=null){
			tempString=tempString.trim();
			feactureList.add(tempString);
			tempString=reader.readLine();
		}
		reader.close();
		
		vectorTrainData();
	}
	
	public void vectorTrainData() throws Exception{
		File filePath=new File(trainDataFile);
		 File files[]=filePath.listFiles();
		 for(int i=0;i<files.length;i++){
	   		 
	   		 System.out.println("calculating "+files[i].getName());
	   		 File fileOut=new File(i+".txt");
	   		 FileOutputStream outputstream=new FileOutputStream(fileOut);
	   		 BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputstream));
	   		 
	   		 File fileNodes[]=files[i].listFiles();
	   		 
	   		    for(int j=0;j<1000;j++){
	   		    	
	   		    	System.out.println("calculating"+j);
	   		    	LinkedList<String> tempList=new LinkedList<String>();
	   		    	FileInputStream inputstream=new FileInputStream(fileNodes[j]);
	   		    	BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
	   		    	String tempString=reader.readLine();
	   		    	while(tempString!=null){
	   	                tempString=tempString.trim();
	   	                tempList.add(tempString);
	   	                tempString=reader.readLine();
	                }
	   		    	reader.close();
	   		    	for(int h=0;h<feactureList.size();h++){
	   		    		if(tempList.contains(feactureList.get(h).trim()))
	   		    			writer.write("1"+" ");
	   		    		else
	   		    			writer.write("0"+" ");
	   		    	}
	   		    	writer.newLine();
	   		    }
	   		    writer.close();
		 }
	}
	
	public static void main(String []args) throws Exception{
		Vectorization vec=new Vectorization();
	}
}

