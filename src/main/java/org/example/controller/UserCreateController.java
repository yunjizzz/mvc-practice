package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 유저 생성 컨트롤러
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public class UserCreateController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // user 추가
        UserRepository.save(new User(request.getParameter("userId"), request.getParameter("name")));
        return "redirect:/users";
    }

}
