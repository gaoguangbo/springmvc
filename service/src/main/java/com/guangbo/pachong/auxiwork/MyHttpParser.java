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
			parser.setEncoding("gb2312");//设置网页的编码,这里只是请求了一个 gb2312 编码网页
			NodeFilter NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("div id=\"endText\"")||node.getText().startsWith("h1 id=\"h1title\"")) {
						return true;
					} else {
						return false;
					}
				}
			}; 
			
			NodeList list = parser.parse(NodeOfTextAndTitle);//迭代所有节点, null 表示不使用 NodeFilter   
		    fileFromHttp=processNodeList(list,url);//从初始的节点列表跌倒所有的节点，并返回文档名称
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
	
	private  String processNodeList(NodeList list,String httpAddress) {
		
			String fileName=null;
			String txtName = httpAddress.replaceAll("[\\pP‘’“”]", "");//除去链接的标点以及头尾，内容作为TXT名
			txtName = txtName.replaceAll("http", "");
			txtName = txtName.replaceAll("html", "");
			fileName="./txt/"+txtName+".txt";
			
			SimpleNodeIterator iterator = list.elements();//迭代器
			while (iterator.hasMoreNodes()) {
				Node node = iterator.nextNode();
				NodeList childList = node.getChildren();//得到该节点的子节点列表
				//孩子节点为空，说明是值节点
				if (null == childList)
				{
					String result = node.toPlainTextString();//得到值节点的值
					
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
