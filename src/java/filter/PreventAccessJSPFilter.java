/*
 * Copyright(C) 2022, FPT University.
 * OLS
 * Online Learning System
 * PreventAccessJSPFilter
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-09      1.0                 Dajtvox          
 */
package filter;

import bean.AccountBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AppUtils;

/**
 * The filter contains method doFilter to prevent user directly access jsp page or login servlet after logined
 * Bugs: Still not have yet
 *
 * @author Dajtvox
 */
public class PreventAccessJSPFilter implements Filter {
    
   
    
    /**
     *
     * @param req
     * @param res
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uriPath = request.getRequestURI();
        String servletPath = request.getServletPath();
        /*if uri cotainer .jsp that user access directly to jsp page, return home*/
        if(uriPath.contains(".jsp")){
            response.sendRedirect("Home");
            return;
        }
        AccountBean loginedUser = AppUtils.getLoginedUser(request.getSession());
        /*if servletPath contains login and user already logined, return home*/
        if(loginedUser != null){
            if(servletPath.equals("/Login") || servletPath.equals("/SignUp") || servletPath.equals("/ResetPassword")){
                response.sendRedirect("Home");
                return;
            }
        }
        chain.doFilter(request, response);
    }

 
    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        
    }

  
    
}
