package com.adele.handler.mapping;

import com.adele.annotation.Controller;
import com.adele.annotation.RequestMapping;
import com.adele.common.HandlerKey;
import com.adele.handler.AnnotationHandler;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationHandlerMapping implements HandlerMapping{

    private Object[] basePackage;
    private Map<HandlerKey, AnnotationHandler> mappings = new HashMap<>();

    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public void init() {
        Reflections reflections = new Reflections(basePackage);

        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Controller.class);
        classes.stream().forEach(clazz -> {
            Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod -> {
                RequestMapping requestMapping = declaredMethod.getAnnotation(RequestMapping.class);
                Arrays.stream(requestMapping.method()).forEach(method -> {
                    mappings.put(new HandlerKey(method, requestMapping.value()), new AnnotationHandler(clazz, declaredMethod));
                });
            });

        });
    }

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
