package com.guangbo.pachong.newsClassify;


import com.guangbo.pachong.bayesModel.BayesManager;
import com.guangbo.pachong.eventHandler.HttpButtonHandler;
import com.guangbo.service.impl.PaChongServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class GraphModel {
	
	private JFrame frame;
	private JLabel headLabel;
	private JButton httpButton;
	private JButton txtButton;
	private JButton readFileButton;
	private JLabel httpLabel;
	private JLabel txtLabel;
	private JTextField httpTextField;
	private JTextField txtTextField;
	private FileDialog openDialog;
	private JLabel resultLabel;
	private JTextArea resultTextArea;
	private JLabel endLabel;
	
	private BayesManager bayes;
	private Map<String,float[]> bayesMap;


	public GraphModel() throws Exception {
		bayes=new BayesManager();
		bayesMap=bayes.getProbMap();
	}

	public void start() {
		String httpAddress = "http://sports.sohu.com/20170515/n493100280.shtml";
		try {
			HttpButtonHandler httpButtonHandler=new HttpButtonHandler(httpAddress,bayesMap);
			String temp=httpButtonHandler.doHttpConnect();
			boolean httpFlag=httpButtonHandler.getFlag();
			if(httpFlag){
				System.out.println("爬虫得到的文件为");
				System.out.println("爬虫得到的文件为：");
				System.out.println(temp+"\n");
				System.out.println("现在进行分词......\n");
				String splitNotice=httpButtonHandler.doSplit(temp);
				System.out.println(splitNotice+"\n");
				String classifyNotice=httpButtonHandler.doClassify();
				System.out.println(classifyNotice+"\n");
				String result=httpButtonHandler.getResult();
				System.out.println(result);
			}
			else{
				System.out.println(temp);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public String[] fenlei(String url) throws Exception {
//		String url = "http://finance.sina.com.cn/stock/s/2017-05-16/doc-ifyfeivp5752185.shtml";
		PaChongServiceImpl paChongService = new PaChongServiceImpl();
		String filePath = paChongService.getTextMes(url);
		HttpButtonHandler httpButtonHandler=new HttpButtonHandler("",bayesMap);
		String splitNotice=httpButtonHandler.doSplit(filePath);
		System.out.println(splitNotice+"\n");
		String classifyNotice=httpButtonHandler.doClassify();
		System.out.println(classifyNotice+"\n");
		String result=httpButtonHandler.getResult();
		System.out.println(result);
		String[] ans = new String[2];
		ans[0] = paChongService.getLastText();
		ans[1] = result;
		return ans;

	}
	public static void main(String[] args) throws Exception {
		GraphModel graphModel = new GraphModel();
		graphModel.fenlei("http://finance.sina.com.cn/stock/s/2017-05-16/doc-ifyfeivp5752185.shtml");

	}

}
