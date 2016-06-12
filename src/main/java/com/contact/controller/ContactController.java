package com.contact.controller;

import com.contact.bean.Contact;
import com.contact.service.ContactService;
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
 * Created by carlwang on 5/21/16.
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView queryAll(@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
                                 ModelAndView modelAndView, @RequestParam(value = "term", required = false) String term) {
        Pagination pagination = new Pagination();
        if(!ObjectUtils.isEmpty(currentPage)){
            pagination.setCurrentPage(currentPage);
        }
        pagination.setPageSize(2);

        //根据term查询
        Contact contact = null;
        if (!ObjectUtils.isEmpty(term)) {
            contact = new Contact();
            contact.setName(term);
            contact.setNumber(term);
            contact.setMobile(term);
            contact.setPhone(term);
            contact.setAddress(term);
            contact.setCategory(term);
            contact.setLevel(term);
            contact.setFirstContact(term);
        }

        List<Contact> contactList = contactService.queryContact(contact, pagination);
        Integer totalPage = contactService.queryContactCount(contact);
        pagination.setTotalAmount(totalPage);
        modelAndView.addObject("term", term);
        modelAndView.addObject("contactList", contactList);
        modelAndView.addObject("pagination", pagination);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    ModelAndView deleteById(ModelAndView modelAndView, @RequestParam(value = "id", required = true) Integer id){
        contactService.deleteById(id);
        modelAndView.setViewName("redirect:/contact/list");
        return modelAndView;
    }
}
