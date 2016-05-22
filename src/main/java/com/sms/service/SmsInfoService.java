package com.sms.service;

import com.aspect.annotation.LogAnnotation;
import com.sms.bean.SmsInfo;
import com.sms.mapper.SmsInfoMapper;
import com.utils.bean.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
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
        smsInfoMapper.updateSmsInfo(smsInfo);

    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void deleteSmsInfo(Integer id) {
        SmsInfo smsInfo = new SmsInfo();
        smsInfo.setId(id);
        LOGGER.debug("Delete sms info : " + id);
        smsInfoMapper.deleteSmsInfo(smsInfo);
    }

    @LogAnnotation(description = "querySmsInfo")
    public List<SmsInfo> querySmsInfo(SmsInfo smsInfo, Pagination pagination) {
        LOGGER.debug("Begin querySmsInfo.");
        List<SmsInfo> smsInfos = smsInfoMapper.querySmsInfo(smsInfo, pagination);
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

    public SmsInfo querySmsInfoByInvoiceId(Integer invoiceId) {
        LOGGER.debug("Start to query sms info by invoice id:" + invoiceId);
        SmsInfo info = smsInfoMapper.querySmsInfoByInvoiceId(invoiceId);
        LOGGER.debug("End query sms info by invoice id.");
        return info;
    }

    public Integer querySmsInfoCount(SmsInfo smsInfo) {
        LOGGER.debug("Begin querySmsInfoCount.");
        Integer count = smsInfoMapper.querySmsInfoCount(smsInfo);
        LOGGER.debug("The count is {}.", count);
        LOGGER.debug("End querySmsInfoCount.");
        return count;
    }

    public List<SmsInfo> queryUnsendInfo(Date now) {
        LOGGER.debug("Start to query sms info to send");
        List<SmsInfo> infos = smsInfoMapper.queryUnsendInfo(now);
        LOGGER.debug("End to query sms info to send");
        return infos;
    }
}
