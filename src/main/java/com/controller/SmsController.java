package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhoupengxiao on 16/5/15.
 */
@RestController
public class SmsController {

    @RequestMapping
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("/customer-list");
        return modelAndView;
    }
}
