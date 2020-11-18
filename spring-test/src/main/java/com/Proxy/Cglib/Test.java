package com.Proxy.Cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/*
* ��ʵ�ʿ����У�������Ҫ��û��ʵ�ֽӿڵ�����ǿ����JDK��̬����ķ�ʽ��û��ʵ�֡�
* ����Cglib��̬������Զ�û��ʵ�ֽӿڵ����������ʵ������������Ŀ�������������ǿ��
* ���ȣ���Ҫ����Cglib�����jar������ʾ��spring�Ѿ�������cglib�������Ѿ�������spring�������Բ���Ҫ�ٵ����������ˡ�
* */
public class Test {
    public static void main(String[] args) {
        final LinkManDao linkManDao = new LinkManDao();
        // ����cglib���Ķ���
        Enhancer enhancer = new Enhancer();
        // ���ø���
        enhancer.setSuperclass(linkManDao.getClass());
        // ���ûص�
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * �������Ŀ�귽��ʱ��ʵ�����ǵ��ø÷���
             * intercept�ĸ�������
             * proxy:�������
             * method:Ŀ�귽��
             * args��Ŀ�귽�����β�
             * methodProxy:������
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                System.out.println("��¼��־");
                Object result = method.invoke(linkManDao, args);
                return result;
            }
        });
        // �����������
        LinkManDao proxy = (LinkManDao) enhancer.create();
        proxy.save();
    }
}
