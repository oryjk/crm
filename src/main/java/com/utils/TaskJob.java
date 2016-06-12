package com.utils;

import com.sms.bean.SmsInfo;
import com.sms.service.SmsInfoService;
import com.sms.service.SmsService;
import org.eclipse.jetty.xml.XmlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by zhoupengxiao on 16/5/19.
 */
@Component
public class TaskJob {
    @Autowired
    private SmsInfoService smsInfoService;
    @Autowired
    private SmsService smsService;

    public static final Logger LOGGER = LoggerFactory.getLogger(TaskJob.class);

    //扫描所有的sms info,查找尚未发送
    @Scheduled(cron = "0 0/1 * * * ?")
    public void execute() {
        List<SmsInfo> infos = smsInfoService.queryUnsendInfo(new Date());
        for (SmsInfo info : infos) {
            try {
                LOGGER.debug("Send sms to phone number: " + info.getPhone());
                String codeStr = smsService.sendSms(info.getPhone(), info.getSmsContent());
                int codeStart = codeStr.indexOf("<code>");
                int codeEnd = codeStr.indexOf("</code>");
                int msgStart = codeStr.indexOf("<msg>");
                int msgEnd = codeStr.indexOf("</msg>");
                String code = codeStr.substring(codeStart + 6, codeEnd);
                //发送成功
                if("2".equalsIgnoreCase(code)){
                    info.setDone(1);
                }
                String msg = codeStr.substring(msgStart + 5, msgEnd);
                LOGGER.error(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
