package com.lierlin.ThreadTest;
/*��ѧ����Ҫ��ߵĿ��Ӻ��ұߵĿ��Ӳ��ܳԷ���������˶���Ҫ������¾ͻᷢ���������յ�������*/
public class ZheXueJia {

    public static void main(String[] args) {
        Kuaizi kuaizi1 = new Kuaizi("����1");
        Kuaizi kuaizi2 = new Kuaizi("����2");
        Kuaizi kuaizi3 = new Kuaizi("����3");
        Kuaizi kuaizi4 = new Kuaizi("����4");
        Kuaizi kuaizi5 = new Kuaizi("����5");
       new YanJiuSheng("�����",kuaizi1,kuaizi2).start();
       new YanJiuSheng("�����",kuaizi2,kuaizi3).start();
       new YanJiuSheng("��¹�",kuaizi3,kuaizi4).start();
       new YanJiuSheng("�ϼ",kuaizi4,kuaizi5).start();
       new YanJiuSheng("���ϲ",kuaizi5,kuaizi1).start();
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
                synchronized (left) {//����ߵĿ���
                    synchronized (right) {//���ұߵĿ���
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
            System.out.println("��ѧ��" + name + "��->" + System.currentTimeMillis() + "->��ʱ��Է��Է�");
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

