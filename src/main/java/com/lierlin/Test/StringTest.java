package com.lierlin.Test;

public class StringTest {
    public static void main(String[] args) {

        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;

        System.out.println(a == b);
        System.out.println(a == c);

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);


        Integer aa= new Integer(55);
        Integer bb = new Integer(55);
        System.out.println(aa.hashCode()+"---------"+bb.hashCode());
        System.out.println(aa == bb);
        /*String a= "lierlin";
        String b = "lierlin";
        String c = "li"+"erlin";
        System.out.println(a==b);
        System.out.println(a==c);*/
        /*”kv”和”ill”也都是字符串常量，当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量，所以s2也同样在编译期就被解析为一个字符串常量，所以s2也是常量池中”kvill”的一个引用。*/
    }
}
