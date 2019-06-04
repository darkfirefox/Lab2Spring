package com.lab.springboost.JMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lab.springboost.DAO.NotificationEmailDAO;
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
public class JMSNotificationListener {
    @Autowired
    EmailConfiguration config;
    @Autowired
    NotificationEmailDAO notificationEmailDAO;
    @Value("${email.from}")
    String emailFrom;

    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    @PostConstruct
    private void postConstruct() {
        mailSender.setHost(config.getHost());
        mailSender.setPort(config.getPort());
        mailSender.setUsername(config.getUsername());
        mailSender.setPassword(config.getPassword());
    }

    @JmsListener(destination = "${spring.jms.queue.destination}")
    public void receiveEntityEvent(EntityEvent event) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonEntity = ow.writeValueAsString(event.getEntity());
        String className = event.getEntity().getClass().getSimpleName();
        List<NotificationEmailEntity> notifications = notificationEmailDAO.allNotificationEmail();
        for (NotificationEmailEntity notification: notifications) {
            if (className.compareTo(notification.getCondition()) == 0 &&
                    event.getMethod().compareTo(AuditListener.UPDATE_EVENT) == 0) {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(emailFrom);
                mailMessage.setTo(notification.getEmail());
                mailMessage.setSubject("Insert new " + notification.getCondition());
                mailMessage.setText(jsonEntity);
                mailSender.send(mailMessage);
            }
        }
    }
}
