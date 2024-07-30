package com.adele.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationHandler {
    private Class<?> clazz;
    private Method targetMethod;
    public AnnotationHandler(Class<?> clazz, Method targetMethod) {
        this.clazz = clazz;
        this.targetMethod = targetMethod;
    }

    public Object handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();

        Object controller = constructor.newInstance();
        return targetMethod.invoke(controller, request, response);
    }
}
