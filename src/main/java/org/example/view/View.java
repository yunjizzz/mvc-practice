package org.example.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * view interface
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public interface View {
    void render(Map<String,?> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
