package com.adele.handler.adapter;

import com.adele.common.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerAdapter {
    boolean supports(Object handler);

    ModelAndView handle(Object handler, HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
