package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**ww5/10/16.
 */
@RequestMapping("/")
@RestController
public class IndexController {

    @RequestMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/index");
        return modelAndView;
    }
}
