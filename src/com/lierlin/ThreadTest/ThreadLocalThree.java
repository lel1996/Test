package com.lierlin.ThreadTest;

public class ThreadLocalThree {
     ThreadLocal<Person> threadLocal=new ThreadLocal<Person>();
     public String setAndGet(String name){
           threadLocal.set(new Person(name));
           try {
               Thread.sleep(2);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
           return threadLocal.get().name;
     }
 
     public static void main(String[] args) {
           final ThreadLocalThree  threadLocal=new ThreadLocalThree();
           new Thread(new Runnable() {
       		@Override
       		public void run() {
       			// TODO Auto-generated method stub
       			System.out.println("t1:"+threadLocal.setAndGet("arron"));
       		}
       	}).start();
           
           new Thread(new Runnable() {
       		@Override
       		public void run() {
       			// TODO Auto-generated method stub
       			System.out.println("t1:"+threadLocal.setAndGet("tony"));
       		}
       	}).start();
        
     }
     
     class Person{
         String name="tom";
         public Person(String name) {
               this.name=name;
         }
     
         public Person(){}
    }
}