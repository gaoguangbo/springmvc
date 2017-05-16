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
	
	
//	public GraphModel() throws Exception{
//
//
//	   frame=new JFrame("网页文本分类系统");
//	   frame.setSize(1000,700);
//	   frame.setResizable(false);
//	   frame.setLocation(0, 0);
//	   frame.setLayout(null);//这句话很重要，如果没有的话，后面的绝对定位无效
//
//
//	   Font fontLabel=new Font("Serief",Font.BOLD,28);
//	   headLabel=new JLabel("网页文本分类系统",SwingConstants.CENTER);
//	   headLabel.setFont(fontLabel);
//	   headLabel.setBounds(0, 0, 1000, 70);
//	   headLabel.setBackground(Color.gray);
//	   headLabel.setOpaque(true);
//
//
//	   Font httpLabelFont=new Font("Serief",Font.BOLD,18);
//	   Font httpButtonFont=new Font("serief",Font.BOLD,18);
//	   Font httpTextFieldFont=new Font("serief",Font.ITALIC,15);
//	   httpLabel=new JLabel("输入网页http地址：",SwingConstants.RIGHT);
//	   httpTextField=new JTextField("请在此处输入网页地址");
//	   httpButton=new JButton("提交");
//	   httpLabel.setFont(httpLabelFont);
//	   httpTextField.setFont(httpTextFieldFont);
//	   httpButton.setFont(httpButtonFont);
//	   httpLabel.setBounds(100, 100, 200, 50);
//	   httpTextField.setBounds(305, 100, 300, 40);
//	   httpButton.setBounds(650, 100, 100, 40);
//
//
//	   Font txtLabelFont=new Font("Serief",Font.BOLD,18);
//	   Font txtButtonFont=new Font("serief",Font.BOLD,18);
//	   Font txtTextFieldFont=new Font("serief",Font.ITALIC,15);
//	   Font readFileFont=new Font("serief",Font.ITALIC,18);
//	   txtLabel=new JLabel("从本地文件中读取网页地址：",SwingConstants.RIGHT);
//	   txtTextField=new JTextField("输入文件地址");
//	   txtButton=new JButton("提交");
//	   txtLabel.setFont(txtLabelFont);
//	   txtTextField.setFont(txtTextFieldFont);
//	   txtButton.setFont(txtButtonFont);
//	   txtLabel.setBounds(50,200,250,50);
//	   txtTextField.setBounds(305,200,300,30);
//	   txtButton.setBounds(650, 200, 100, 40);
//	   readFileButton=new JButton("本地文件...");
//	   readFileButton.setFont(readFileFont);
//	   readFileButton.setBounds(305, 230, 130, 40);
//
//
//	   Font resultLabelFont=new Font("serief",Font.BOLD,18);
//	   Font resultTextAreaFont=new Font("serief",Font.ITALIC,15);
//	   resultLabel=new JLabel("分类结果",SwingConstants.NORTH_EAST);
//	   resultLabel.setFont(resultLabelFont);
//	   resultTextArea=new JTextArea();
//	   resultTextArea.setFont(resultTextAreaFont);
//	   resultTextArea.setText("分类结果会显示在这里：");
//	   resultLabel.setBounds(100, 300, 100, 50);
//	   resultTextArea.setBounds(200, 300, 700, 300);
//
//
//	   endLabel=new JLabel("信息检索            文本分类",SwingConstants.CENTER);
//	   Font endLabelFont=new Font("Serief",Font.BOLD,25);
//	   endLabel.setFont(endLabelFont);
//	   endLabel.setBounds(0, 600, 1000, 70);
//	   endLabel.setOpaque(true);
//	   endLabel.setBackground(Color.green);
//
//	   frame.add(headLabel);
//	   frame.add(httpLabel);
//	   frame.add(httpTextField);
//	   frame.add(httpButton);
//	   frame.add(txtLabel);
//	   frame.add(txtTextField);
//	   frame.add(txtButton);
//	   frame.add(readFileButton);
//	   frame.add(resultLabel);
//	   frame.add(resultTextArea);
//	   frame.add(endLabel);
//	   frame.setVisible(true);
//
//
//
//
//	   httpTextField.addFocusListener(new FocusListener(){
//		  public void focusGained(FocusEvent e){
//			   httpTextField.setText("");
//		   }
//		  public void focusLost(FocusEvent e){
//			   //httpTextField.setText("请在此处输入网页地址");
//		   }
//	   });
//
//
//
//
//	   readFileButton.addActionListener(new ActionListener()
//	   {
//		   public void actionPerformed(ActionEvent e){
//			   openDialog=new FileDialog(frame,"我的打开",FileDialog.LOAD);
//			   openDialog.setVisible(true);
//			   String dirPath=openDialog.getDirectory();
//			   String fileName=openDialog.getFile();
//
//			   if(dirPath==null||fileName==null){
//				   txtTextField.setText("没有选中任何文件");
//				   return;
//			   }
//			   else
//			   txtTextField.setText(dirPath+fileName);
//		   }
//	   }
//	   );
//
//	   httpButton.addActionListener(new ActionListener(){
//		   public void actionPerformed(ActionEvent e){
//			  String httpAddress=httpTextField.getText();
//			  httpTextField.setText("请在此处输入网页地址");
//
//			try {
//				 HttpButtonHandler httpButtonHandler=new HttpButtonHandler(httpAddress,bayesMap);
//				 String temp=httpButtonHandler.doHttpConnect();
//				 boolean httpFlag=httpButtonHandler.getFlag();
//				 if(httpFlag){
//					 Font textAreaFont=new Font("Serief",Font.BOLD,20);
//					 resultTextArea.setFont(textAreaFont);
//					 resultTextArea.setText("");
//					 resultTextArea.setText("爬虫得到的文件为：");
//					 resultTextArea.append(temp+"\n");
//					 resultTextArea.append("现在进行分词......\n");
//					 String splitNotice=httpButtonHandler.doSplit(temp);
//					 resultTextArea.append(splitNotice+"\n");
//					 String classifyNotice=httpButtonHandler.doClassify();
//					 resultTextArea.append(classifyNotice+"\n");
//					 String result=httpButtonHandler.getResult();
//					 resultTextArea.append(result);
//				 }
//				 else{
//					 resultTextArea.setForeground(Color.RED);
//					 resultTextArea.setText(temp);
//
//				 }
//
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		   }
//	   });
//
//
//	   txtButton.addActionListener(new ActionListener(){
//		   public void actionPerformed(ActionEvent e){
//			   String filePath=txtTextField.getText();
//			   System.out.println(filePath);
//
//			   try{
//				   Font textAreaFont=new Font("Serief",Font.BOLD,20);
//				   resultTextArea.setFont(textAreaFont);
//				   TxtButtonHandler txtButtonHandler=new TxtButtonHandler(filePath,bayesMap);
//				   String readFileNotice=txtButtonHandler.readFileContent();
//				   resultTextArea.setText(readFileNotice+"\n");
//				   String httpNotice=txtButtonHandler.dohttpConnect();
//				   resultTextArea.append(httpNotice+"\n");
//				   String splitNotice=txtButtonHandler.doSplit();
//				   resultTextArea.append(splitNotice+"\n");
//				   String classifyNotice=txtButtonHandler.doClassify();
//				   resultTextArea.append(classifyNotice+"\n");
//				   LinkedList<Boolean> httpFlagList=txtButtonHandler.getFlagList();
//				   LinkedList<String> urlJudgerList=txtButtonHandler.getUrlJudger();
//				   LinkedList<String> resultList=txtButtonHandler.getResult();
//				   Iterator<String> urlIter=urlJudgerList.iterator();
//				   Iterator<String> resultIter=resultList.iterator();
//				   for(int i=0;i<httpFlagList.size();i++){
//					   int j=i+1;
//					   if(httpFlagList.get(i)){
//							   String tempResult=resultIter.next();
//							   resultTextArea.append("第"+j+"个链接:"+tempResult+"\n");
//						   }
//					    else{
//					    	String tempJudger=urlIter.next();
//					    	resultTextArea.append("第"+j+"个链接:"+tempJudger+"\n");
//						   }
//					   }
//			   }catch(Exception e2){
//				   e2.printStackTrace();
//
//			   }
//
//		   }
//	   });
//
//	   frame.addWindowListener(new WindowAdapter(){
//		   public void windowClosing(WindowEvent e){
//			   System.exit(1);
//		   }
//	   });
//
//	   bayes=new BayesManager();
//	   bayesMap=bayes.getProbMap();
//   }

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

	public void fenlei() throws Exception {
		String url = "http://finance.sina.com.cn/stock/s/2017-05-16/doc-ifyfeivp5752185.shtml";
		PaChongServiceImpl paChongService = new PaChongServiceImpl();
		String filePath = paChongService.getTextMes(url);
		HttpButtonHandler httpButtonHandler=new HttpButtonHandler("",bayesMap);
		String splitNotice=httpButtonHandler.doSplit(filePath);
		System.out.println(splitNotice+"\n");
		String classifyNotice=httpButtonHandler.doClassify();
		System.out.println(classifyNotice+"\n");
		String result=httpButtonHandler.getResult();
		System.out.println(result);
	}
	public static void main(String[] args) throws Exception {
		GraphModel graphModel = new GraphModel();
		String content = "中国将军年度狠话榜出炉 范长龙面斥美防长夺冠-搜狐军事频道\n" +
				"　　回顾2014年，中国作为一个负责任的新兴大国，在国际舞台上担任起越来越重要的角色。与此同时，以美国为首的某些势力却分外“眼红”，不但处处无端指责，甚至还拉起了偏架，使得一些小国蠢蠢欲从，企图蚕食中国的国家利益。\n" +
				"　　而就在这个时候，解放军，作为祖国的保护者，毫不犹豫地挺身而出：\n" +
				"　　还记得对美国防长说狠话的范长龙将军么？\n" +
				"　　还记得吴胜利访美时的强硬表态么？\n" +
				"　　还记得王冠中在会场里冲冠一怒，脱稿发言么？\n" +
				"　　这一次，就让我们盘点一下在2014年对外放过“狠话”的解放军将军们，看看你最爱谁?\n" +
				"　　范长龙\n" +
				"　　范长龙狠批美防长：你在日本说的话很硬 中国人民不爱听\n" +
				"　　4月8日，中央军委副主席范长龙与哈格尔会晤时，范长龙当着记者的面坦言对哈格尔日前的言行表示不满。\n" +
				"　　范长龙：你在与东盟防长的一些讲话和在日本政界媒体的讲话，态度很硬，态度很鲜明，中国人民包括我个人看了以后是不满意的。\n" +
				"　　东方军事小编：直言了当！唯我范大将军。建议范将军下次送点历史书给美官员和将军们，他们不懂钓鱼岛和南海历史，也不懂什么是日本军国主义，回去好好学学。\n" +
				"　　延伸阅读：\n" +
				"　　\n" +
				"　　\n" +
				"　　回顾2014年，中国作为一个负责任的新兴大国，在国际舞台上担任起越来越重要的角色。与此同时，以美国为首的某些势力却分外“眼红”，不但处处无端指责，甚至还拉起了偏架，使得一些小国蠢蠢欲从，企图蚕食中国的国家利益。\n" +
				"　　而就在这个时候，解放军，作为祖国的保护者，毫不犹豫地挺身而出：\n" +
				"　　还记得对美国防长说狠话的范长龙将军么？\n" +
				"　　还记得吴胜利访美时的强硬表态么？\n" +
				"　　还记得王冠中在会场里冲冠一怒，脱稿发言么？\n" +
				"　　这一次，就让我们盘点一下在2014年对外放过“狠话”的解放军将军们，看看你最爱谁?\n" +
				"　　范长龙\n" +
				"　　范长龙狠批美防长：你在日本说的话很硬 中国人民不爱听\n" +
				"　　4月8日，中央军委副主席范长龙与哈格尔会晤时，范长龙当着记者的面坦言对哈格尔日前的言行表示不满。\n" +
				"　　范长龙：你在与东盟防长的一些讲话和在日本政界媒体的讲话，态度很硬，态度很鲜明，中国人民包括我个人看了以后是不满意的。\n" +
				"　　东方军事小编：直言了当！唯我范大将军。建议范将军下次送点历史书给美官员和将军们，他们不懂钓鱼岛和南海历史，也不懂什么是日本军国主义，回去好好学学。\n" +
				"　　延伸阅读：";
		graphModel.fenlei();

	}

}
