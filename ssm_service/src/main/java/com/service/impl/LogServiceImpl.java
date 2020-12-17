package com.service.impl;

import com.dao.LogDao;
import com.domain.Log;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10574
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;
    @Override
    public void save(Log log) {
        logDao.save(log);
    }
}
