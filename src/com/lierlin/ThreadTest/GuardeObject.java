package com.lierlin.ThreadTest;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class GuardeObject{
/*    public static void main(String[] args) {
        GuardeObject1 guardeObject1 = new GuardeObject1();
        new Thread(()->{
            try {
                System.out.println("开始去拿东西，我会一直等。。。");
                if(guardeObject1.get(2000) == null)
                    System.out.println("在2s内没有拿到值");
                else {
             int num =(int)guardeObject1.get(2000);
                System.out.println("拿到的数据是->"+num);}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardeObject1.complete(3);
        },"t2").start();

    }*/
public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 3; i++) {
        new Person().start();
    }
    Thread.sleep(1000);
    for (Integer id:MailBoxs.getKeys()) {
        new PostMan(id,"内容"+id).start();
        
    }
}
}
class Person extends Thread{
    @Override
    public void run() {
        super.run();
        GuardeObject1  go = MailBoxs.createGuardeObject1();
        System.out.println("收信id->"+go.getId());
        try {
            Object object = go.get(5000);
            System.out.println("收信id："+go.getId()+"------收信内容："+object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class PostMan extends  Thread{
    private int id;
    private String mail;
    public PostMan(int id, String mail){
        this.id=id;
        this.mail=mail;
    }

    @Override
    public void run() {
        super.run();
        GuardeObject1 go = MailBoxs.getGuardeObject1(id);
        System.out.println("送信id->"+id+"送信内容->"+mail);
        go.complete(mail);
    }
}
class MailBoxs{
    private static Map<Integer,GuardeObject1> box = new Hashtable<Integer, GuardeObject1>();
    private static int id = 1;
    private static synchronized int generateId(){
        return  id++;
    }
    public static GuardeObject1 createGuardeObject1(){
        GuardeObject1 go = new GuardeObject1(generateId());
        box.put(go.getId(),go);
        return go;
    }
    public static GuardeObject1 getGuardeObject1(int id){
        //return box.get(id);
        return box.remove(id);//因为是static是静态，remove拿到一次就删除了。用完即删除避免内存泄漏
    }
    public static Set<Integer> getKeys(){
        return box.keySet();
    }
}
 class GuardeObject1 {
    private int id;//用来唯一标识GuardeObjecr1
     public GuardeObject1(int id){this.id = id;}
     public int getId(){return id;}
    private Object response;//结果

    public Object get(long timeout) throws InterruptedException {   //获取结果
        synchronized (this){
            long begin = System.currentTimeMillis();//等待的开始时间
            long passtime = 0; //经理了多长时间
            while (response == null){
                long waitTime = timeout -  passtime;//这一轮循环应该等待的时间
                if (waitTime <= 0)
                    break;
                this.wait(waitTime);
                passtime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }
    public void complete(Object response){ //产生结果
        synchronized (this){
            this.response = response;
            this.notifyAll();   //唤醒所有wait中的线程
        }
    }
}
