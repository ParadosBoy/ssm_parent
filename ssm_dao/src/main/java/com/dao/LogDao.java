package com.dao;

import com.domain.Log;

import java.util.List;

public interface LogDao {
    void save(Log log);

    List<Log> findAll();
}
