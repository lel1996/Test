package com.lierlin.IO;
import java.io.File;

public class test {
    public void ShowDir(File f){
        for (File f1:f.listFiles()){
            if(f1.isDirectory()){
                ShowDir(f1);
                //һֱ�ݹ鵽����Ŀ¼
                if(f1.listFiles().length==0){
                    //������ļ�������û���ļ�֤���ǿ��ļ�������ɾ��
                    f1.delete();
                }
            }
        }
    }
    /**
     *
     * �Ѵ��������пյ��ļ��н���ɾ��
     */
    public static void main(String[] args) {
        File f = new File("C:\\Users\\lierlin\\Desktop\\911-1029");
        new test().ShowDir(f);
    }
}