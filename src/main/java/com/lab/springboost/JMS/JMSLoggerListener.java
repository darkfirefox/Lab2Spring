package com.lab.springboost.JMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lab.springboost.DAO.NotificationEmailDAO;
import com.lab.springboost.Service.LogService;
import com.lab.springboost.email.EmailConfiguration;
import com.lab.springboost.entity.LogEntity;
import com.lab.springboost.entity.NotificationEmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class JMSLoggerListener {
    @Autowired
    LogService logService;

    @JmsListener(destination = "${spring.jms.queue.destination}")
    public void receiveEntityEvent(EntityEvent event) throws JsonProcessingException {
        LogEntity log = new LogEntity();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonEntity = ow.writeValueAsString(event.getEntity());
        String className = event.getEntity().getClass().getSimpleName();
        log.setTypechange(event.getMethod());
        log.setValue(jsonEntity);
        log.setClassname(className);
        logService.addRecord(log);
    }
}
