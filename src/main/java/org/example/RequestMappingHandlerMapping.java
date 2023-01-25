package org.example;

import org.example.controller.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Handler mapping
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/19
 */
public class RequestMappingHandlerMapping implements HandlerMapping{
    private final Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init(){
        mappings.put(new HandlerKey(RequestMethod.GET,"/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET,"/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST,"/users"), new UserCreateController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));
    }
    public Controller findHandler(HandlerKey handlerKey)
    {
        return mappings.get(handlerKey);
    }
}
