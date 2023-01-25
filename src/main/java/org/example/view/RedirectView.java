package org.example.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * redirect용 view
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public class RedirectView implements View{

    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private final String viewName;

    public RedirectView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(viewName.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }
}
