package com.sms.mapper;

import com.mybatis.mapper.SqlMapper;
import com.sms.bean.SmsInfo;
import com.utils.bean.Pagination;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by carlwang on 5/12/16.
 */
@Repository
public interface SmsInfoMapper extends SqlMapper {
    void createSmsInfo(SmsInfo smsInfo);

    void updateSmsInfo(SmsInfo smsInfo);

    List<SmsInfo> querySmsInfo(SmsInfo smsInfo, Pagination pagination);

    void delete(SmsInfo smsInfo);

    SmsInfo querySmsInfoById(int id);
}
