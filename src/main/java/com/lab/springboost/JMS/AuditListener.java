package com.lab.springboost.JMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Component
public class AuditListener {
    public static  String UPDATE_EVENT = "update";
    public static  String REMOVE_EVENT = "delete";
    public static  String PERSIST_EVENT = "insert";

    @Autowired
    private JmsTemplate jmsTemplate;
    @Value("${spring.jms.queue.destination}")
    private String destination;

    @PostUpdate
    public void auditUpdate(Object entity) {
        jmsTemplate.convertAndSend(destination, new EntityEvent(entity,UPDATE_EVENT));
    }
    @PostRemove
    public void auditRemove(Object entity) {
        jmsTemplate.convertAndSend(destination, new EntityEvent(entity,REMOVE_EVENT));
    }
    @PostPersist
    public void auditPersist(Object entity) {
        jmsTemplate.convertAndSend(destination, new EntityEvent(entity,PERSIST_EVENT));
    }
}
