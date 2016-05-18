package com.sms.mapper;

import com.mybatis.mapper.SqlMapper;
import com.sms.bean.SmsTemplate;
import com.utils.bean.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhoupengxiao on 16/5/18.
 */
@Repository
public interface SmsTemplateMapper extends SqlMapper{

    void createSmsTemp(SmsTemplate smsTemplate);

    void updateSmsTemp(SmsTemplate smsTemplate);

    List<SmsTemplate> queryAllTemp();

    //查询模板列表,只有分页功能,没有关键字查询功能
    List<SmsTemplate> querySmsTemp(@Param("pagination") Pagination pagination);

    //查询所有的模板数量供分页使用
    Integer querySmsTempCount();

    void deleteSmsTempById(@Param("id") Integer id);

    SmsTemplate querySmsTempById(@Param("id") Integer id);
}
