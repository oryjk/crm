package com.common;

/**
 * Created by carlwang on 5/11/16.
 */
public class Configuration {
    private String smsUrl;
    private String smsUsername;
    private String smsPassword;

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
    }


    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername;
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }
}
