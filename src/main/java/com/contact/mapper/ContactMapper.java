package com.contact.mapper;

import com.mybatis.mapper.SqlMapper;
import com.contact.bean.Contact;
import com.utils.bean.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by carlwang on 5/15/16.
 */
@Repository
public interface ContactMapper extends SqlMapper {

    Contact queryContactById(Integer id);

    List<Contact> queryAll(@Param("pagination") Pagination pagination);

    List<Contact> queryContact(@Param("contact") Contact contact, @Param("pagination") Pagination pagination);

    Integer queryContactCount(@Param("contact") Contact contact);
}
