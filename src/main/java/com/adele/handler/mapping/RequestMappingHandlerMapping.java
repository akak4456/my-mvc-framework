package com.adele.handler.mapping;

import com.adele.common.HandlerKey;
import com.adele.common.RequestMethod;
import com.adele.controller.Controller;
import com.adele.controller.UserCreateController;
import com.adele.controller.UserFormController;
import com.adele.controller.UserListController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping implements HandlerMapping {
    private Map<HandlerKey, Controller> mappings = new HashMap<HandlerKey, Controller>();
    @Override
    public void init() {
        mappings.put(new HandlerKey(RequestMethod.GET, "/user/list"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/user/form"), new UserFormController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
    }

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
