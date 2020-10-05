package com.cm.example.service.impl;

import com.cm.example.dao.OrderDao;
import com.cm.example.domain.Order;
import com.cm.example.service.AccountService;
import com.cm.example.service.OrderService;
import com.cm.example.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        System.out.println("开始创建订单");
        orderDao.create(order);

        System.out.println("订单微服务调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());

        System.out.println("资金扣减");
        accountService.decrease(order.getUserId(),order.getMoney());

        System.out.println("修改订单状态");
        orderDao.update(order.getUserId(),0);
    }
}
