/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import config.SecurityConfig;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
public class SecurityUtils {

    public static boolean isSecurityPage(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);
        Set<String> roles = SecurityConfig.getAllAppRoles();
        return roles.stream().map((role) -> SecurityConfig.getUrlPatternForRole(role)).anyMatch((urlPatterns) -> (urlPatterns != null && urlPatterns.contains(urlPattern)));
    }
    
    public static boolean hasPermission(HttpServletRequest request){
        String urlPattern = UrlPatternUtils.getUrlPattern(request);
        Set<String> allRoles = SecurityConfig.getAllAppRoles();
        return allRoles.stream().filter((role) -> !(!request.isUserInRole(role))).map((role) -> SecurityConfig.getUrlPatternForRole(role)).anyMatch((urlPatterns) -> (urlPatterns != null && urlPatterns.contains(urlPattern)));
    }
}
