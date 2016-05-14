package sms;

import com.sms.service.SmsService;
import org.junit.Ignore;
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
 * 提交代码后，需要加上 @Ignore 这个注释，因为如果不加，在启动服务器的时候，这个test的class也会被启动，由于test里面的数据都是不稳定的，很可能报错，所以如果不加上这个注解的话，
 * 服务器启动起来后会报错，导致无法启动,如果要运行这个test，需要去掉注解
 */
@Ignore
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



