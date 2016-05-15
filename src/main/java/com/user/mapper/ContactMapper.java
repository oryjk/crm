package com.user.mapper;

import com.mybatis.mapper.SqlMapper;
import com.user.bean.Contact;
import org.springframework.stereotype.Repository;

/**
 * Created by carlwang on 5/15/16.
 */
@Repository
public interface ContactMapper extends SqlMapper {

    Contact queryContactById(Integer id);

}
