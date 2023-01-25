package org.example.view;

import static org.example.view.RedirectView.DEFAULT_REDIRECT_PREFIX;

/**
 * Jsp View Resolver
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public class JspViewResolver implements ViewResolver{
    @Override
    public View resolveViewName(String viewName) {
        if(viewName.startsWith(DEFAULT_REDIRECT_PREFIX)){
            return new RedirectView(viewName);
        }
        return new JspView(viewName + ".jsp");
    }

}
