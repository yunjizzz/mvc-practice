package org.example;

import org.apache.catalina.User;
import org.example.controller.Controller;
import org.example.controller.HomeController;
import org.example.controller.UserListController;

import java.util.HashMap;
import java.util.Map;

/**
 * 클래스 설명
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/19
 */
public class RequestMappingHandlerMapping {
    private final Map<String, Controller> mappings = new HashMap<>();

    void init(){
        mappings.put("/", new HomeController());
        mappings.put("/users", new UserListController());
    }
    public Controller findHandler(String uriPath){
        return mappings.get(uriPath);
    }
}
