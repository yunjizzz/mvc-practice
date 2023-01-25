package org.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 클래스 설명
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/19
 */
public class UserListController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("users", List.of());
        return "/user/list.jsp";
    }
}
