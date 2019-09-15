package com.zlx.reverce.service;

import com.zlx.reverce.dao.ReserveOrderDao;
import com.zlx.reverce.domain.ReserveOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    ReserveOrderDao reserveOrderDao;

    public List<Map> selectAll() {
        return reserveOrderDao.selectAll();
    }

    public void insertOrder(ReserveOrder order) {
        reserveOrderDao.insertOrder(order);
    }
}
