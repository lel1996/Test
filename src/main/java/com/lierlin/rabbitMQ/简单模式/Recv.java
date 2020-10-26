package com.lierlin.rabbitMQ.简单模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Recv {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
            /*参数1：消费者要消费的队列名
            * 参数2：是否自动确认，如果为true当消费者拿到数据后会通知mq接受到消息了，mq则会把消息从队列中删除
            *         如果为false需要手动确认才能把消息从队列中删除
            * 参数3：消费者*/
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}