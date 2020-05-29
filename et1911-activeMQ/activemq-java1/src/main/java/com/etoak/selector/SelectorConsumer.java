package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectorConsumer {
	public static final String SELECTOR = "name = 'etoak' and age = 11";
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new 
				ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		//使用客户端签收模式
		Session session = 
				connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		Queue queue = session.createQueue("selector");
		//第二个参数传入选择器
		MessageConsumer consumer = 
				session.createConsumer(queue, SELECTOR);
		TextMessage msg = (TextMessage)consumer.receive();
		System.out.println(msg.getText().toString());
		msg.acknowledge();
	}
}
