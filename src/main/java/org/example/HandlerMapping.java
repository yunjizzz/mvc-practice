package org.example;

import org.example.controller.Controller;

/**
 * 클래스 설명
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
