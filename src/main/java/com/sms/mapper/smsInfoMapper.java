package com.sms.mapper;

import com.mybatis.mapper.SqlMapper;
import com.sms.bean.SmsInfo;

import java.util.List;

/**
 * Created by carlwang on 5/12/16.
 */
public interface smsInfoMapper extends SqlMapper {
    void create(SmsInfo smsInfo);

    void upadte(SmsInfo smsInfo);

    List<SmsInfo> query(SmsInfo smsInfo);

    void delete(SmsInfo smsInfo);

    SmsInfo querySmsInfoById(int id);
}
