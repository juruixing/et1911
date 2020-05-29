package com.etoak.config;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
//中间件的配置
@Configuration
public class ActiveMQConfig {
	
	//activeMQ配置
	@Bean
	public ActiveMQConnectionFactory mqFactory() {
		ActiveMQConnectionFactory factory = new 
				ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//允许异步发送
		factory.setUseAsyncSend(true);
		return factory;
	}
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory factory = new 
				CachingConnectionFactory(this.mqFactory());
		//缓存session
		factory.setSessionCacheSize(20);
		return factory;
	}
	//用于发送JMS消息
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(this.connectionFactory());
		//开启服务质量控制(QOS包括持久化优先级消息生存时间)
		jmsTemplate.setExplicitQosEnabled(true); 
		//设置持久化
		jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
		//设置客户端签收
		jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		return jmsTemplate;
	}

}
