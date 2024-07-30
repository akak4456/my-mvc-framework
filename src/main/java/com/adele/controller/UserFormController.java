package com.adele.controller;

import com.adele.common.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFormController implements Controller{
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return new ModelAndView("/user/form");
    }
}
