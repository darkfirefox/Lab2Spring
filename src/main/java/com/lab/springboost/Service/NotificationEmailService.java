package com.lab.springboost.Service;

import com.google.common.collect.Lists;
import com.lab.springboost.DAO.NotificationEmailDAO;
import com.lab.springboost.Repository.NotificationEmailRepository;
import com.lab.springboost.entity.NotificationEmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationEmailService implements NotificationEmailDAO {
    @Autowired
    private NotificationEmailRepository notificationEmailRepository;

    @Override
    public List<NotificationEmailEntity> allNotificationEmail() {
        return Lists.newArrayList(notificationEmailRepository.findAll());
    }
}
