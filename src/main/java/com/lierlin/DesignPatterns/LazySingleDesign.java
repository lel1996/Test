package com.lierlin.DesignPatterns;

import lombok.Synchronized;

public class LazySingleDesign {
    public static void main(String[] args) throws InterruptedException {
        Singleton singleton = Singleton.getInstance();
        Thread.sleep(1000);
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton==singleton2);
        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());
    }


}

class Singleton {//ÀÁººµ¥Àý
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            return new Singleton();
        }
        return singleton;
    }
}
class Singleton1{//¶öººµ¥ÁÐ
    private static Singleton1 singleton=new Singleton1() ;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return singleton;
    }
}
class Singleton2{//Ë«¼ìËø/Ë«ÖØÐ£ÑéËø£¨DCL£¬¼´ double-checked locking
    private static Singleton2 singleton2;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if (singleton2 == null){
            synchronized(Singleton2.class){
                if (singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}