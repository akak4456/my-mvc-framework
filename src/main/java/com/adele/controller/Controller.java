package com.adele.controller;

import com.adele.common.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
