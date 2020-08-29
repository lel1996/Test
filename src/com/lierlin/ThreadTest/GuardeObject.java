package com.lierlin.ThreadTest;
public class GuardeObject{
    public static void main(String[] args) {
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
            guardeObject1.complete(2);
        },"t2").start();
    }
}
 class GuardeObject1 {
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
