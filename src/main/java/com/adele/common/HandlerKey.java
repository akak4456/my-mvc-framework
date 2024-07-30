package com.adele.common;

import java.util.Objects;

public class HandlerKey {
    private final RequestMethod requestMethod;
    private final String requestURI;

    public HandlerKey(RequestMethod requestMethod, String requestURI) {
        this.requestMethod = requestMethod;
        this.requestURI = requestURI;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public String getRequestURI() {
        return requestURI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HandlerKey that)) return false;
        return requestMethod == that.requestMethod && Objects.equals(requestURI, that.requestURI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestMethod, requestURI);
    }
}
