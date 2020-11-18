package com.Proxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

            final UserDao userDao = new UserDaoImpl();
            // newProxyInstance�������������ͣ�
            // ����1������������������ͬĿ������������
            // ����2��������Ҫʵ�ֵĽӿ��б�ͬĿ����ʵ�ֵĽӿ��б�
            // ����3���ص�����һ��InvocationHandler�ӿڵ�ʵ�ֶ��󣬵����ô������ķ���ʱ��ִ�е��ǻص��е�invoke����
            //proxyΪ�������
            UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                    userDao.getClass().getInterfaces(), new InvocationHandler() {

                        @Override
                        // ����proxy:������Ķ���
                        // ����method:ִ�еķ������������ִ���ĸ�������method�����ĸ�����
                        // ����args:ִ�з����Ĳ���
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("��¼��־");
                            Object result = method.invoke(userDao, args);
                            return result;
                        }
                    });
            //�������ִ�з���
            proxy.saveUser();
        }
    }

