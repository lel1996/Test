package com.lierlin.集合.Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/*C:\Users\Administrator.DESKTOP-MSGCJJH\Desktop\阳光xml\企业*/
public class MapWork {
    public static void main(String[] args) {

        Map<String, String> map = getFilesDatas("C:\\Users\\lierlin\\Desktop\\20200803");
        for(String key :map.keySet())

        {
            String value = map.get(key);
            System.out.println("文件名：" + key + "   内容：" + value);
        }

    }

    public static Map<String, String> getFilesDatas(String filePath){
        Map<String, String> files = new HashMap<String, String>();
        File file = new File(filePath); //需要获取的文件的路径
        String[] fileNameLists = file.list(); //存储文件名的String数组
        File[] filePathLists = file.listFiles(); //存储文件路径的String数组
        for(int i=0;i<filePathLists.length;i++){
            if(filePathLists[i].isFile()){
                try {//读取指定文件路径下的文件内容
                    String fileDatas = readFile(filePathLists[i]);
                    //把文件名作为key,文件内容为value 存储在map中
                    files.put(fileNameLists[i], fileDatas);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return files;
    }

    /**
     * 读取指定目录下的文件
     * @param path 文件的路径
     * @return 文件内容
     * @throws IOException
     */
    public static String readFile(File path) throws IOException{
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                //  s = new String(s.getBytes("gbk"),"utf-8");
                result.append(System.lineSeparator()+s);



            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return result.toString();




    }
}
