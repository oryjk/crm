package sms;

import com.sms.bean.SMS_TYPE;
import com.sms.bean.SmsInfo;
import com.sms.service.SmsInfoService;
import com.utils.bean.Pagination;
import com.utils.bean.Sort;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by carlwang on 5/14/16.
 * 提交代码后，需要加上 @Ignore 这个注释，因为如果不加，在启动服务器的时候，这个test的class也会被启动，由于test里面的数据都是不稳定的，很可能报错，所以如果不加上这个注解的话，
 * 服务器启动起来后会报错，导致无法启动
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core-config.xml") // 加载配置
public class SmsInfoServiceTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SmsInfoServiceTest.class);
    @Autowired
    private SmsInfoService smsInfoService;


    @Test
    public void createSmsInfo() {
        SmsInfo smsInfo = new SmsInfo();
        smsInfo.setContactId(1);
        smsInfo.setContactName("carlwang");
        smsInfo.setDone(1);
        smsInfo.setGoodsId(9);
        smsInfo.setGoodsModel("中型");
        smsInfo.setGoodsName("推杆");
        smsInfo.setPhone("18602812970");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 6, 10);
        smsInfo.setSendDate(calendar.getTime());
        smsInfo.setSmsContent("您好，欢迎使用高尔夫工具");
        smsInfo.setSmsType(SMS_TYPE.FIX_TIME.getValue());
        smsInfo.setUpdateDate(new Date());
        smsInfoService.createSmsInfo(smsInfo);
        LOGGER.info("sms info id is {}.", smsInfo.getId());
    }

    @Test
    public void querySmsInfo() {
        SmsInfo smsInfo = smsInfoService.querySmsInfoById(1);
        Assert.assertNotNull(smsInfo);
        Pagination pagination = new Pagination();
        pagination.setAsc(false);
        pagination.setCapacity(100);
        pagination.setCurrentIndex(0);
        pagination.setSortFiledName("phone");
        List<SmsInfo> smsInfos = smsInfoService.querySmsInfo(smsInfo, pagination);
        Assert.assertNotNull(smsInfos);
        Assert.assertNotNull(smsInfos.get(0));
        Integer count = smsInfoService.querySmsInfoCount(smsInfo);
        Assert.assertNotNull(count);

    }

    @Test
    public void updateSmsInfo() {
        SmsInfo smsInfo = smsInfoService.querySmsInfoById(1);
        Assert.assertNotNull(smsInfo);
        smsInfo.setContactId(2);
        smsInfo.setContactName("carlwang");
        smsInfo.setDone(2);
        smsInfo.setGoodsId(10);
        smsInfo.setGoodsModel("大型");
        smsInfo.setGoodsName("发球木");
        smsInfo.setPhone("18280073864");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 6, 10);
        smsInfo.setSendDate(calendar.getTime());
        smsInfo.setSmsContent("您好，欢迎使用高尔夫工具,我们的价格是极其具有优势的。");
        smsInfo.setSmsType(SMS_TYPE.LOOP.getValue());
        smsInfo.setUpdateDate(new Date());
        smsInfoService.updateSmsInfo(smsInfo);
        Assert.assertNotNull(smsInfo);
    }


}
