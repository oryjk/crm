package user;

import com.user.bean.Contact;
import com.user.mapper.ContactMapper;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by carlwang on 5/15/16.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core-config.xml") // 加载配置
public class ContactMapperTest {

    @Autowired
    private ContactMapper contactMapper;

    @Test
    public void queryContactById() {
        Contact contact = contactMapper.queryContactById(1);
        Assert.assertNotNull(contact);
        Assert.assertNotNull(contact.getPhone());

    }
}
