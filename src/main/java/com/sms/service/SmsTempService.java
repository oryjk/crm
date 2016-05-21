package com.sms.service;

import com.sms.bean.SmsTemplate;
import com.sms.mapper.SmsTemplateMapper;
import com.utils.bean.Pagination;
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
 * Created by zhoupengxiao on 16/5/18.
 */
@Service
public class SmsTempService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsTempService.class);

    @Autowired
    private SmsTemplateMapper smsTemplateMapper;

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void createSmsTemp(SmsTemplate smsTemplate){
        if(ObjectUtils.isEmpty(smsTemplate)){
            LOGGER.error("The sms template is empty.");
            return;
        }
        LOGGER.debug("Create sms template start.");
        smsTemplateMapper.createSmsTemp(smsTemplate);
        LOGGER.debug("Create sms template end.");
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void updateSmsTemp(SmsTemplate smsTemplate){
        if(ObjectUtils.isEmpty(smsTemplate)){
            LOGGER.error("The sms template is empty.");
            return;
        }
        LOGGER.debug("Update sms template start.");
        smsTemplateMapper.updateSmsTemp(smsTemplate);
        LOGGER.debug("Update sms template end.");
    }

    public List<SmsTemplate> queryAllTemp(){
        return smsTemplateMapper.queryAllTemp();
    }

    public List<SmsTemplate> querySmsTemp(Pagination pagination){
        return smsTemplateMapper.querySmsTemp(pagination);
    }

    public int querySmsTempCount(){
        return smsTemplateMapper.querySmsTempCount();
    }

    public void deleteSmsTempById(Integer id) {
        smsTemplateMapper.deleteSmsTempById(id);
    }

    public SmsTemplate querySmsTempById(Integer id){
        return smsTemplateMapper.querySmsTempById(id);
    }
}
