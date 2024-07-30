package com.adele.controller;

import com.adele.common.ModelAndView;
import com.adele.domain.UserVO;
import com.adele.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller{
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        UserRepository.save(
                new UserVO(request.getParameter("userId"), request.getParameter("name"))
        );
        return new ModelAndView("redirect:/user/list");
    }
}
