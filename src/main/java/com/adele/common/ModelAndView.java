package com.adele.common;

import java.util.Map;

public class ModelAndView {
    private Map<String, Object> model;
    private Object view;
    public ModelAndView(String viewName) {
        view = viewName;
    }

    public String getViewName() {
        if(view instanceof  String) {
            return (String)view;
        } else {
            return null;
        }
    }
}
