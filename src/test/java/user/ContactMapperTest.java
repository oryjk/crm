package user;

import com.contact.bean.Contact;
import com.contact.mapper.ContactMapper;
import com.utils.bean.Pagination;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    @Test
    public void queryContactCount() {
        Integer count = contactMapper.queryContactCount(null);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void queryContact() {
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(2);
        pagination.setPageSize(20);
        List<Contact> contactList = contactMapper.queryContact(null, pagination);
        Assert.assertTrue(contactList.size() > 0);
    }
}
