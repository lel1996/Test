package com.lierlin.IO;
import java.io.File;

public class test {
    public void ShowDir(File f){
        for (File f1:f.listFiles()){
            if(f1.isDirectory()){
                ShowDir(f1);
                //一直递归到最后的目录
                if(f1.listFiles().length==0){
                    //如果是文件夹里面没有文件证明是空文件，进行删除
                    f1.delete();
                }
            }
        }
    }
    /**
     *
     * 把磁盘中所有空的文件夹进行删除
     */
    public static void main(String[] args) {
        File f = new File("C:\\Users\\lierlin\\Desktop\\911-1029");
        new test().ShowDir(f);
    }
}