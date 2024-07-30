package com.adele.controller;

import com.adele.common.ModelAndView;
import com.adele.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController implements Controller{
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.setAttribute("users", UserRepository.findAll());
        return new ModelAndView("/user/list");
    }
}
