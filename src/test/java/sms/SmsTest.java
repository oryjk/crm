package sms;

import com.sms.service.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by zhoupengxiao on 16/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core-config.xml") // 加载配置
public class SmsTest {

    @Autowired
    private SmsService smsService;

    public static final Logger LOGGER = LoggerFactory.getLogger(SmsTest.class);

    @Test
    public void test1() {
        String result = null;
        try {
            result = smsService.sendSms("18782283084", "亲爱的客户，您好！您的订单号【变量】已于【变量】发货，如有问题请及时联系我们客服电话：400-151-0321。祝您打球愉快！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.debug("The result is {}.", result);
    }

}



