package com.controller;

import com.sms.bean.SmsInfo;
import com.sms.service.SmsInfoService;
import com.utils.bean.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zhoupengxiao on 16/5/15.
 */
@RequestMapping("/smsInfo")
@RestController
public class SmsInfoController {

    @Autowired
    private SmsInfoService smsInfoService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("/customer-list");
        return modelAndView;
    }

    @RequestMapping("/search")
    public ModelAndView querySmsInfo(String term, @RequestParam long currentPage, ModelAndView modelAndView) {
        SmsInfo smsInfo = new SmsInfo();
        Pagination pagination = new Pagination();

        smsInfo.setContactName(term);
        smsInfo.setPhone(term);
        smsInfo.setGoodsModel(term);
        smsInfo.setGoodsName(term);
        smsInfo.setSmsContent(term);
        pagination.setCurrentIndex(currentPage);

        modelAndView.setViewName("/customer-list");
        modelAndView.addObject("term", term);
        modelAndView.addObject("infoList", smsInfoService.querySmsInfo(smsInfo, pagination));

        return modelAndView;
    }
}
