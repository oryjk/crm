package com.sms.bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by carlwang on 5/12/16.
 */
public class SmsInfo {

    private Integer id;

    //关联的交易/发票ID
    private Integer invoiceId;

    //客户的id
    @NotNull(message = "{contactId.required}")
    private Integer contactId;

    //客户的名字
    @NotEmpty(message = "{contactName.required}")
    private String contactName;

    //客户的电话
    @Pattern(regexp = "^1\\d{10}$", message = "{phone.invalid}")
    private String phone;

    //客户购买的商品的id
    @NotNull(message = "{goodsId.required}")
    private Integer goodsId;

    //客户购买的商品名称
    @NotEmpty(message = "{goodsName.required}")
    private String goodsName;

    //客户购买的商品型号
    private String goodsModel;

    //该条记录最后更新的时间
    private Date updateDate;

    //短信发送的时间
    @NotNull(message = "{sendDate.required}")
    private Date sendDate;

    //短信发送的内容
    @NotEmpty(message = "{smsContent.required}")
    private String smsContent;
    //标示是否已发送
    private Integer done = null;
    //标示定时的类型
    private Integer smsType = null;
    //购买日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date billDate;

    public SmsInfo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public Integer getSmsType() {
        return smsType;
    }

    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }
}
