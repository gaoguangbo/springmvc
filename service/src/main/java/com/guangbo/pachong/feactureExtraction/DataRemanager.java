package com.guangbo.pachong.feactureExtraction;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DataRemanager {
	
	  private  Map<String,Integer> c0Map;
	  private  Map<String,Integer> c1Map;
	  private  Map<String,Integer> c2Map;
	  private  Map<String,Integer> c3Map;
	  private  Map<String,Integer> c4Map;
	  private  Map<String,Integer> c5Map;
	  private  Map<String,Integer> c6Map;
      private  LinkedList<Map<String,Integer>> wordList;
	  private DataManager manager;
	  
	  public DataRemanager() throws Exception{
			
			manager=new DataManager();
			wordList=new LinkedList<Map<String,Integer>>();
			c0Map=manager.getc0Map();
			c1Map=manager.getc1Map();
			c2Map=manager.getc2Map();
			c3Map=manager.getc3Map();
			c4Map=manager.getc4Map();
			c5Map=manager.getc5Map();
			c6Map=manager.getc6Map();
			wordList.add(c0Map);
			wordList.add(c1Map);
			wordList.add(c2Map);
			wordList.add(c3Map);
			wordList.add(c4Map);
			wordList.add(c5Map);
			wordList.add(c6Map);
		}
		
	public void reWriterFile() throws Exception{
		File file=new File("./wordMap/feacture_1000_new.txt");
		FileInputStream inputstream =new FileInputStream(file);
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
		String tempString=reader.readLine();
		LinkedList<String> tempList=new LinkedList<String>();
		while(tempString!=null){
			tempString.trim();
			tempList.add(tempString);
			tempString=reader.readLine();
		}
		reader.close();
		
			for(int h=0;h<wordList.size();h++){
				File fileOut=new File("./wordMap"+"reWc"+h+"Map"+".txt");
				FileOutputStream outputstream=new FileOutputStream(fileOut);
				BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputstream));
				Iterator<String> iter=wordList.get(h).keySet().iterator();
				while(iter.hasNext()){
					String temp=iter.next();
					temp=temp.trim();
					if(tempList.contains(temp)){
						writer.write(temp);
						writer.write(" "+wordList.get(h).get(temp));
						writer.newLine();
					}
					
				}
				writer.close();
			}

   }
	
	public static void main(String []args) throws Exception{
		DataRemanager remanager=new DataRemanager();
		remanager.reWriterFile();
	}
}
