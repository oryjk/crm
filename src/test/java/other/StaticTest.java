package other;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by carlwang on 5/14/16.
 */

public class StaticTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(StaticTest.class);

    @Test
    public void addTest() {
        Container.add();
        Container.add();
        Container.add();
        Container.add();
        Container.add();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                Container.add();
            }
            LOGGER.debug(Thread.currentThread().getId() + "size:" + String.valueOf(Container.getSize()));
        }).start();
        LOGGER.debug(Thread.currentThread().getId() + "size:" + String.valueOf(Container.getSize()));
    }
}
