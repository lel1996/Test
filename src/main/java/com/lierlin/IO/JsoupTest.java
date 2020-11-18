package com.lierlin.IO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
        String dataString = "";
        StringBuilder StringData = new StringBuilder(10000);
        BufferedReader beader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/lierlin/Desktop/ecrp/1.html"), "UTF-8"));
        char[] buf = new char[1024];
        int num = 0;
        while ((num = beader.read(buf)) != -1) {
            String data = String.valueOf(buf, 0, num);
            StringData.append(data);
            buf = new char[1024];
        }
        dataString = StringData.toString();
        Document doc= Jsoup.parse(dataString,"UTF-8");
        Elements element =doc.select(".m-repbody");
        for (Element elements:element) {
                
        }
        System.out.println(element.toString());
        //System.out.println(dataString);
   /*     Document doc =Jsoup.connect("http://www.jd.com") .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();;
        System.out.println(doc);*/

    }
}
/*==================================================================================*/
/*==================================================================================*/
class JsoupDemo{

}