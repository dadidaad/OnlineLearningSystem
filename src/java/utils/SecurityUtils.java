/*
 * Copyright(C) 2022, FPT University.
 * OLS
 * Online Learning System
 * SecurityUtils
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-09      1.0                 Dajtvox          
 */
package utils;

import config.SecurityConfig;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 * The class contains method isSecurityPage, hasPermission To support check if page need 
 * to login or user has permission to access servlet 
 * Bugs: Still not have yet
 *
 * @author Dajtvox
 */
public class SecurityUtils {

    /**
     * Check if request access a page need to login or not.
     *
     * @param request
     * @return 
     *
     */
    public static boolean isSecurityPage(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);
        Set<String> roles = SecurityConfig.getAllAppRoles();
        return roles.stream().map((role) -> SecurityConfig.getUrlPatternForRole(role)).anyMatch((urlPatterns) -> (urlPatterns != null && urlPatterns.contains(urlPattern)));
    }
    
    /**
     * Check if request access a page have permission to access page or not
     *
     * @param request
     * @return 
     *
     */
    public static boolean hasPermission(HttpServletRequest request){
        String urlPattern = UrlPatternUtils.getUrlPattern(request);
        Set<String> allRoles = SecurityConfig.getAllAppRoles();
        return allRoles.stream().filter((role) -> !(!request.isUserInRole(role))).map((role) -> SecurityConfig.getUrlPatternForRole(role)).anyMatch((urlPatterns) -> (urlPatterns != null && urlPatterns.contains(urlPattern)));
    }
}
