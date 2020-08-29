package com.lierlin.ThreadTest;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class GuardeObject{
/*    public static void main(String[] args) {
        GuardeObject1 guardeObject1 = new GuardeObject1();
        new Thread(()->{
            try {
                System.out.println("��ʼȥ�ö������һ�һֱ�ȡ�����");
                if(guardeObject1.get(2000) == null)
                    System.out.println("��2s��û���õ�ֵ");
                else {
             int num =(int)guardeObject1.get(2000);
                System.out.println("�õ���������->"+num);}
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
        new PostMan(id,"����"+id).start();
        
    }
}
}
class Person extends Thread{
    @Override
    public void run() {
        super.run();
        GuardeObject1  go = MailBoxs.createGuardeObject1();
        System.out.println("����id->"+go.getId());
        try {
            Object object = go.get(5000);
            System.out.println("����id��"+go.getId()+"------�������ݣ�"+object);
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
        System.out.println("����id->"+id+"��������->"+mail);
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
        return box.remove(id);//��Ϊ��static�Ǿ�̬��remove�õ�һ�ξ�ɾ���ˡ����꼴ɾ�������ڴ�й©
    }
    public static Set<Integer> getKeys(){
        return box.keySet();
    }
}
 class GuardeObject1 {
    private int id;//����Ψһ��ʶGuardeObjecr1
     public GuardeObject1(int id){this.id = id;}
     public int getId(){return id;}
    private Object response;//���

    public Object get(long timeout) throws InterruptedException {   //��ȡ���
        synchronized (this){
            long begin = System.currentTimeMillis();//�ȴ��Ŀ�ʼʱ��
            long passtime = 0; //�����˶೤ʱ��
            while (response == null){
                long waitTime = timeout -  passtime;//��һ��ѭ��Ӧ�õȴ���ʱ��
                if (waitTime <= 0)
                    break;
                this.wait(waitTime);
                passtime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }
    public void complete(Object response){ //�������
        synchronized (this){
            this.response = response;
            this.notifyAll();   //��������wait�е��߳�
        }
    }
}
