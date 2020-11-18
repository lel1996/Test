package com.lierlin.DesignPatterns;

/*适配器模式*/
public class ShiPeiDesign {
    static class TwoHole {
        void SpecificRequest() {
            System.out.println("我是一个两孔插头，无法连接到三孔插座中");
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
            System.out.println("使用了转换插座后，两孔插头连接到了三孔插座上");
        }

    }

    public static void main(String[] args) {
        TwoHole y = new TwoHole();
        PowerAdapter x = new PowerAdapter(y);
        x.request();
    }
}
