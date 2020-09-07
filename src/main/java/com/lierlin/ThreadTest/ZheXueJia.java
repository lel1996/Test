package com.lierlin.ThreadTest;
/*科学家需要左边的筷子和右边的筷子才能吃饭，在五个人都需要的情况下就会发生竞争最终导致死锁*/
public class ZheXueJia {

    public static void main(String[] args) {
        Kuaizi kuaizi1 = new Kuaizi("筷子1");
        Kuaizi kuaizi2 = new Kuaizi("筷子2");
        Kuaizi kuaizi3 = new Kuaizi("筷子3");
        Kuaizi kuaizi4 = new Kuaizi("筷子4");
        Kuaizi kuaizi5 = new Kuaizi("筷子5");
       new YanJiuSheng("李二林",kuaizi1,kuaizi2).start();
       new YanJiuSheng("李大林",kuaizi2,kuaizi3).start();
       new YanJiuSheng("李德功",kuaizi3,kuaizi4).start();
       new YanJiuSheng("李春霞",kuaizi4,kuaizi5).start();
       new YanJiuSheng("李德喜",kuaizi5,kuaizi1).start();
    }
}

     class YanJiuSheng extends Thread {
        Kuaizi left;
        Kuaizi right;
        String name;

        public YanJiuSheng(String name, Kuaizi left, Kuaizi right) {
            super(name);
            this.left = left;
            this.right = right;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (left) {//有左边的筷子
                    synchronized (right) {//有右边的筷子
                        try {
                            eat();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void eat() throws InterruptedException {
            System.out.println("科学家" + name + "在->" + System.currentTimeMillis() + "->的时候吃饭吃饭");
            Thread.sleep(1000);
        }
    }

     class Kuaizi {
        private String name;

        public Kuaizi(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

