package io.pivotal.sensor;

import io.pivotal.sensor.messaging.RFIDReceiver;
import io.pivotal.sensor.messaging.TiltSwitchReceiver;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@EnableEurekaClient
public class RfidMicroServiceApplication{
	
	
	//public RfidMicroServiceApplication(String)

	final static String queueNameRFID = "arduino-rfid-event-queue";
	final static String queueNameTilt = "arduino-tilt-event-queue";
	
	//private String queueNameRFID;
	//private String queueNameTilt;
	//private String exchange;
	//private String rfidRoutingKey;
	//private String tiltRoutingKey;

	@Autowired
	RabbitTemplate rabbitTemplate; 
	
    public static void main(String[] args) {
        SpringApplication.run(RfidMicroServiceApplication.class, args);
    }
    
	@Bean
	Queue queueRFID() {
		return new Queue(queueNameRFID, true);
	}
	
	@Bean
	Queue queueTilt() {
		return new Queue(queueNameTilt, true);
	}
	
	@Bean
	TopicExchange exchangeSensor() {
		return new TopicExchange("arduino-iot-exchange", true, false);
		//return new TopicExchange(exchange, true, false);
	}

	@Bean
	Binding bindingRFID(Queue queueRFID, TopicExchange exchangeRFID) {
		return BindingBuilder.bind(queueRFID).to(exchangeRFID).with("arduino-rfid");
		//return BindingBuilder.bind(queueRFID).to(exchangeRFID).with(rfidRoutingKey);
	}
	
	@Bean
	Binding bindingTilt(Queue queueTilt, TopicExchange exchangeTilt) {
		return BindingBuilder.bind(queueTilt).to(exchangeTilt).with("arduino-tilt-exchange");
		//return BindingBuilder.bind(queueTilt).to(exchangeTilt).with(tiltRoutingKey);
	}
	
	@Bean
	SimpleMessageListenerContainer containerRFID(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapterRFID) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueNameRFID);
		container.setMessageListener(listenerAdapterRFID);
		return container;
	}
	
	@Bean
	SimpleMessageListenerContainer containerTilt(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapterTilt) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueNameTilt);
		container.setMessageListener(listenerAdapterTilt);
		return container;
	}
	
	@Bean
	RFIDReceiver receiverRFID() {
        return new RFIDReceiver();
    }
	
	@Bean
	TiltSwitchReceiver receiverTilt() {
        return new TiltSwitchReceiver();
    }

	@Bean
	MessageListenerAdapter listenerAdapterRFID(RFIDReceiver receiverRFID) {
		return new MessageListenerAdapter(receiverRFID, "receiveMessage");
	}
	
	@Bean
	MessageListenerAdapter listenerAdapterTilt(TiltSwitchReceiver receiverTilt) {
		return new MessageListenerAdapter(receiverTilt, "receiveMessage");
	}

//	@Bean
//	TopicExchange exchangeRFID() {
//		return new TopicExchange("arduino-rfid-exchange", true, false);
//	}
//	
//	@Bean
//	TopicExchange exchangeTilt() {
//		return new TopicExchange("arduino-tilt-exchange", true, false);
//	}
//	
//	@Bean
//	Binding bindingRFIDWithRFIDExchange(TopicExchange exchangeSensor, TopicExchange exchangeRFID) {
//		return BindingBuilder.bind(exchangeSensor).to(exchangeRFID).with("arduino-rfid-exchange");
//	}
//	
//	@Bean
//	Binding bindingTiltWithTiltExchange(TopicExchange exchangeSensor, TopicExchange exchangeTilt) {
//		return BindingBuilder.bind(exchangeSensor).to(exchangeTilt).with("arduino-tilt-exchange");
//	}
	/*
	 @Autowired
	    void setEnvironment(Environment e) { //used to test reading of values
	    
		 	//queueNameRFID = e.getProperty("rfid.queueNameRFID");
			queueNameTilt = e.getProperty("rfid.queueNameTilt");
			exchange = e.getProperty("rfid.exchangeName");
			rfidRoutingKey = e.getProperty("rfid.routingKeyRFID");
			tiltRoutingKey = e.getProperty("rfid.routingKeyTilt");
		 
	    	System.out.println(e.getProperty("rfid.queueNameRFID"));
	    	System.out.println(e.getProperty("rfid.queueNameTilt"));
	    	System.out.println(e.getProperty("rfid.exchangeName"));
	    	System.out.println(e.getProperty("rfid.routingKeyRFID"));
	    	System.out.println(e.getProperty("rfid.routingKeyTilt"));	

	    }
	*/
	
}