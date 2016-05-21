package com.user.service;

import com.user.bean.Contact;
import com.user.mapper.ContactMapper;
import com.utils.bean.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by carlwang on 5/15/16.
 */
@Service
public class ContactService {
    @Autowired
    private ContactMapper contactMapper;

    public Contact queryContactById(Integer id) {
        return contactMapper.queryContactById(id);
    }

    public List<Contact> queryContact(Contact contact, Pagination pagination) {
        return contactMapper.queryContact(contact, pagination);
    }

    public Integer queryContactCount(Contact contact) {
        return contactMapper.queryContactCount(contact);
    }
}
