package com.user.service;

import com.user.bean.Contact;
import com.user.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
