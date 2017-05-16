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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpParserAll {
	
	
	
	private static String websiteRegex = "http://[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
	private static String _163Regex = "http://([\\w\\-_]+\\.)+163\\.com/[\\w\\-_/]+\\.(shtml|html|htm)";
	private static String sinaRegex = "http://([\\w\\-_]+\\.)+sina\\.com\\.cn/[\\w\\-_/]+\\.(shtml|html|htm)";
	private static String sohuRegex = "http://([\\w\\-_]+\\.)+sohu\\.com/[\\w\\-_/]+\\.(shtml|html|htm)";
	private static String qqRegex = "http://([\\w\\-_]+\\.)+qq\\.com/[\\w\\-_/]+\\.(shtml|html|htm)";
	private static String ifengRegex = "http://([\\w\\-_]+\\.)+ifeng\\.com/[\\w\\-_/]+\\.(shtml|html|htm)";
	private static String xinhuanetRegex = "http://([\\w\\-_]+\\.)+xinhuanet\\.com/[\\w\\-_/]+\\.(shtml|html|htm)";
	 
	public static int websiteType = 0;
	public static String urlstr;
	private static NodeFilter NodeOfTextAndTitle;
	private String fileFromHttp;
	
	public HttpParserAll(String url){
		urlstr=url;
	}
	
	public  String urlJudge() {
		Pattern website = Pattern.compile(websiteRegex);
		Matcher match = website.matcher(urlstr); 			
		int state1=0;
		if(match.find()&&urlstr.startsWith("http")&&(urlstr.endsWith("htm")||urlstr.endsWith("html"))){
			try {
				Parser parser = new Parser("http://www.baidu.com");
				parser.setEncoding("utf-8");					
				NodeList list = parser.parse(null);
				if(list.size()>0){
					try {
						URL url = new URL(urlstr);  
						HttpURLConnection con = (HttpURLConnection) url.openConnection();  
					    state1 = con.getResponseCode();
					    if (state1 == 200)  ;
					    else{
							return("输入网址404错误(网站无法访问)!   请检查是否拼写错误后重新输入！");	
					    }						    	
					} catch (Exception e) {
						return ("连接超时!   请检查网络后重新输入!");	
					}					    
				}
			} catch (ParserException e) {
				return ("连接超时!   请检查网络后重新输入!");	
			}
			websiteType=0;
			
			if(state1==200){
				Pattern Pattern163 =Pattern.compile(_163Regex);
				Matcher match163 = Pattern163.matcher(urlstr); 
				Pattern Patternsina = Pattern.compile(sinaRegex);
				Matcher matchsina = Patternsina.matcher(urlstr); 
				Pattern Patternsohu =Pattern.compile(sohuRegex);
				Matcher matchsohu = Patternsohu.matcher(urlstr); 
				Pattern Patternqq =Pattern.compile(qqRegex);
				Matcher matchqq = Patternqq.matcher(urlstr); 
				Pattern Patternifeng =Pattern.compile(ifengRegex);
				Matcher matchifeng = Patternifeng.matcher(urlstr); 
				Pattern Patternxinhuanet =Pattern.compile(xinhuanetRegex);
				Matcher matchxinhua = Patternxinhuanet.matcher(urlstr); 
				if(match163.find()){
					websiteType = 1;
				}
				if(matchsina.find()){
					websiteType = 2;
				}
				if(matchsohu.find()){
					websiteType = 3;
				}
				if(matchqq.find()){
					websiteType = 4;
				}
				if(matchifeng.find()){
					websiteType = 5;
				}
				if(matchxinhua.find()){
					websiteType = 6;
				}
				if(websiteType==0){
					String temp1="该网站暂且不属于本程序检索范围！\n";
					String temp2="目前程序能处理网易、新浪、腾讯、搜狐、凤凰、新华网中绝大部分新闻页面，该网站可能以下情况导致不能访问：";
				    return (temp1+temp2);
				}else{
					;
				}
			}
		}else{
			return "网址格式错误！    可能是因为网址没有加上http://，请重新输入：";
		}
		return null;
	}
	
	private  void NodeFilterGet(){
		//标题||正文
		switch(websiteType){
		case 1:
			NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("title")||
						node.getText().startsWith("div id=\"endText\"")) {
						
						return true;
					} else {
						return false;
					}
				}
			};						
			break;
		case 2:
			NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().contains("id=\"artibody\"")||
						node.getText().startsWith("title")||
						(node.getText().startsWith("div class=\"blkContainer\"")&&node.getFirstChild().getText().startsWith("p"))) {							
						return true;
					} else {
						return false;
					}
				}
			};						
			break;
		case 3:
			NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("div itemprop=\"articleBody\"")||
						node.getText().contains("id=\"contentText\"")||	
						node.getText().contains("id=\"newscontent\"")||
						node.getText().startsWith("div id=\"content\"")||
						node.getText().startsWith("title")) {
						return true;
					} else {
						return false;
					}
				}
			};						
			break;
		case 4:
			NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("title")||
						node.getText().startsWith("div id=\"Cnt-Main-Article-QQ\"")||
						node.getText().contains("id=\"articleContent\"")) {
						return true;
					} else {
						return false;
					}
				}
			};						
			break;
		case 5:
			NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("div id=\"artical_real\"")||
						node.getText().startsWith("div class=\"arl-c-txt\"")||
						node.getText().startsWith("div class=\"article")||
						node.getText().startsWith("title")) {
						return true;
					} else {
						return false;
					}
				}
			};						
			break;
		case 6:
			NodeOfTextAndTitle = new NodeFilter() {
				public boolean accept(Node node) {
					if (node.getText().startsWith("div id=\"content\"")||
						node.getText().startsWith("title")) {
						return true;
					} else {
						return false;
					}
				}
			};						
			break;
		default :
			break;
		}
	}
	
	public void extractTextByTag() {
		try {
            //生成一个解析器对象，用网页的 url作为参数
			Parser parser = new Parser(urlstr);
			
			//设置网页的编码,这里只是请求了一个 gb2312编码网页
			if(websiteType==4||websiteType==5)
				parser.setEncoding("utf-8");
			else
				parser.setEncoding("gb2312");
			//节点过滤，获得标题以及正文
			NodeFilterGet();
			if(websiteType!=0){
				//迭代所有节点, null 表示不使用 NodeFilter
				NodeList list = parser.parse(NodeOfTextAndTitle);
				if(list.size()>0){
		            //从初始的节点列表跌倒所有的节点
					processNodeList(list);
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	private void processNodeList(NodeList list) {
		//子节点列表扫描器
		SimpleNodeIterator iterator = list.elements();
		while (iterator.hasMoreNodes()) {
			Node node = iterator.nextNode();
				//(node.getText()=="p"||node.getText()=="h1"||node.getText()=="title")
				//得到该节点的子节点列表
				NodeList childList = node.getChildren();
				//孩子节点为空，说明是值节点
				if (null == childList)
				{
					if(node.getParent().getText().matches("p")||
						node.getParent().getText().startsWith("P ")||
						node.getParent().getText().startsWith("p ")||
						node.getParent().getText().startsWith("h2 ")||
						node.getParent().getText().startsWith("h3 ")||
						node.getParent().getText().startsWith("span class=\"JTjsSkJnJTpf\"")||
						node.getParent().getText().matches("title")){
						//得到值节点的值
						String result = node.toPlainTextString();
						result = result.replaceAll("&nbsp", "");
						//result = result.replaceAll(" ", "");
						//除去链接的标点以及头尾，内容作为TXT名
						String txtName = urlstr.replaceAll("[\\pP‘’“”]", "");
						txtName = txtName.replaceAll("http", "");
						txtName = txtName.replaceAll("html", "");
						//写出到txt
						fileFromHttp="./txt/"+txtName+".txt";
						if(result!=""){
							try {
								writeFromBuffer(result,fileFromHttp);
							} catch (IOException e) {
								e.printStackTrace();
							}
							//System.out.println(result);
						}	
					}
				} 
				else 
				{
					processNodeList(childList);
				}
			
		}
	}

	public void writeFromBuffer(String str, String outFileName) throws IOException {
		FileWriter pw = null;
        try {
            pw = new FileWriter(outFileName,true);	            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(str);
        pw.write("\r\n");
        pw.flush();
        pw.close();
    }
	
	public String getFileFromHttp(){
		return fileFromHttp;
	}

}
