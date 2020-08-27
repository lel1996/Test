package com.lierlin;

public class ThreadLocalOne {
     volatile Person person=new Person();
 
     public   String setAndGet(String name){
          //System.out.print(Thread.currentThread().getName()+":");
           person.name=name;
           //Ä£ÄâÍøÂçÑÓ³Ù
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
           return person.name;
     }
 
     public static void main(String[] args) {
          final ThreadLocalOne  threadLocal=new ThreadLocalOne();
        
          
          new Thread(new Runnable() {
  			
  			@Override
  			public void run() {
  				// TODO Auto-generated method stub
  				System.out.println("t2->"+threadLocal.setAndGet("tony"));
  			}
  		
       
       }).start();
          
          
          new Thread(new Runnable() {
    			
    			@Override
    			public void run() {
    				// TODO Auto-generated method stub
    				System.out.println("t1->"+threadLocal.setAndGet("arron"));
    			}
    		
         
         }).start();
          
}
     
     class ThreadLocalThree {
         ThreadLocal<Person> threadLocal=new ThreadLocal<Person>();
         public String setAndGet(String name){
               threadLocal.set(new Person(name));
               try {
                    Thread.sleep(200);
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
               return threadLocal.get().name;
         }
         }
 
class Person{
     String name="tom";
     public Person(String name) {
           this.name=name;
     }
 
     public Person(){}
}


}
 