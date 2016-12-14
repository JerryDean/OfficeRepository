package com.stee.nia.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * Created by Jerry on 2016/12/11.
 */
@Component
public class NotifyBroker {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage() throws JMSException {
        Topic topic = jmsTemplate.getConnectionFactory().createConnection().createSession(false, Session.AUTO_ACKNOWLEDGE).createTopic("rolling.status");
        jmsTemplate.convertAndSend(topic, true);
    }

    @JmsListener(destination = "rolling.status")
    public void receiveMsg(boolean flag) {
        System.out.println(flag);
    }
}
