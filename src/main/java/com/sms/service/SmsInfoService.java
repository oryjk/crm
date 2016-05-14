package com.sms.service;

import com.aspect.annotation.LogAnnotation;
import com.sms.bean.SmsInfo;
import com.sms.mapper.SmsInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Created by carlwang on 5/14/16.
 */
@Service
public class SmsInfoService {
    public static final Logger LOGGER = LoggerFactory.getLogger(SmsInfoService.class);

    @Autowired
    private SmsInfoMapper smsInfoMapper;

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void createSmsInfo(SmsInfo smsInfo) {
        if (ObjectUtils.isEmpty(smsInfo)) {
            LOGGER.debug("The smsInfo is empty.");
            return;
        }
        LOGGER.debug("Begin createSmsInfo.");
        smsInfoMapper.createSmsInfo(smsInfo);
        LOGGER.debug("End createSmsInfo.");
    }


    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void updateSmsInfo(SmsInfo smsInfo) {
        if (ObjectUtils.isEmpty(smsInfo)) {
            LOGGER.debug("The smsInfo is empty.");
            return;
        }
        LOGGER.debug("The smsInfo id is {}.", smsInfo.getId());
        LOGGER.debug("Begin updateSmsInfo.");
        smsInfoMapper.createSmsInfo(smsInfo);

    }

    @LogAnnotation(description = "querySmsInfo")
    public List<SmsInfo> querySmsInfo(SmsInfo smsInfo) {
        LOGGER.debug("Begin querySmsInfo.");
        List<SmsInfo> smsInfos = smsInfoMapper.querySmsInfo(smsInfo);
        LOGGER.debug("The result size is {}.", smsInfos.size());
        LOGGER.debug("End querySmsInfo.");
        return smsInfos;
    }

    public SmsInfo querySmsInfoById(Integer id) {
        LOGGER.debug("Begin querySmsInfoById.");
        SmsInfo smsInfo = smsInfoMapper.querySmsInfoById(id);
        LOGGER.debug("End querySmsInfoById.");
        return smsInfo;
    }
}
