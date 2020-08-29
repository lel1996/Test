package com.lierlin.ThreadTest;
public class GuardeObject{
    public static void main(String[] args) {
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
            guardeObject1.complete(2);
        },"t2").start();
    }
}
 class GuardeObject1 {
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
