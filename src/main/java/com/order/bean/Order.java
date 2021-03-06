package com.order.bean;

import java.util.Date;

/**
 * Created by zhoupengxiao on 16/5/21.
 */
public class Order {
    private Integer id;
    //用户ID
    private Integer contactId;
    //客户姓名
    private String contactName;
    //客户手机号
    private String mobile;
    //商品ID
    private Integer goodsId;
    //商品名称
    private String goodsName;
    //商品规格
    private String spec;
    //交易时间
    private Date billDate;
    //总数量
    private Integer quantity;
    //单价
    private Long price;
    //折扣额
    private Long deduction;
    //总金额
    private Long totalAmount;
    //为当前order设置的短信个数
    private int smsCount;
    //销售人员
    private String salesMan;

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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Integer getQuantity() {
        if (this.quantity == null) {
            return null;
        }
        return Math.abs(this.quantity);
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDeduction() {
        return deduction;
    }

    public void setDeduction(Long deduction) {
        this.deduction = deduction;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
