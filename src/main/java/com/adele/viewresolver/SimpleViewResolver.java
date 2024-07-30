package com.adele.viewresolver;

import com.adele.common.ModelAndView;
import com.adele.view.JspView;
import com.adele.view.RedirectionView;
import com.adele.view.View;

public class SimpleViewResolver implements ViewResolver {
    @Override
    public View resolve(ModelAndView modelAndView) {
        String viewName = modelAndView.getViewName();
        if(viewName.startsWith("redirect")) {
            return new RedirectionView(viewName);
        }
        return new JspView(viewName);
    }
}
