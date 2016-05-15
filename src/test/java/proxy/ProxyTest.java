package proxy;

import com.sms.service.SmsInfoService;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by carlwang on 5/15/16.
 */
public class ProxyTest {

    @Test
    public void writeFile() {
        Class classes[] = new Class[1];
        classes[0] = SmsInfoService.class;
        byte[] bytes = ProxyGenerator.generateProxyClass("haha", classes);
        File file = new File("./SmsInfoServiceProxy.class");
        try {
            FileOutputStream fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            fop.write(bytes);
            fop.flush();
            fop.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
