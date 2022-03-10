/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Admin
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
        if(uriPath.contains(".jsp")){
            response.sendRedirect("Home");
            return;
        }
        AccountBean loginedUser = AppUtils.getLoginedUser(request.getSession());
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
