package com.guangbo.pachong.auxiwork;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MyHttpParser {
    
	private String httpAddress;
	private String fileFromHttp;
	
	public MyHttpParser(){
		httpAddress=null;
		fileFromHttp=null;
	}
	
	public MyHttpParser(String url){
		this.httpAddress=url;
		doHttpParser(httpAddress);
	}
	
	public void doHttpParser(String url){
		try {
	           
			Parser parser = new Parser(url);
			parser.setEncoding("gb2312");//������ҳ�ı���,����ֻ��������һ�� gb2312 ������ҳ
			NodeFilter NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("div id=\"endText\"")||node.getText().startsWith("h1 id=\"h1title\"")) {
						return true;
					} else {
						return false;
					}
				}
			}; 
			
			NodeList list = parser.parse(NodeOfTextAndTitle);//�������нڵ�, null ��ʾ��ʹ�� NodeFilter   
		    fileFromHttp=processNodeList(list,url);//�ӳ�ʼ�Ľڵ��б�������еĽڵ㣬�������ĵ�����
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
	
	private  String processNodeList(NodeList list,String httpAddress) {
		
			String fileName=null;
			String txtName = httpAddress.replaceAll("[\\pP��������]", "");//��ȥ���ӵı���Լ�ͷβ��������ΪTXT��
			txtName = txtName.replaceAll("http", "");
			txtName = txtName.replaceAll("html", "");
			fileName="./txt/"+txtName+".txt";
			
			SimpleNodeIterator iterator = list.elements();//������
			while (iterator.hasMoreNodes()) {
				Node node = iterator.nextNode();
				NodeList childList = node.getChildren();//�õ��ýڵ���ӽڵ��б�
				//���ӽڵ�Ϊ�գ�˵����ֵ�ڵ�
				if (null == childList)
				{
					String result = node.toPlainTextString();//�õ�ֵ�ڵ��ֵ
					
					try {
						writeFromBuffer(result,fileName);
					} catch (IOException e) {
						e.printStackTrace();
					}
				//	System.out.println(result);
				} 
				else 
				{
					processNodeList(childList,httpAddress);
				}
				
			}	
			return fileName;
		}

	private void writeFromBuffer(String str, String outFileName) throws IOException {
			FileWriter pw = null;
	        try {
	            pw = new FileWriter(outFileName,true);	
	            
	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        pw.write(str);
	        pw.flush();
	        pw.close();
	      }
	   
	
     public String getFileFromHttp(){
    	 return fileFromHttp;
     }
}
