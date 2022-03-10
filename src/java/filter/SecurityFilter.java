/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import bean.AccountBean;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AppUtils;
import utils.SecurityUtils;
import wrapper.UserRoleRequestWrapper;

/**
 *
 * @author Admin
 */
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

    /**
     *
     * @param req The servlet request we are processing
     * @param res The servlet response we are creating
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
        String servletPath = request.getServletPath();
        AccountBean loginedUser = AppUtils.getLoginedUser(request.getSession());
        if (servletPath.equals("/Login")) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapRequest = request;
        if (loginedUser != null) {
            String username = loginedUser.getUsername();
            String role = loginedUser.getRole();
            wrapRequest = new UserRoleRequestWrapper(username, role, request);
        }
        if (SecurityUtils.isSecurityPage(request)) {
            if (loginedUser == null) {
                String requestUri = request.getRequestURI();
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
                response.sendRedirect(wrapRequest.getContextPath() + "/Login?redirectId=" + redirectId);
                return;
            }
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
                request.getRequestDispatcher("./view/AccessDenied.jsp").forward(request, response);
                return;
            }
        }
        chain.doFilter(wrapRequest, response);
    }

    /**
     * Return the filter configuration object for this filter.
     *
     * /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }

}
