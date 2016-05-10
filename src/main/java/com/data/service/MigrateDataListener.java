package com.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by carlwang on 12/8/15.
 */

@Service
@Scope("singleton")
public class MigrateDataListener implements ApplicationListener<ContextRefreshedEvent> {


    private static final Logger LOGGER = LoggerFactory.getLogger(MigrateDataListener.class);

    @Autowired
    private MigrateDataService migrateDateService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {//root application context 没有parent，他就是老大.
            try {
                migrateDateService.migrate();
            } catch (Exception e) {
                LOGGER.error("Some error occured when migration data.The error message is {}.", e.getMessage());
                throw e;
            }
        }
    }


}
