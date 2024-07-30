package com.adele.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectionView implements View{
    private final String viewName;

    public RedirectionView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(viewName.substring("redirect:".length()));
    }
}
