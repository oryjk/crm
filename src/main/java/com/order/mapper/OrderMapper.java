package com.order.mapper;

import com.mybatis.mapper.SqlMapper;
import com.order.bean.Order;
import com.utils.bean.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhoupengxiao on 16/5/21.
 */
@Repository
public interface OrderMapper extends SqlMapper {
    List<Order> queryOrderByContactId(@Param(value = "contactId") Integer contactId, @Param(value = "pagination") Pagination pagination, @Param(value = "order") Order order);

    int queryCountByContactId(@Param(value = "contactId") Integer contactId);

    int querySmsCount(@Param(value = "iid") Integer iid);

    Order queryOrderById(@Param(value = "id") Integer id);
}
