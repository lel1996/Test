package com.lierlin;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
         String s=  around("李二里范德萨范德萨范德萨发达",2,1);
         System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String around(String str, int index, int end) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        if (str.length()==1){
            return "*";
        }
        if (str.length()==2){
            String ming = str.substring(1);
            return  "*"+ming;
        }
      /*  String a=StringUtils.leftPad(StringUtils.right(str, end), StringUtils.length(str), "*");
        String b=StringUtils.removeStart(a, "***");
        String c=StringUtils.left(str, index);
        return c.concat(b);*/
        return StringUtils.left(str, index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(str, end), StringUtils.length(str), "*"), "*"));
    }
    public static void jdbc1(){
        Driver driver = null;
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","rootroot");
        try {
            driver = new com.mysql.jdbc.Driver();
            Connection connection = driver.connect("jdbc:mysql://localhost:3306/tt",info);
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void jdbc2()throws Exception{
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","rootroot");
        Connection connection=driver.connect("jdbc:mysql://127.0.0.1:8080/tt",info);
        System.out.println(connection);
    }


    public static void jdbc3() throws  Exception{
        Class claxx=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) claxx.newInstance();
        String url = "jdbc:mysql://127.0.0.1:8080/tt";
        String user = "root";
        String password = "rootroot";
        DriverManager.registerDriver(driver);
        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }


    public static void jdbc4() throws  Exception{
        //Class claxx=Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");//已经把Driver的实现类加载到内存了
        //Driver driver=(Driver) claxx.newInstance();
        String url = "jdbc:mysql://127.0.0.1:8080/tt";
        String user = "root";
        String password = "rootroot";
        //DriverManager.registerDriver(driver);注释的两行不需要，因为在driver中有个静态代码块会自动加载
        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

    public  static void jdbc5() throws Exception{
       InputStream is = Main.class.getClassLoader().getResourceAsStream("com/lierlin/Resource/jdbc.properties");
       Properties pros = new Properties();
       pros.load(is);
       String user = pros.getProperty("user");
       String password = pros.getProperty("password");
       String url = pros.getProperty("url");
       String  driverClass= pros.getProperty("DriverClass");
       Class.forName(driverClass);
       Connection connection = DriverManager.getConnection(url,user,password);
       System.out.println(connection);
    }



}
