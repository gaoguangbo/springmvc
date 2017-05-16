package com.guangbo.pachong.feactureExtraction;

import java.io.*;

public class TempHandle {

	public TempHandle() throws Exception{
		File file=new File("./wordMap/feacture_1000.txt");
		File fileOut=new File("./wordMap/feacture_1000_new.txt");
		FileInputStream inputstream =new FileInputStream(file);
		FileOutputStream outputstream=new FileOutputStream(fileOut);
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputstream));
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
		String tempString=reader.readLine();
		while(tempString!=null){
			     
			    tempString.trim();
				tempString= tempString.replaceAll("\\d+", "");
				tempString=tempString.replace(".", "");
				tempString=tempString.replace(" ","");
				 System.out.println(tempString);
			     writer.write(tempString);
				 writer.newLine();
				 tempString=reader.readLine();	
				}
		
		reader.close();
		writer.close();
	}
	
	public static void main(String [] args) throws Exception{
		TempHandle  handle=new TempHandle();
	}
}
