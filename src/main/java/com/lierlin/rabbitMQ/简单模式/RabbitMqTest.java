package com.lierlin.rabbitMQ.简单模式;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
/*端口15672是后台登录时的端口，5672时程序链接时的端口*/
public class RabbitMqTest {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();//创建链接工厂（设置参数）
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("lierlin");
        factory.setPassword("lierlin");
        try (Connection connection = factory.newConnection();//创建连接；
             Channel channel = connection.createChannel()) {//创建频道
            /*
            * 参数1：队列名字
            * 参数2：是否定义持久化队列（消息会持久化在服务器上）
            * 参数3：是否独占本连接
            * 参数4：是否在不使用的时候队列自动删除
            * 参数5：其它参数
            * */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);//声明队列
            String message = "Hello World!";
            /*
            * 参数1：交换机，如果没有使用到用空字符表示
            * 参数2：队列名
            * 参数3：其它信息
            * 参数4：要发送的message
            * */
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());//发生消息
            channel.close();//关闭资源
            connection.close();
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
