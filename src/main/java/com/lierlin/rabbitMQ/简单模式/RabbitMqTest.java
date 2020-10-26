package com.lierlin.rabbitMQ.��ģʽ;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
/*�˿�15672�Ǻ�̨��¼ʱ�Ķ˿ڣ�5672ʱ��������ʱ�Ķ˿�*/
public class RabbitMqTest {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();//�������ӹ��������ò�����
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("lierlin");
        factory.setPassword("lierlin");
        try (Connection connection = factory.newConnection();//�������ӣ�
             Channel channel = connection.createChannel()) {//����Ƶ��
            /*
            * ����1����������
            * ����2���Ƿ���־û����У���Ϣ��־û��ڷ������ϣ�
            * ����3���Ƿ��ռ������
            * ����4���Ƿ��ڲ�ʹ�õ�ʱ������Զ�ɾ��
            * ����5����������
            * */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);//��������
            String message = "Hello World!";
            /*
            * ����1�������������û��ʹ�õ��ÿ��ַ���ʾ
            * ����2��������
            * ����3��������Ϣ
            * ����4��Ҫ���͵�message
            * */
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());//������Ϣ
            channel.close();//�ر���Դ
            connection.close();
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
