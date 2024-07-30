package com.adele.viewresolver;

import com.adele.common.ModelAndView;
import com.adele.view.View;

public interface ViewResolver {
    View resolve(ModelAndView modelAndView);
}
