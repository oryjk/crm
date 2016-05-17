package com.controller;

import com.sms.bean.SmsInfo;
import com.sms.service.SmsInfoService;
import com.utils.bean.Pagination;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zhoupengxiao on 16/5/15.
 */
@RequestMapping("/smsInfo")
@RestController
public class SmsInfoController {

    @Autowired
    private SmsInfoService smsInfoService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView querySmsInfo(@RequestParam(value = "term", required = false) String term, @RequestParam(value = "currentPage", required = false) Integer currentPage, ModelAndView modelAndView) {
        if(StringUtils.isBlank(term)){
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
//        smsInfo.setPhone(term);
//        //产品类别
//        smsInfo.setGoodsModel(term);
//        //产品名字
//        smsInfo.setGoodsName(term);
//        //短信内容
//        smsInfo.setSmsContent(term);

        Pagination pagination = new Pagination();
        if(currentPage == null || currentPage <= 0){
            currentPage = 1;
        }
        pagination.setCurrentPage(currentPage);

        modelAndView.addObject("infoList", smsInfoService.querySmsInfo(smsInfo, pagination));
        modelAndView.addObject("term", term);
        modelAndView.addObject("currentPage", currentPage);

        //总条数
        int totalCount = smsInfoService.querySmsInfoCount(smsInfo);
        //总页数
        int totalPage = 0;
        if (totalCount % pagination.getPageSize() == 0) {
            totalPage = totalCount / pagination.getPageSize();
        } else {
            totalPage = totalCount / pagination.getPageSize() + 1;
        }
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.setViewName("/customer-list");

        return modelAndView;
    }
}
