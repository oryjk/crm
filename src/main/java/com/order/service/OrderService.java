package com.order.service;

import com.order.bean.Order;
import com.order.mapper.OrderMapper;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Order> queryOrderByContactId(Integer contactId) {
        LOGGER.debug("Start to query order list by contact id : " + contactId);
        List<Order> orders = orderMapper.queryOrderByContactId(contactId);
        for (Order order : orders) {
            order.setSmsCount(orderMapper.querySmsCount(order.getId()));
        }
        LOGGER.debug("End to query order list.");
        return orders;
    }

}
