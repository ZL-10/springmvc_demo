package com.zl.exceptionResolver;

import com.zl.exception.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolverDemo1 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        SysException e=null;
        if(ex instanceof SysException){//判断是否子类
            e=(SysException)ex;
        }else{
            e=new SysException("unknown error");
        }
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("message",e.getMessage());
        modelAndView.setViewName("error");//返回错误页面
        return modelAndView;
    }
}
