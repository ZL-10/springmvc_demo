package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/bye")
public class ByeController {
    @RequestMapping(value = "/testInterceptor")
    public String testInterceptor() {
        System.out.println("run bye/testInterceptor");
        return "success";
    }
}
