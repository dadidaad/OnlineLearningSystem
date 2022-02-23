/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * LoginFilter
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-15   1.0         DajtVox    First Implement
 */
package Filter;

import Bean.AccountBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a filter to check request of user if exist in session then no access
 * to login or sign up implements filter class
 *
 * @author DajtVox
 */
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request; // get request servlet
        HttpServletResponse res = (HttpServletResponse) response; //get response servlet
        HttpSession session = req.getSession(false); //call session from request
        AccountBean loginUser = null;

        if (session != null) {
            loginUser = (AccountBean) session.getAttribute("user");
        }

        boolean isLoggedIn = (loginUser != null);
        String reuUrl = req.getServletPath();
        // Check if the user is accessing login page
        if (reuUrl.contains(
                "Login")
                || reuUrl.contains(
                "SignUp")
                || reuUrl.contains(
                "ResetPassword")) {
            if (isLoggedIn) {
                // Redirect to landing or home page
                res.sendRedirect("Home");
            } else {
                // Otherwise, nothing to do if he has not logged in
                // pass the request along the filter chain
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
