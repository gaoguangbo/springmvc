package com.guangbo.service.impl;
import com.guangbo.service.IPaChongService;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Created by gaoguangbo on 2017/5/16.
 */
public class PaChongServiceImpl implements IPaChongService {
    private String lastText;

    public String getLastText() {
        return lastText;
    }

    public void setLastText(String lastText) {
        this.lastText = lastText;
    }
    public String getNewsByUrl(String url) {

        return null;
    }

    public  void getUrlAndTitle() {
        String url = "http://finance.sina.com.cn/";
        try {
            Document doc = Jsoup.connect(url).timeout(10000).get();//get all infomation from url website
            //System.out.println(doc);
            Elements ListDiv = doc.getElementsByAttributeValue("class", "fin_tabs0_c0");
            //System.out.println(ListDiv);
            for (Element div : ListDiv) {
                Elements links = div.getElementsByTag("a");
                // System.out.println(links);
                for (Element link : links) {
                    String linkHref = link.attr("href").trim();
                    String linkText = link.text().trim();
                    System.out.println(linkHref + "\t" + linkText);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  String getTextMes(String url) {
        String textMes = "";
        String localPath = "/Users/gaoguangbo/Documents/java/springmvc/service/src/main/resources/txt/";
        long onlyName ;
        String path="";
        try {
            Document doc = Jsoup.connect(url).timeout(10000).get();
//            Elements ListDiv = doc.getElementsByAttributeValue("class", "blkContainerSblkCon BSHARE_POP");
            Element MainDiv = doc.getElementById("artibody");
            //System.out.println(ListDiv);
            Elements ps = MainDiv.getElementsByTag("p");
            String all ="";
            String html = ps.html();
            String outhtml = ps.outerHtml();
            String text1 = ps.text();
            String text2 = ps.toString();

            for (Element p : ps) {
                String text = p.text();
             all += text;
            }
            this.lastText = all;
            System.out.println(all);
//            for (Element div : ListDiv) {
//                Elements textInfos = div.getElementsByTag("p");
//                //System.out.println(textInfos);
//                for (Element textInfo : textInfos) {
//                    String text = textInfo.text().trim();
//                    textMes = textMes + text + "\n";
//                }
//            }
            System.out.println(all);
            onlyName = new Date().getTime();
            path = localPath+onlyName+".txt";
            writeFromBuffer(all,""+path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
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

    public static void main(String[] args) {
        List<Term> word = ToAnalysis.parse("个别地区违法违规举债担保时有发生");
        System.out.println(word);
    }
}
