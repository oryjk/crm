package com.sms.bean;

/**
 * Created by carlwang on 5/14/16.
 * FIX_TIME代表不循环，到了时间就发送
 * LOOP代表循环，到了时间后，按照设置的时间间隔进行循环发送
 */
public enum SMS_TYPE {
    FIX_TIME(0), LOOP(1);
    private final Integer value;

    SMS_TYPE(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
