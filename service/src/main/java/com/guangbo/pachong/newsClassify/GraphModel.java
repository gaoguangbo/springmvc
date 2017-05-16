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
//	   frame=new JFrame("��ҳ�ı�����ϵͳ");
//	   frame.setSize(1000,700);
//	   frame.setResizable(false);
//	   frame.setLocation(0, 0);
//	   frame.setLayout(null);//��仰����Ҫ�����û�еĻ�������ľ��Զ�λ��Ч
//
//
//	   Font fontLabel=new Font("Serief",Font.BOLD,28);
//	   headLabel=new JLabel("��ҳ�ı�����ϵͳ",SwingConstants.CENTER);
//	   headLabel.setFont(fontLabel);
//	   headLabel.setBounds(0, 0, 1000, 70);
//	   headLabel.setBackground(Color.gray);
//	   headLabel.setOpaque(true);
//
//
//	   Font httpLabelFont=new Font("Serief",Font.BOLD,18);
//	   Font httpButtonFont=new Font("serief",Font.BOLD,18);
//	   Font httpTextFieldFont=new Font("serief",Font.ITALIC,15);
//	   httpLabel=new JLabel("������ҳhttp��ַ��",SwingConstants.RIGHT);
//	   httpTextField=new JTextField("���ڴ˴�������ҳ��ַ");
//	   httpButton=new JButton("�ύ");
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
//	   txtLabel=new JLabel("�ӱ����ļ��ж�ȡ��ҳ��ַ��",SwingConstants.RIGHT);
//	   txtTextField=new JTextField("�����ļ���ַ");
//	   txtButton=new JButton("�ύ");
//	   txtLabel.setFont(txtLabelFont);
//	   txtTextField.setFont(txtTextFieldFont);
//	   txtButton.setFont(txtButtonFont);
//	   txtLabel.setBounds(50,200,250,50);
//	   txtTextField.setBounds(305,200,300,30);
//	   txtButton.setBounds(650, 200, 100, 40);
//	   readFileButton=new JButton("�����ļ�...");
//	   readFileButton.setFont(readFileFont);
//	   readFileButton.setBounds(305, 230, 130, 40);
//
//
//	   Font resultLabelFont=new Font("serief",Font.BOLD,18);
//	   Font resultTextAreaFont=new Font("serief",Font.ITALIC,15);
//	   resultLabel=new JLabel("������",SwingConstants.NORTH_EAST);
//	   resultLabel.setFont(resultLabelFont);
//	   resultTextArea=new JTextArea();
//	   resultTextArea.setFont(resultTextAreaFont);
//	   resultTextArea.setText("����������ʾ�����");
//	   resultLabel.setBounds(100, 300, 100, 50);
//	   resultTextArea.setBounds(200, 300, 700, 300);
//
//
//	   endLabel=new JLabel("��Ϣ����            �ı�����",SwingConstants.CENTER);
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
//			   //httpTextField.setText("���ڴ˴�������ҳ��ַ");
//		   }
//	   });
//
//
//
//
//	   readFileButton.addActionListener(new ActionListener()
//	   {
//		   public void actionPerformed(ActionEvent e){
//			   openDialog=new FileDialog(frame,"�ҵĴ�",FileDialog.LOAD);
//			   openDialog.setVisible(true);
//			   String dirPath=openDialog.getDirectory();
//			   String fileName=openDialog.getFile();
//
//			   if(dirPath==null||fileName==null){
//				   txtTextField.setText("û��ѡ���κ��ļ�");
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
//			  httpTextField.setText("���ڴ˴�������ҳ��ַ");
//
//			try {
//				 HttpButtonHandler httpButtonHandler=new HttpButtonHandler(httpAddress,bayesMap);
//				 String temp=httpButtonHandler.doHttpConnect();
//				 boolean httpFlag=httpButtonHandler.getFlag();
//				 if(httpFlag){
//					 Font textAreaFont=new Font("Serief",Font.BOLD,20);
//					 resultTextArea.setFont(textAreaFont);
//					 resultTextArea.setText("");
//					 resultTextArea.setText("����õ����ļ�Ϊ��");
//					 resultTextArea.append(temp+"\n");
//					 resultTextArea.append("���ڽ��зִ�......\n");
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
//							   resultTextArea.append("��"+j+"������:"+tempResult+"\n");
//						   }
//					    else{
//					    	String tempJudger=urlIter.next();
//					    	resultTextArea.append("��"+j+"������:"+tempJudger+"\n");
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
				System.out.println("����õ����ļ�Ϊ");
				System.out.println("����õ����ļ�Ϊ��");
				System.out.println(temp+"\n");
				System.out.println("���ڽ��зִ�......\n");
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
		String content = "�й�������Ⱥݻ����¯ ������������������-�Ѻ�����Ƶ��\n" +
				"�����ع�2014�꣬�й���Ϊһ�������ε����˴�����ڹ�����̨�ϵ�����Խ��Խ��Ҫ�Ľ�ɫ�����ͬʱ��������Ϊ�׵�ĳЩ����ȴ���⡰�ۺ족�����������޶�ָ��������������ƫ�ܣ�ʹ��һЩС���������ӣ���ͼ��ʳ�й��Ĺ������档\n" +
				"�������������ʱ�򣬽�ž�����Ϊ����ı����ߣ�������ԥ��ͦ�������\n" +
				"�������ǵö���������˵�ݻ��ķ���������ô��\n" +
				"�������ǵ���ʤ������ʱ��ǿӲ��̬ô��\n" +
				"�������ǵ��������ڻ᳡����һŭ���Ѹ巢��ô��\n" +
				"������һ�Σ����������̵�һ����2014�����Ź����ݻ����Ľ�ž������ǣ��������˭?\n" +
				"����������\n" +
				"���������������������������ձ�˵�Ļ���Ӳ �й����񲻰���\n" +
				"����4��8�գ������ί����ϯ����������������ʱ�����������ż��ߵ���̹�ԶԹ������ǰ�����б�ʾ������\n" +
				"�����������������붫�˷�����һЩ���������ձ�����ý��Ľ�����̬�Ⱥ�Ӳ��̬�Ⱥ��������й���������Ҹ��˿����Ժ��ǲ�����ġ�\n" +
				"������������С�ֱࣺ���˵���Ψ�ҷ��󽫾������鷶�����´��͵���ʷ�������Ա�ͽ����ǣ����ǲ������㵺���Ϻ���ʷ��Ҳ����ʲô���ձ��������壬��ȥ�ú�ѧѧ��\n" +
				"���������Ķ���\n" +
				"����\n" +
				"����\n" +
				"�����ع�2014�꣬�й���Ϊһ�������ε����˴�����ڹ�����̨�ϵ�����Խ��Խ��Ҫ�Ľ�ɫ�����ͬʱ��������Ϊ�׵�ĳЩ����ȴ���⡰�ۺ족�����������޶�ָ��������������ƫ�ܣ�ʹ��һЩС���������ӣ���ͼ��ʳ�й��Ĺ������档\n" +
				"�������������ʱ�򣬽�ž�����Ϊ����ı����ߣ�������ԥ��ͦ�������\n" +
				"�������ǵö���������˵�ݻ��ķ���������ô��\n" +
				"�������ǵ���ʤ������ʱ��ǿӲ��̬ô��\n" +
				"�������ǵ��������ڻ᳡����һŭ���Ѹ巢��ô��\n" +
				"������һ�Σ����������̵�һ����2014�����Ź����ݻ����Ľ�ž������ǣ��������˭?\n" +
				"����������\n" +
				"���������������������������ձ�˵�Ļ���Ӳ �й����񲻰���\n" +
				"����4��8�գ������ί����ϯ����������������ʱ�����������ż��ߵ���̹�ԶԹ������ǰ�����б�ʾ������\n" +
				"�����������������붫�˷�����һЩ���������ձ�����ý��Ľ�����̬�Ⱥ�Ӳ��̬�Ⱥ��������й���������Ҹ��˿����Ժ��ǲ�����ġ�\n" +
				"������������С�ֱࣺ���˵���Ψ�ҷ��󽫾������鷶�����´��͵���ʷ�������Ա�ͽ����ǣ����ǲ������㵺���Ϻ���ʷ��Ҳ����ʲô���ձ��������壬��ȥ�ú�ѧѧ��\n" +
				"���������Ķ���";
		graphModel.fenlei();

	}

}
