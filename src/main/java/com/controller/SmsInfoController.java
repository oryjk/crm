package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.order.bean.Order;
import com.order.service.OrderService;
import com.sms.bean.SmsInfo;
import com.sms.bean.SmsTemplate;
import com.sms.service.SmsInfoService;
import com.sms.service.SmsTempService;
import com.utils.Constant;
import com.utils.bean.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by zhoupengxiao on 16/5/15.
 */
@RequestMapping("/smsInfo")
@RestController
public class SmsInfoController {

    @Autowired
    private SmsInfoService smsInfoService;
    @Autowired
    private SmsTempService smsTempService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView querySmsInfo(@RequestParam(value = "term", required = false) String term, @RequestParam(value = "currentPage", required = false) Integer currentPage, ModelAndView modelAndView) {
        buildInfoList(term, currentPage, modelAndView, Constant.PURCHASE_UP);
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addSmsInfo(ModelAndView modelAndView, @RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "invoiceId", required = false) Integer invoiceId, @RequestParam(value = "fromOrderPage", required = false) Boolean fromOrderPage) {
        if (id == null) {
            SmsInfo smsInfo = new SmsInfo();
            if (!ObjectUtils.isEmpty(invoiceId)) {
                smsInfo.setInvoiceId(invoiceId);
                Order order = orderService.queryOrderById(invoiceId);
                smsInfo.setGoodsName(order.getGoodsName());
                smsInfo.setGoodsModel(order.getSpec());
                smsInfo.setContactId(order.getContactId());
                smsInfo.setContactName(order.getContactName());
                smsInfo.setGoodsId(order.getGoodsId());
                smsInfo.setPhone(order.getMobile());
                smsInfo.setBillDate(order.getBillDate());
            }
            modelAndView.addObject("smsInfo", smsInfo);
        } else {
            modelAndView.addObject("smsInfo", smsInfoService.querySmsInfoById(id));
        }
        modelAndView.addObject("fromOrderPage", fromOrderPage);
        modelAndView.addObject("temps", smsTempService.queryAllTemp());
        modelAndView.setViewName("info-add");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView saveSmsInfo(ModelAndView modelAndView, @Validated SmsInfo smsInfo, BindingResult bindingResult, @RequestParam(value = "fromOrderPage", required = false) Boolean fromOrderPage) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("smsInfo", smsInfo);
            modelAndView.addObject("temps", smsTempService.queryAllTemp());
            modelAndView.setViewName("info-add");
        } else {
            //还未发送
            smsInfo.setDone(0);
            smsInfoService.createSmsInfo(smsInfo);
            modelAndView.addObject("smsInfo", smsInfo);
            modelAndView.setViewName("info-add-success");
        }
        modelAndView.addObject("fromOrderPage", fromOrderPage);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteInfo", method = RequestMethod.GET)
    public ModelAndView deleteInfo(ModelAndView modelAndView, @RequestParam Integer id, @RequestParam(value = "contactId", required = true) String contactId) {
        smsInfoService.deleteSmsInfo(id);
        modelAndView.setViewName("redirect:/order/list?contactId=" + contactId);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(ModelAndView modelAndView, @RequestParam Integer id, @RequestParam(value = "fromOrderPage", required = false) Boolean fromOrderPage) {
        SmsInfo info = smsInfoService.querySmsInfoById(id);
        smsInfoService.deleteSmsInfo(id);
        if (fromOrderPage != null && fromOrderPage.booleanValue() == true) {
            modelAndView.setViewName("redirect:/order/list?contactId=" + info.getContactId());
        } else {
            buildInfoList(null, 1, modelAndView, Constant.PURCHASE_UP);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView modelAndView, SmsInfo smsInfo, @RequestParam(value = "fromOrderPage", required = false) Boolean fromOrderPage) {
        modelAndView.addObject("smsInfo", smsInfo);
        modelAndView.addObject("fromOrderPage", fromOrderPage);
        modelAndView.setViewName("info-add");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateSmsInfo(ModelAndView modelAndView, @Validated SmsInfo smsInfo, BindingResult bindingResult, @RequestParam(value = "fromOrderPage", required = false) Boolean fromOrderPage) {
        modelAndView.addObject("fromOrderPage", fromOrderPage);
        modelAndView.addObject("smsInfo", smsInfo);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("info-add");
            return modelAndView;
        }
        smsInfoService.updateSmsInfo(smsInfo);
        modelAndView.setViewName("info-add-success");
        return modelAndView;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView viewSmsInfo(ModelAndView modelAndView, @RequestParam Integer id) {
        modelAndView.addObject("smsInfo", smsInfoService.querySmsInfoById(id));
        modelAndView.addObject("fromOrderPage", false);
        modelAndView.setViewName("info-detail");
        return modelAndView;
    }

    @RequestMapping(value = "viewByIid", method = RequestMethod.GET)
    public ModelAndView viewSmsInfoByInvoiceId(ModelAndView modelAndView, @RequestParam Integer invoiceId) {
        modelAndView.addObject("smsInfo", smsInfoService.querySmsInfoByInvoiceId(invoiceId));
        modelAndView.addObject("fromOrderPage", true);
        modelAndView.setViewName("info-detail");
        return modelAndView;
    }

    //  添加或者更新短信模板,若id为空,则说明新加模板,否则是更新原有模板
    @RequestMapping(value = "/addOrUpdateTemp", method = RequestMethod.GET)
    public ModelAndView addOrUpdateTemplate(ModelAndView modelAndView, @RequestParam(required = false) Integer id) {
        if (id != null) {
            modelAndView.addObject("smsTemp", smsTempService.querySmsTempById(id));
        } else {
            modelAndView.addObject("smsTemp", new SmsTemplate());
        }
        modelAndView.setViewName("temp-add");
        return modelAndView;
    }

    @RequestMapping(value = "/newTemp", method = RequestMethod.POST)
    @ResponseBody
    public String newTemplate(ModelAndView modelAndView, @Validated SmsTemplate smsTemplate, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("code", 0);
        }
        try {
            smsTempService.createSmsTemp(smsTemplate);
            result.put("code", 1);
        } catch (Exception e) {
            result.put("code", 0);
        }
        return new JSONObject(result).toJSONString();
    }

    //  编辑完短信模板后,保存,可能添加或更新
    @RequestMapping(value = "/saveTemp", method = RequestMethod.POST)
    public ModelAndView saveTemplate(ModelAndView modelAndView, @Validated SmsTemplate smsTemplate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("smsTemp", smsTemplate);
            modelAndView.setViewName("temp-add");
            return modelAndView;
        }
        //新增
        if (smsTemplate.getId() == null) {
            smsTempService.createSmsTemp(smsTemplate);
        } else {//更新
            smsTempService.updateSmsTemp(smsTemplate);
        }
        buildTempList(1, modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/listTemp", method = RequestMethod.GET)
    public ModelAndView listTemp(ModelAndView modelAndView, @RequestParam(value = "currentPage", required = false) Integer currentPage) {
        buildTempList(currentPage, modelAndView);
        return modelAndView;
    }


    @RequestMapping(value = "/deleteTemp", method = RequestMethod.GET)
    public ModelAndView deleteSmsTempById(ModelAndView modelAndView, Integer id) {
        smsTempService.deleteSmsTempById(id);
        buildTempList(1, modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/sortby", method = RequestMethod.GET)
    public ModelAndView sortBy(ModelAndView modelAndView, @RequestParam(value = "term", required = false) String term, @RequestParam(value = "sort", required = true) int sort) {
        buildInfoList(term, 1, modelAndView, sort);
        return modelAndView;
    }


    //未包含search功能
    private void buildTempList(Integer currentPage, ModelAndView modelAndView) {
        Pagination pagination = new Pagination();
        if (currentPage == null || currentPage <= 0) {
            currentPage = 1;
        }
        pagination.setCurrentPage(1);
        pagination.setPageSize(15);

        //总条数
        int totalCount = smsTempService.querySmsTempCount();
        //总页数
        int totalPage = 0;
        if (totalCount % pagination.getPageSize() == 0) {
            totalPage = totalCount / pagination.getPageSize();
        } else {
            totalPage = totalCount / pagination.getPageSize() + 1;
        }
        modelAndView.addObject("smsTemps", smsTempService.querySmsTemp(pagination));
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", totalCount);
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.setViewName("temp-list");
    }

    //包含search功能
    private void buildInfoList(String term, Integer currentPage, ModelAndView modelAndView, int sort) {
        if (StringUtils.isBlank(term)) {
            term = null;
        }
        SmsInfo smsInfo = new SmsInfo();
        //如果term是数字的话
        if (NumberUtils.isNumber(term)) {
            smsInfo.setContactId(Integer.parseInt(term));
            smsInfo.setGoodsId(Integer.parseInt(term));
            smsInfo.setDone(Integer.parseInt(term));
            smsInfo.setSmsType(Integer.parseInt(term));
        }
        //联系人名字
        smsInfo.setContactName(term);
        //手机号
        smsInfo.setPhone(term);
        //产品类别
        smsInfo.setGoodsModel(term);
        //产品名字
        smsInfo.setGoodsName(term);
        //短信内容
        smsInfo.setSmsContent(term);

        Pagination pagination = new Pagination();
        if (currentPage == null || currentPage <= 0) {
            currentPage = 1;
        }
        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(15);

        //总条数
        int totalCount = smsInfoService.querySmsInfoCount(smsInfo);
        //总页数
        int totalPage = 0;
        if (totalCount % pagination.getPageSize() == 0) {
            totalPage = totalCount / pagination.getPageSize();
        } else {
            totalPage = totalCount / pagination.getPageSize() + 1;
        }

        //处理排序字段
        switch (sort) {
            case Constant.PURCHASE_UP:
                pagination.setAsc(true);
                pagination.setSortFiledName("bill_date");
                break;
            case Constant.PURCHASE_DOWN:
                pagination.setAsc(false);
                pagination.setSortFiledName("bill_date");
                break;
            case Constant.SEND_UP:
                pagination.setAsc(true);
                pagination.setSortFiledName("send_date");
                break;
            case Constant.SEND_DOWN:
                pagination.setAsc(false);
                pagination.setSortFiledName("send_date");
                break;
        }

        modelAndView.addObject("infoList", smsInfoService.querySmsInfo(smsInfo, pagination));
        modelAndView.addObject("term", term);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalCount", totalCount);
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.addObject("sort", sort);

        //没有购买记录
        if (StringUtils.isBlank(term) && totalCount == 0) {
            modelAndView.setViewName("info-list-none");
        } else {
            modelAndView.setViewName("info-list");
        }
    }
}
