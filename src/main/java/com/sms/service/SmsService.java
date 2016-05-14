package com.sms.service;

import com.common.Configuration;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlwang on 5/11/16.
 */
@Service
public class SmsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsService.class);
    @Autowired
    private Configuration configuration;


    public String sendSms(String phoneNumber, String content) throws IOException {
        String requestUrl = configuration.getSmsUrl();


        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(requestUrl);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("account", configuration.getSmsUsername()));
        nvps.add(new BasicNameValuePair("password", configuration.getSmsPassword()));
        nvps.add(new BasicNameValuePair("content", content));
        nvps.add(new BasicNameValuePair("mobile", phoneNumber));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            HttpEntity entity = response.getEntity();
            String responseContent = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return responseContent;
        } finally {
            response.close();
        }
    }


}
