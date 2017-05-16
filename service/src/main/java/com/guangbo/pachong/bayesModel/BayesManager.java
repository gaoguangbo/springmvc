package com.guangbo.pachong.bayesModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class BayesManager {
	
	private Map<String,float[]> probMap; 
	private String feactureFilePath;
	private Map<String,Float> c0Map;
	private Map<String,Float> c1Map;
	private Map<String,Float> c2Map;
	private Map<String,Float> c3Map;
	private Map<String,Float> c4Map;
	private Map<String,Float> c5Map;
	private Map<String,Float> c6Map;
	private LinkedList<Map<String,Float>> mapList;
	
	private final int num_files=1000;
	
	public BayesManager() throws Exception{
		
		feactureFilePath="/Users/gaoguangbo/Documents/java/springmvc/service/src/main/resources/wordMap/feacture_1000_new.txt";
		probMap=new LinkedHashMap<String,float[]>();
		mapList=new LinkedList<Map<String,Float>>();
		c0Map=new LinkedHashMap<String,Float>();
		c1Map=new LinkedHashMap<String,Float>();
		c2Map=new LinkedHashMap<String,Float>();
		c3Map=new LinkedHashMap<String,Float>();
		c4Map=new LinkedHashMap<String,Float>();
		c5Map=new LinkedHashMap<String,Float>();
		c6Map=new LinkedHashMap<String,Float>();
		mapList.add(c0Map);
		mapList.add(c1Map);
		mapList.add(c2Map);
		mapList.add(c3Map);
		mapList.add(c4Map);
		mapList.add(c5Map);
		mapList.add(c6Map);
	
		
		searchForMap();
		probCalcu();
		
		
	}
	
	public BayesManager(String str){
		this.feactureFilePath=str;
		probMap=new LinkedHashMap<String,float[]>();
	}
	
	public void searchForMap() throws Exception{
		for(int i=0;i<7;i++){
			File file=new File("/Users/gaoguangbo/Documents/java/springmvc/service/src/main/resources/wordMapreWc"+i+"Map.txt");
		    FileInputStream inputstream=new FileInputStream(file);
		    BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
		    String tempString=reader.readLine();
		    while(tempString!=null){
		    	String temp=tempString.replaceAll("\\d+", "");
		    	temp=temp.trim();
		    	String digitString=tempString.replaceAll(".*[^\\d](?=(\\d+))","").trim();
		    	float digit=Float.parseFloat(digitString);
		    	mapList.get(i).put(temp,digit );
		    	tempString=reader.readLine();
		    }
		    reader.close();
		   // System.out.println(mapList.get(i));
		}
	}
	
	
	public void  probCalcu() throws Exception{
		
		File feactureFile=new File(feactureFilePath);
		FileInputStream inputstream=new FileInputStream(feactureFile);
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));
		String tempString=reader.readLine();
		
		while(tempString!=null){
			tempString=tempString.trim();
			float[] tempFloat=new float[7];
			for(int i=0;i<7;i++){
				if(mapList.get(i).containsKey(tempString))
					tempFloat[i]=mapList.get(i).get(tempString);
				else
			        tempFloat[i]=1;
				tempFloat[i]=(float) Math.log(tempFloat[i]/num_files);
			}
			probMap.put(tempString, tempFloat);
			tempString=reader.readLine();
		}
		reader.close();
		
		/*
		System.out.println(probMap.keySet());
		Iterator<String> iter=probMap.keySet().iterator();
		while(iter.hasNext()){
			String temp= iter.next();
			System.out.println(probMap.get(temp)[2]);
		}
			
	    */
	}
	
	public Map<String,float[]> getProbMap(){
		return probMap;
	}
	
	/*
	public static void main(String []args) throws Exception{
		TrainManager manager=new TrainManager();
	}
	*/
	}
	
