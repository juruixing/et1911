package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloPublisher {

	public static void main(String[] args) throws JMSException {
		//创建ConnectionFactory
		ConnectionFactory factory = new 
				ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//创建connection并调用start方法
		Connection connection = factory.createConnection();
		connection.start();
		//创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建队列
		Topic topic = session.createTopic("topic");
		//创建生产者
		MessageProducer producer = session.createProducer(topic);
		//创建消息
		MapMessage msg = session.createMapMessage();
		msg.setString("name", "topic msg");
		msg.setInt("id",1);
		//发送消息
		producer.send(msg);
		producer.close();
		session.close();
		connection.close();
	}

}
