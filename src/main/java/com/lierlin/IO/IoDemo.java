package com.lierlin.IO;

import java.io.File;

public class IoDemo {
    /*
    *   static String pathSeparator        ��ϵͳ�йص�·���ָ�����Ϊ�˷��㣬������ʾΪһ���ַ�����
        static char pathSeparatorChar      ��ϵͳ�йص�·���ָ�����
        static String separator            ��ϵͳ�йص�Ĭ�����Ʒָ�����Ϊ�˷��㣬������ʾΪһ���ַ�����
        static char separatorChar          ��ϵͳ�йص�Ĭ�����Ʒָ�����

    * */
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);//·���ָ�����windows��";"linux��":"
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);//�ļ����Ʒָ�����windows��"��б�ܣ�\��"linux��"��б�ܣ�/��"
        System.out.println(File.separatorChar);
    }

}
