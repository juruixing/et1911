package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProducer {
	public static void main(String[] args) throws JMSException{
		
		//创建ConnectionFactory
		ConnectionFactory factory = new 
		ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//创建Connection,并调用start()
		Connection connection = factory.createConnection();
		connection.start();
		//通过Connection创建Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//通过session创建Destination(Queue/Topic)
		Queue queue = session.createQueue("world");
		//通过session创建生产者
		MessageProducer producer = session.createProducer(queue);
		//通过session创建消息
		TextMessage msg = session.createTextMessage("Hello ActiveMQ");
		//使用生产者对象发送消息
		producer.send(msg);
		//关闭资源
		producer.close();
		session.close();
		connection.close();
	}
}
