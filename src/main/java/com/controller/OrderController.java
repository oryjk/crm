package com.controller;

import com.contact.service.ContactService;
import com.order.bean.Order;
import com.order.service.OrderService;
import com.utils.bean.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zhoupengxiao on 16/5/21.
 */
@RequestMapping(value = "/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView listByContactId(ModelAndView modelAndView, @RequestParam Integer contactId, @RequestParam(value = "currentPage", required = false) Integer currentPage) {
        Pagination pagination = new Pagination();
        if (!ObjectUtils.isEmpty(currentPage)) {
            pagination.setCurrentPage(currentPage);
        }
        pagination.setTotalAmount(orderService.queryCountByContactId(contactId));
        pagination.setPageSize(5);
        List<Order> orders = orderService.queryOrderByContactId(contactId, pagination);
        if (ObjectUtils.isEmpty(orders)) {
            modelAndView.setViewName("order-list-none");
        } else {
            modelAndView.setViewName("order-list");
        }
        modelAndView.addObject("orderList", orders);
        modelAndView.addObject("contact", contactService.queryContactById(contactId));
        modelAndView.addObject("pagination", pagination);
        return modelAndView;
    }

}
