package com.user.controller;

import com.user.bean.Contact;
import com.user.service.ContactService;
import com.utils.bean.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by carlwang on 5/21/16.
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/all")
    public ModelAndView queryAll(@RequestParam(value = "currentPage", defaultValue = "0", required = false) Integer currentPage,
                                 ModelAndView modelAndView) {
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(20);
        List<Contact> contactList = contactService.queryContact(null, pagination);
        Integer totalPage = contactService.queryContactCount(null);
        pagination.setTotalAmount(totalPage);
        modelAndView.addObject("contactList", contactList);
        modelAndView.addObject("pagination", pagination);
        return modelAndView;
    }
}
