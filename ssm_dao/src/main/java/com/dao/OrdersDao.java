package com.dao;

import com.domain.Orders;

import java.util.List;

/**
 * @author 10574
 */
public interface OrdersDao {

    List<Orders> findAll();
}
