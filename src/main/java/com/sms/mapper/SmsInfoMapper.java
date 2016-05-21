package com.sms.mapper;

import com.mybatis.mapper.SqlMapper;
import com.sms.bean.SmsInfo;
import com.utils.bean.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by carlwang on 5/12/16.
 */
@Repository
public interface SmsInfoMapper extends SqlMapper {
    void createSmsInfo(SmsInfo smsInfo);

    void updateSmsInfo(SmsInfo smsInfo);

    List<SmsInfo> querySmsInfo(@Param("smsInfo") SmsInfo smsInfo, @Param("pagination") Pagination pagination);

    Integer querySmsInfoCount(@Param("smsInfo") SmsInfo smsInfo);

    void deleteSmsInfo(SmsInfo smsInfo);

    SmsInfo querySmsInfoById(int id);

    List<SmsInfo> queryUnsendInfo(Date now);
}
