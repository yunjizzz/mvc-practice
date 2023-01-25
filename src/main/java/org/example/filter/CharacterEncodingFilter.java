package org.example.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 한글이 깨지는 문제
 * request, response 에 UTF-8 적용
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(DEFAULT_ENCODING);
        response.setCharacterEncoding(DEFAULT_ENCODING);

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
