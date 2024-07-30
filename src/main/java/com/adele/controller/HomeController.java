package com.adele.controller;

import com.adele.annotation.Controller;
import com.adele.annotation.RequestMapping;
import com.adele.common.ModelAndView;
import com.adele.common.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
