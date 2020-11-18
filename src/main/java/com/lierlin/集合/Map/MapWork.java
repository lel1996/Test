package com.lierlin.����.Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/*C:\Users\Administrator.DESKTOP-MSGCJJH\Desktop\����xml\��ҵ*/
public class MapWork {
    public static void main(String[] args) {

        Map<String, String> map = getFilesDatas("C:\\Users\\lierlin\\Desktop\\20200803");
        for(String key :map.keySet())

        {
            String value = map.get(key);
            System.out.println("�ļ�����" + key + "   ���ݣ�" + value);
        }

    }

    public static Map<String, String> getFilesDatas(String filePath){
        Map<String, String> files = new HashMap<String, String>();
        File file = new File(filePath); //��Ҫ��ȡ���ļ���·��
        String[] fileNameLists = file.list(); //�洢�ļ�����String����
        File[] filePathLists = file.listFiles(); //�洢�ļ�·����String����
        for(int i=0;i<filePathLists.length;i++){
            if(filePathLists[i].isFile()){
                try {//��ȡָ���ļ�·���µ��ļ�����
                    String fileDatas = readFile(filePathLists[i]);
                    //���ļ�����Ϊkey,�ļ�����Ϊvalue �洢��map��
                    files.put(fileNameLists[i], fileDatas);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return files;
    }

    /**
     * ��ȡָ��Ŀ¼�µ��ļ�
     * @param path �ļ���·��
     * @return �ļ�����
     * @throws IOException
     */
    public static String readFile(File path) throws IOException{
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));//����һ��BufferedReader������ȡ�ļ�
            String s = null;
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
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
