package com.lierlin.DesignPatterns;

/*������ģʽ*/
public class ShiPeiDesign {
    static class TwoHole {
        void SpecificRequest() {
            System.out.println("����һ�����ײ�ͷ���޷����ӵ����ײ�����");
        }
    }

    interface ThreeHoleSocket {
        void request();
    }

    static class PowerAdapter implements ThreeHoleSocket {

        TwoHole twoHole;

        public PowerAdapter(TwoHole twoHole) {
            this.twoHole = twoHole;
        }

        @Override
        public void request() {
        twoHole.SpecificRequest();
            System.out.println("ʹ����ת�����������ײ�ͷ���ӵ������ײ�����");
        }

    }

    public static void main(String[] args) {
        TwoHole y = new TwoHole();
        PowerAdapter x = new PowerAdapter(y);
        x.request();
    }
}
