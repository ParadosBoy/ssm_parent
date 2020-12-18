package com.service;

import com.domain.Log;

import java.util.List;

public interface LogService {
    void save(Log log);

    List<Log> findAll();
}
