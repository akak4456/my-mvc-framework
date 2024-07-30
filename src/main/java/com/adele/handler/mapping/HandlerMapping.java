package com.adele.handler.mapping;

import com.adele.common.HandlerKey;

public interface HandlerMapping {
    void init();
    Object findHandler(HandlerKey handlerKey);
}
