package com.order.service;

import com.order.bean.Order;
import com.order.mapper.OrderMapper;
import com.utils.bean.Pagination;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

/**
 * Created by zhoupengxiao on 16/5/21.
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    //根据contact id查询相关的订单记录
    public List<Order> queryOrderByContactId(Integer contactId, Pagination pagination, Order order) {
        LOGGER.debug("Start to query order list by contact id : " + contactId);
        List<Order> orders = orderMapper.queryOrderByContactId(contactId, pagination, order);
        for (Order o : orders) {
            o.setSmsCount(orderMapper.querySmsCount(o.getId()));
        }
        LOGGER.debug("End to query order list.");
        return orders;
    }

    public int queryCountByContactId(Integer contactId, Order order) {
        LOGGER.debug("Start to query count of contact:" + contactId);
        int count = orderMapper.queryCountByContactId(contactId, order);
        LOGGER.debug("End to query count of contact:" + contactId);
        return count;
    }

    public Order queryOrderById(Integer id) {
        LOGGER.debug("Start to query order by id:" + id);
        Order order = orderMapper.queryOrderById(id);
        LOGGER.debug("End to query order by id:" + id);
        return order;
    }
}
