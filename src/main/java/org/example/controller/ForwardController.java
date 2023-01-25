package org.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * forward 컨트롤러
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public class ForwardController implements Controller{

    private final String forwardUriPath;

    public ForwardController(String forwardUriPath) {
        this.forwardUriPath = forwardUriPath;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return forwardUriPath;
    }
}
