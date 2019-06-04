package com.lab.springboost.Service;

import com.lab.springboost.DAO.LogDAO;
import com.lab.springboost.Repository.LogRepository;
import com.lab.springboost.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogService implements LogDAO {
    @Autowired
    private LogRepository logRepository;
    @Override
    public void addRecord(LogEntity log) {
        logRepository.save(log);
    }
}
