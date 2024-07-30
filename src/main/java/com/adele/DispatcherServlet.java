package com.adele;

import com.adele.common.HandlerKey;
import com.adele.common.ModelAndView;
import com.adele.common.RequestMethod;
import com.adele.handler.adapter.AnnotationHandlerAdapter;
import com.adele.handler.adapter.HandlerAdapter;
import com.adele.handler.adapter.InheritanceHandlerAdapter;
import com.adele.handler.mapping.AnnotationHandlerMapping;
import com.adele.handler.mapping.HandlerMapping;
import com.adele.handler.mapping.RequestMappingHandlerMapping;
import com.adele.view.View;
import com.adele.viewresolver.SimpleViewResolver;
import com.adele.viewresolver.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private List<HandlerMapping> handlerMappings;
    private List<HandlerAdapter> handlerAdapters;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        RequestMappingHandlerMapping rm = new RequestMappingHandlerMapping();
        rm.init();
        AnnotationHandlerMapping am = new AnnotationHandlerMapping("com.adele");
        am.init();
        handlerMappings = List.of(rm, am);
        handlerAdapters = List.of(new InheritanceHandlerAdapter(), new AnnotationHandlerAdapter());
        viewResolver = new SimpleViewResolver();
        super.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. DispatcherServlet 이 모든 요청을 받는다.
        RequestMethod requestMethod = RequestMethod.valueOf(request.getMethod());
        String requestURI = request.getRequestURI();
        HandlerKey handlerKey = new HandlerKey(requestMethod, requestURI);
        log.info("service start");
        // 2. HandlerMapping 에서 적절한 Controller 를 반환한다.
        Object controller = handlerMappings.stream().map(handlerMapping -> handlerMapping.findHandler(handlerKey))
                        .filter(Objects::nonNull).findFirst().orElseThrow(() -> new ServletException("no handler(controller) found"));
        // 3. 반환된 controller 에 적절한 HandlerAdapter 를 찾아보도록 한다.
        HandlerAdapter handlerAdapter = handlerAdapters.stream().filter(ha -> ha.supports(controller)).findFirst().orElseThrow(() -> new ServletException("no handler(controller) adapter found"));
        // 4. HandlerAdapter를 handle 해서 ModelAndView 를 받아본다.
        ModelAndView modelAndView = handlerAdapter.handle(controller, request, response);
        // 5. ModelAndView 에 적절한 View를 ViewResolver를 통해 받는다.
        View view = viewResolver.resolve(modelAndView);
        // 6. 뷰를 렌더링해서 서비스를 마무리한다.
        view.render(request, response);
        log.info("service end");
    }
}
