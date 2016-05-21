package com.sms.bean;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by zhoupengxiao on 16/5/18.
 */
public class SmsTemplate {

    private Integer id;

//  模板标题
    @NotEmpty(message = "{title.required}")
    private String title;

    //模板内容
    @NotEmpty(message = "{content.required}")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
