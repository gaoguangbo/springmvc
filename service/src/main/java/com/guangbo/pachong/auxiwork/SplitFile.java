package com.guangbo.pachong.auxiwork;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.List;


public class SplitFile {
	
	
   
	public static void list_split(File path, int level) throws Exception{
   	 if(level==0)
   		 System.out.println(path);
   	 
   	 File files[]=path.listFiles();
   	 for(int i=0;i<files.length;i++){
   		 System.out.println(files[i]);
   		 if(!files[i].isDirectory()){
   			read_split(files[i].getAbsolutePath()); 
   		 }
   		 for(int j=0;j<=level;j++)
   		   System.out.print(" ");
   		 if(files[i].isDirectory()){
   			 list_split(files[i],(level+1));
   		 }
   	 }	   
      }
	
	public static void read_split(String path) throws Exception{
		String fileInPath=path;
		String fileOutPath=fileInPath.replace("SogouC", "SogouC_splitedceshi");
		File fileIn=new File(fileInPath);
		FileInputStream inputstream=new FileInputStream(fileIn);
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
	/*	
		int i=fileInPath.lastIndexOf("/");
		String fileName=fileInPath.substring(i+1);
	*/	
		File fileOut=new File(fileOutPath);
		
		File parentFile=fileOut.getParentFile();
		if(!parentFile.exists()){
			parentFile.mkdirs();
		}
	
		
		FileOutputStream outputstream=new FileOutputStream(fileOut);
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputstream));
		
		String tempString=reader.readLine();
		while(tempString!=null){
			
			if(tempString.matches("\\s*"))  //���˵�����
			{
				tempString=reader.readLine();
				continue;
			}
			
			
			tempString=tempString.trim();     
    	    String result =tempString.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");  //���˵���ֵķ���
    	    tempString=result;
		
	    	List<Term> parse =ToAnalysis.parse(tempString);	
	    	String tempSplited=parse.toString();
	    	tempSplited=tempSplited.replace("[", "");  //���˵��ִʺ������ǰ�˺�˷���
	    	tempSplited=tempSplited.replace("]", "");
	    	String []tempArray=tempSplited.split("\\,");
	    	for(int j=0;j<tempArray.length;j++){
	    		tempArray[j]=tempArray[j].trim();
	    		System.out.println(tempArray[j]);
	    		writer.write(tempArray[j]);
	    		writer.newLine();
	    	}
	    	
	    	tempString=reader.readLine();
	    }
		
		writer.close();
		reader.close();
		}
		
	public static void main(String [] args) throws Exception{
		File file=new File("E:\\˽�˿ռ�\\ѧϰ\\�γ�ѧϰ\\�ִ���Ϣ����\\SogouC");
		list_split(file,0);
	}
	}

