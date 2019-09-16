package com.Rabbit.Recv.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RabbitMqApplication {

	private static final String QUEUE_NAME = "Hello";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RabbitMqApplication.class, args);
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");

		Connection connection2 = connectionFactory.newConnection();
		Channel channel1 = connection2.createChannel();

		channel1.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println("[*] Waiting for message, To exit pess CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println("[X] Receiverd '"+message+"'");
		};
		channel1.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

	}
}
