package com.guangbo.pachong.auxiwork;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class MySplit {

    private String fileToSplit; //待分词的.txt文件
    private String fileSplited; //已分词处理过的文件
    private LinkedList<String> wordList;  //将文档分好的词保存到wordList中

    public MySplit() {

    }

    public MySplit(String fileToSplit) throws Exception {
        this.fileToSplit = fileToSplit;
//        this.fileSplited = fileToSplit.replace(".txt", "Splited.txt");

        wordList = new LinkedList<String>();
        //fileSplit_save();
        //fileSplit_List();
    }

    // 分词后的结果保存到输出文件中
    public void fileSplit_save() throws IOException {
        File fileIn = new File(fileToSplit);
        File fileOut = new File(fileSplited);
        FileInputStream inputstream = new FileInputStream(fileIn);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
        FileOutputStream outputstream = new FileOutputStream(fileOut);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputstream));
        String tempString = reader.readLine();


        while (tempString != null) {

            if (tempString.matches("\\s*"))  //过滤掉空行
            {
                tempString = reader.readLine();
                continue;
            }

            tempString = tempString.trim();
            String result = tempString.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");  //过滤掉奇怪的符号
            tempString = result;

            List<Term> parse = ToAnalysis.parse(tempString);
            String tempSplited = parse.toString();
            tempSplited = tempSplited.replace("[", "");  //过滤掉分词后产生的前端后端符号
            tempSplited = tempSplited.replace("]", "");
            String[] tempArray = tempSplited.split("\\,");

            for (int j = 0; j < tempArray.length; j++) {
                tempArray[j] = tempArray[j].trim();
                System.out.println(tempArray[j]);
                writer.write(tempArray[j]);
                writer.newLine();
            }

            tempString = reader.readLine();
        }

        writer.close();
        reader.close();
    }

    // 分词后的结果保存到LinkedList中
    public void fileSplit_List() throws Exception {
        File fileIn = new File(fileToSplit);
        FileInputStream inputstream = new FileInputStream(fileIn);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
        String tempString = reader.readLine();

//        while (tempString != null) {
//
//            if (tempString.matches("\\s*"))  //过滤掉空行
//            {
//                tempString = reader.readLine();
//                continue;
//            }
//
//            tempString = tempString.trim();
//            String result = tempString.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");  //过滤掉奇怪的符号
//            tempString = result;
//
//            List<Term> parse = ToAnalysis.parse(tempString);
//            String tempSplited = parse.toString();
//            tempSplited = tempSplited.replace("[", "");  //过滤掉分词后产生的前端后端符号
//            tempSplited = tempSplited.replace("]", "");
//            String[] tempArray = tempSplited.split("\\,");
//
//            for (int j = 0; j < tempArray.length; j++) {
//                tempArray[j] = tempArray[j].trim();
//                wordList.add(tempArray[j]);
//            }
//            tempString = reader.readLine();
//        }
        reader.close();

    }

    public String getfileSplited() {
        return fileSplited;
    }

    public LinkedList<String> getWordList() {
        return wordList;
    }
}
