package com.controller;

import com.contact.service.ContactService;
import com.order.bean.Order;
import com.order.service.OrderService;
import com.utils.bean.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    ModelAndView listByContactId(ModelAndView modelAndView, @RequestParam Integer contactId, @RequestParam(value = "currentPage", required = false) Integer currentPage, @RequestParam(value = "term", required = false) String term, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "asc", required = false) Boolean asc) {
        Order order = new Order();
        if (!ObjectUtils.isEmpty(term)) {
            order.setGoodsName(term);
            order.setSalesMan(term);
            order.setSpec(term);
            order.setMobile(term);
            if (NumberUtils.isNumber(term)) {
                long num = Long.parseLong(term);
                order.setDeduction(num);
                order.setPrice(num);
                order.setTotalAmount(num);
                order.setQuantity(Integer.parseInt(term));
            }

        }
        Pagination pagination = new Pagination();
        if (!ObjectUtils.isEmpty(currentPage)) {
            pagination.setCurrentPage(currentPage);
        }
        if (StringUtils.isNotBlank(sortFieldName)) {
            pagination.setSortFiledName(sortFieldName);
        }
        if (ObjectUtils.isEmpty(asc) || !asc) {
            pagination.setAsc(false);
        }
        pagination.setTotalAmount(orderService.queryCountByContactId(contactId, order));
        pagination.setPageSize(8);
        List<Order> orders = orderService.queryOrderByContactId(contactId, pagination, order);
        if (ObjectUtils.isEmpty(orders)) {
            modelAndView.setViewName("order-list-none");
        } else {
            modelAndView.setViewName("order-list");
        }
        modelAndView.addObject("orderList", orders);
        modelAndView.addObject("contact", contactService.queryContactById(contactId));
        modelAndView.addObject("pagination", pagination);
        modelAndView.addObject("asc", asc);
        modelAndView.addObject("term", term);
        return modelAndView;
    }

    @RequestMapping(value = "/listById", method = RequestMethod.GET)
    public ModelAndView getOrderById(ModelAndView modelAndView, @RequestParam(value = "id", required = true) Integer id) {
        List<Order> orders = new ArrayList<>();
        orders.add(orderService.queryOrderById(id));
        modelAndView.addObject("orderList", orders);
        modelAndView.addObject("contact", contactService.queryContactById(orders.get(0).getContactId()));
        modelAndView.addObject("flag", "single");
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

}
