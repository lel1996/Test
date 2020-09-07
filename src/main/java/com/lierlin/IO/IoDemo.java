package com.lierlin.IO;

import java.io.File;

public class IoDemo {
    /*
    *   static String pathSeparator        与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
        static char pathSeparatorChar      与系统有关的路径分隔符。
        static String separator            与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
        static char separatorChar          与系统有关的默认名称分隔符。

    * */
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);//路径分隔符，windows是";"linux是":"
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);//文件名称分隔符，windows是"反斜杠（\）"linux是"正斜杠（/）"
        System.out.println(File.separatorChar);
    }

}
