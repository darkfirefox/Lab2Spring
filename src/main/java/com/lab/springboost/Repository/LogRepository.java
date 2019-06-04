package com.lab.springboost.Repository;

import com.lab.springboost.entity.LogEntity;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository  extends CrudRepository<LogEntity, Long> {
}
