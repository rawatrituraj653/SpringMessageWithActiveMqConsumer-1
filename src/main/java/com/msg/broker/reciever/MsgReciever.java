package com.msg.broker.reciever;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.msg.broker.producer.Employee;

@Component
public class MsgReciever {

	
	@JmsListener(destination = "my-app")
	public void getMsg(Message msg) throws JMSException {
		
		if(msg instanceof TextMessage) {
			System.out.println("comes from text msg");
			TextMessage message=(TextMessage) msg;
			try {
				System.out.println("msg is come: \n"+message.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
			else if(msg instanceof ObjectMessage) {
				System.out.println("comes from object msg");
				ObjectMessage  message=(ObjectMessage) msg;
				Employee employee= (Employee) message.getObject();
				System.out.println(employee);
			
				
			}	
		}
	
}
