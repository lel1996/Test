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
        /*��kv���͡�ill��Ҳ�����ַ�����������һ���ַ����ɶ���ַ����������Ӷ���ʱ�����Լ��϶�Ҳ���ַ�������������s2Ҳͬ���ڱ����ھͱ�����Ϊһ���ַ�������������s2Ҳ�ǳ������С�kvill����һ�����á�*/
    }
}
