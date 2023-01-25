package org.example.view;

/**
 * view resolver interface
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public interface ViewResolver {
    View resolveViewName(String viewName);
}
