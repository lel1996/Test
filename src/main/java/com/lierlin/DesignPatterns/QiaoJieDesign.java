package com.lierlin.DesignPatterns;

public class QiaoJieDesign {

    interface Sourceable {
        public void method();
    }

    static class SourceSub1 implements Sourceable {

        @Override
        public void method() {
            System.out.println("this is the first sub!");
        }
    }

    static class SourceSub2 implements Sourceable {

        @Override
        public void method() {
            System.out.println("this is the second sub!");
        }
    }

    public static abstract class Bridge {

        private Sourceable source;

        public void method() {
            source.method();
        }

        public Sourceable getSource() {
            return source;
        }

        public void setSource(Sourceable source) {
            this.source = source;
        }
    }

    public static class MyBridge extends Bridge {
        public void method() {
            getSource().method();
        }
    }

    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        /*���õ�һ������*/
        Sourceable source1 = new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        /*���õڶ�������*/
        Sourceable source2 = new SourceSub2();
        bridge.setSource(source2);
        bridge.method();
    }
}
