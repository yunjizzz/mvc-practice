package org.example;

import org.example.controller.Controller;
import org.example.controller.RequestMethod;
import org.example.view.JspViewResolver;
import org.example.view.View;
import org.example.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Dispatcher servlet
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/19
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    private HandlerMapping handlerMapping;

    private List<ViewResolver> viewResolvers;

    private List<HandlerAdapter> handlerAdapters;

    @Override
    public void init() throws ServletException {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();

        handlerMapping = requestMappingHandlerMapping;
        //handler adapter
        handlerAdapters = List.of(new SimpleControllerHandlerAdapter());
        // view resolver
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started");
        try {
            Object handler = handlerMapping.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()),request.getRequestURI()));

            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                    .filter(ha -> ha.supports(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("no adapter for handler is "+ handler));

            ModelAndView modelAndView = handlerAdapter.handle(request,response,handler);


            for(ViewResolver viewResolver: viewResolvers){
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(),request, response);
            }

        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage());
            throw new ServletException(e);
        }
    }
}
