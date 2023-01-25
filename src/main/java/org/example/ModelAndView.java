package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 클래스 설명
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public class ModelAndView {
    private Object view;
    private Map<String, Object> model = new HashMap<>();
    public ModelAndView(String viewName) {
        view = viewName;
    }

    public Map<String,Object> getModel() {
        return Collections.unmodifiableMap(model);
    }

    public String getViewName() {
        return (this.view instanceof String ? (String) this.view : null);
    }
}
