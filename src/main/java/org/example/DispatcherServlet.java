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

    private RequestMappingHandlerMapping rmhm;

    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();

        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started");
        try {
            Controller handler = rmhm.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()),request.getRequestURI()));
            String viewName = handler.handleRequest(request, response);

            // redirect:/users 라고 요청 올 경우 처리 X
            // 즉 forward, redirect 구분해주어야 한다.
            for(ViewResolver viewResolver: viewResolvers){
                View view = viewResolver.resolveView(viewName);
                view.render(new HashMap<>(),request, response);
            }

        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage());
            throw new ServletException(e);
        }
    }
}
