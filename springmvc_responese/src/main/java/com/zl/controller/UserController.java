package com.zl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    /**
     * @param model
     * @return java.lang.String
     * test return String
     *
     */
    @RequestMapping(value = "/testString")
    public String testString(Model model) {
        User user = new User();
        user.setUsername("王");
        user.setPassword("123");
        user.setAge(12);
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * @param request
     * @param response
     * @return void
     * test return void
     */
    @RequestMapping(value = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("run testVoid()");
        request.getRequestDispatcher("/pages/success.jsp").forward(request, response);
    }


    /**
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     * test return ModleAndView
     *
     */
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("王");
        user.setPassword("123");
        user.setAge(12);

        modelAndView.addObject("user", user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 使用关键字的方式进行转发
     * */
    @RequestMapping(value = "/testForward")
    public String testForward(){
        return "forward:/pages/success.jsp";
    }

    /**
     * 使用关键字的方式进行重定向
     * */
    @RequestMapping(value = "/testRedirect")
    public String testRedirect(){
        return "redirect:/pages/redirect.jsp";
    }


    /**
     * testAjax
     * */
    @RequestMapping(value = "/testAjax")
    public String testAjax(@RequestBody String body){
        System.out.println("accept ajax post");
        System.out.println(body);
        return "success";
    }


/**
 * testAjax
 * */
    @RequestMapping(value = "/testJson")
    public @ResponseBody String testJson(@RequestBody User user) throws JsonProcessingException {
        System.out.println("send jsonData back");
        user.setUsername("王");
        user.setPassword("123");
        user.setAge(12);
        ObjectMapper objectMapper=new ObjectMapper();
        String jackson=objectMapper.writeValueAsString(user);
        System.out.println(jackson);
        return jackson;
    }

}
