package com.order.mapper;

import com.mybatis.mapper.SqlMapper;
import com.order.bean.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhoupengxiao on 16/5/21.
 */
@Repository
public interface OrderMapper extends SqlMapper{
    List<Order> queryOrderByContactId(Integer contactId);

    int querySmsCount(@Param(value = "iid") Integer iid);
}
