package com.zl.controller;

import com.zl.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/testInterceptor")
    public String testInterceptor() {
        System.out.println("run hello/testInterceptor");
        return "success";
    }

    @RequestMapping(value = "/testException")
    public String testException() throws SysException {
        System.out.println("run testException");
        try {
            int i = 1 / 0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("error");
        }
        return "success";
    }
}
