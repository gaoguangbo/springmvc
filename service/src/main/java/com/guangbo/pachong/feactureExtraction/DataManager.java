package com.guangbo.pachong.feactureExtraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DataManager {
   
	  private  LinkedList<Map<String,Integer>> wordList;
	  private  String path;
	  private  Map<String,Integer> c1Map;
	  private  Map<String,Integer> c2Map;
	  private  Map<String,Integer> c3Map;
	  private  Map<String,Integer> c4Map;
	  private  Map<String,Integer> c5Map;
	  private  Map<String,Integer> c6Map;
	  private  Map<String,Integer> c7Map;
	  
	  private  Map<String,Integer> totalMap;
	  private  Map<String, Float> infoGainMap;
	  
	  private final  float info_class=(float) (-(1.0/7.0)*(Math.log(1.0/7.0)/Math.log(2)))*7;
	  
	  public DataManager() throws Exception{
		  path="E:\\私人空间\\学习\\课程学习\\现代信息检索\\SogouC_splited_line";
		  wordList=new LinkedList<Map<String,Integer>>();
		  c1Map=new LinkedHashMap<String,Integer>();
		  c2Map=new LinkedHashMap<String,Integer>();
		  c3Map=new LinkedHashMap<String,Integer>();
		  c4Map=new LinkedHashMap<String,Integer>();
		  c5Map=new LinkedHashMap<String,Integer>();
		  c6Map=new LinkedHashMap<String,Integer>();
		  c7Map=new LinkedHashMap<String,Integer>();
		  
		  totalMap=new LinkedHashMap<String,Integer>();
		  infoGainMap=new LinkedHashMap<String,Float>();
		  
		  wordList.add(c1Map);
		  wordList.add(c2Map);
		  wordList.add(c3Map);
		  wordList.add(c4Map);
		  wordList.add(c5Map);
		  wordList.add(c6Map);
		  wordList.add(c7Map);
		  
		  File file=new File(path);
		  System.out.println("doing statistics...");
		  wordListExtract(file);
		//  condiProbility();
		//  writeFile("./wordMap/");
		  
		  
	  }
	  public DataManager(String str){
		  path=str;
		  wordList=new LinkedList<Map<String,Integer>>();
		  c1Map=new LinkedHashMap<String,Integer>();
		  c2Map=new LinkedHashMap<String,Integer>();
		  c3Map=new LinkedHashMap<String,Integer>();
		  c4Map=new LinkedHashMap<String,Integer>();
		  c5Map=new LinkedHashMap<String,Integer>();
		  c6Map=new LinkedHashMap<String,Integer>();
		  c7Map=new LinkedHashMap<String,Integer>();
		  
		  totalMap=new LinkedHashMap<String,Integer>();
		  infoGainMap=new LinkedHashMap<String,Float>();
		  
		  wordList.add(c1Map);
		  wordList.add(c2Map);
		  wordList.add(c3Map);
		  wordList.add(c4Map);
		  wordList.add(c5Map);
		  wordList.add(c6Map);
		  wordList.add(c7Map);
	  }
		
	  private  void wordListExtract(File pathStr) throws Exception{
		   	 
		   	 File files[]=pathStr.listFiles();
		   	 
		   	 for(int i=0;i<files.length;i++){
		   		 
		   		 System.out.println("calculating "+files[i].getName());
		   		 File fileNodes[]=files[i].listFiles();
		   		 
		   		    for(int j=0;j<1000;j++){
		   		    	
		   		    	System.out.println("calculating"+j);
		   		    	FileInputStream inputstream=new FileInputStream(fileNodes[j]);
		   		    	BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
		   		    	StringBuilder str=new StringBuilder();
		   		    	String tempString=reader.readLine();
		   		    	while(tempString!=null){
		   		    	//	System.out.println(tempString);
		   		    	/*	if(StopWordsHandler.isStopWord(tempString))
		   		    			continue;
		   		    		*/
		   		    	//	System.out.println(tempString);
		   		    		if(wordList.get(i).isEmpty())
		   		    			wordList.get(i).put(tempString, 1);
		   		    		
		   		    		else {
		   		    			if(!wordList.get(i).containsKey(tempString)){
		   		    			wordList.get(i).put(tempString, 1);
		   		    			}
		   		    		    else{
		   		    			if(!str.toString().contains(tempString))
		   		    				wordList.get(i).replace(tempString, wordList.get(i).get(tempString),(int)wordList.get(i).get(tempString)+1);
		   		    			else{
		   		    				//do nothing;
		   		    			}		
		   		    		   }
		   		    		}
		   		    		str=str.append(tempString+" ");
		   		    		tempString=reader.readLine();
		   		    		
		   		    	}
		   		    	reader.close();
		   		    	System.gc();
		   		    }	  
		   		 }
		   	   //   System.out.println(c5Map);
		   	   //   System.out.println(c6Map);
		   	   //   System.out.println(c7Map);
		   	      
		   	      totalMap.putAll(c1Map);
		   	      for(int i=1;i<7;i++){
		   	    	  java.util.Iterator<String> iter= wordList.get(i).keySet().iterator();
		   	    	  while(iter.hasNext()){
		   	    		  String temp=iter.next();
		   	    		  if(!totalMap.containsKey(temp))
		   	    			  totalMap.put(temp, wordList.get(i).get(temp));
		   	    		  else{
		   	    			  totalMap.replace(temp, totalMap.get(temp), totalMap.get(temp)+wordList.get(i).get(temp));
		   	    		  }
		   	    	  }
		   	    	 
		   	      }
		   		 }
	  
 /*
	  public  void condiProbility(){
		  
		  java.util.Iterator<String> iter=totalMap.keySet().iterator();
		  
		  while(iter.hasNext()){
			  
			  String temp=iter.next();
			  int num_word_exist=totalMap.get(temp)*2;
			  System.out.println(num_word_exist);
			  int num_word_not_exist=1000*7*2-num_word_exist;
			  int [] num_class_exist=new int[7];
			  int [] num_class_not_exist=new int[7];
			  float [] ratio_class_exist=new float[7];
			  float [] ratio_class_not_exist=new float[7];
			  float ratioTotal_exist=(float) 0.0;
			  float ratioTotal_not_exist=(float) 0.0;
			  float info=(float) 0.0;
			  
			  for(int i=0;i<7;i++){
				  if(!wordList.get(i).containsKey(temp))
					  num_class_exist[i]=0+1;
				  else
				     num_class_exist[i]=wordList.get(i).get(temp)*2;
				  
				  num_class_not_exist[i]=1000*2-num_class_exist[i];
				  System.out.println(num_class_exist[i]);
			  }
			  
			
			  for(int j=0;j<7;j++){
				ratio_class_exist[j]=(float) (1.0*num_class_exist[j]/(1.0*num_word_exist));
				ratio_class_not_exist[j]=(float)(1.0*num_class_not_exist[j]/(1.0*num_word_not_exist));
			  }
			  
			  for(int j=0;j<7;j++){
				  ratioTotal_exist=(float) (ratioTotal_exist+ratio_class_exist[j]*(Math.log(ratio_class_exist[j])/Math.log(2)));
				  ratioTotal_not_exist=(float) (ratioTotal_not_exist+ratio_class_not_exist[j]*(Math.log(ratio_class_not_exist[j]/Math.log(2))));
			  }
			  System.out.println(ratioTotal_exist);
			  System.out.println(ratioTotal_not_exist);
			  info=(float) (num_word_exist*1.0/(1000*7*2.0)*(-1.0*ratioTotal_exist)+num_word_not_exist*1.0/(1000*7*2.0)*
					  (-1.0*ratioTotal_not_exist));
			  
			 // System.out.println(info);
			  infoGainMap.put(temp, (info_class-info));
			  
		  }
		  
		  
	  }
	
	  
	  public void writeFile(String fileOut) throws Exception{
		   
		  for(int i=0;i<7;i++){
			  System.out.println("writing c"+i+"Map");
			  File file=new File(fileOut+"c"+i+"Map"+".txt");
			  FileOutputStream outputstream=new FileOutputStream(file);
			  BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputstream));
			  java.util.Iterator<String> iter=wordList.get(i).keySet().iterator();
			  while(iter.hasNext()){
				  String temp=iter.next();
				  writer.write(temp);
				  writer.write("  "+wordList.get(i).get(temp));
				  writer.newLine();
			  }
			  writer.close();
		  }
		  
		  File fileTotal=new File(fileOut+"totalMap.txt");
		  FileOutputStream outputstream=new FileOutputStream(fileTotal);
		  BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputstream));
		  java.util.Iterator<String> iter=totalMap.keySet().iterator();
		  
		  while(iter.hasNext()){
			  String temp=iter.next();
			  writer.write(temp);
			  writer.write("  "+totalMap.get(temp));
			  writer.newLine();
		  }
		  writer.close();

		  infoGainMap=sortMap(infoGainMap);
		  File fileInfoGain=new File(fileOut+"infoGaim.txt");
		  FileOutputStream outputstream_info=new FileOutputStream(fileInfoGain);
		  BufferedWriter writer_info=new BufferedWriter(new OutputStreamWriter(outputstream_info));
		  java.util.Iterator<String> iter_info=infoGainMap.keySet().iterator();
		  
		  while(iter_info.hasNext()){
			  String temp=iter_info.next();
			  writer_info.write(temp);
			  writer_info.write("  "+infoGainMap.get(temp));
			  writer_info.newLine();
		  }
		  writer_info.close();
	  }
	  
	  public  Map<String,Float> sortMap(Map<String,Float> oldMap) {  
	        ArrayList<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(oldMap.entrySet());  
	        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {  
	  
	            public int compare(java.util.Map.Entry<java.lang.String, Float> arg0,  
	                    java.util.Map.Entry<java.lang.String, Float> arg1) {  
	                    if(arg0.getValue() - arg1.getValue()>0)
	                    	return -1;
	                    else if(arg0.getValue() - arg1.getValue()<0) 
	                    	return 1;
	                    else
	                    	return 0;
	                		
	            }
	        });  
	        Map<String,Float> newMap = new LinkedHashMap<String,Float>();  
	        for (int i = 0; i < list.size(); i++) {  
	            newMap.put(list.get(i).getKey(), list.get(i).getValue());  
	        }  
	        return newMap;  
	    }  
	  */
	  
	  
	  public Map<String,Integer> getTotalMap(){
			return totalMap;	  
		  }
	  public Map<String,Integer> getc0Map(){
			return wordList.get(0);	  
		  }
	  public Map<String,Integer> getc1Map(){
			return wordList.get(1);	  
		  }
	  public Map<String,Integer> getc2Map(){
			return wordList.get(2);	  
		  }
	  public Map<String,Integer> getc3Map(){
			return wordList.get(3);	  
		  }
	  public Map<String,Integer> getc4Map(){
				return wordList.get(4);	  
			  }
	  public Map<String,Integer> getc5Map(){
			return wordList.get(5);	  
		  }
	  public Map<String,Integer> getc6Map(){
			return wordList.get(6);	  
		  }
	  
	  
}	   
	 

