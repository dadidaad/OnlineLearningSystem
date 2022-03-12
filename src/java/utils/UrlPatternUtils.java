/*
 * Copyright(C) 2022, FPT University.
 * OLS
 * Online Learning System
 * UrlPatternUtils
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-09      1.0                 Dajtvox          
 */
package utils;

/**
 *
 * Bugs: Still not have yet
 *
 * @author Dajtvox
 */
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

public class UrlPatternUtils {

    private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {

        Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();

        return map.keySet().stream().map((servletName) -> map.get(servletName)).map((sr) -> sr.getMappings()).anyMatch((mappings) -> (mappings.contains(urlPattern)));
    }

    // servletPath:
    // ==> /spath
    // ==> /spath/*
    // ==> *.ext
    // ==> /
    public static String getUrlPattern(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        String urlPattern = null;
        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
            return urlPattern;
        }
        urlPattern = servletPath;

        boolean has = hasUrlPattern(servletContext, urlPattern);
        if (has) {
            return urlPattern;
        }
        int i = servletPath.lastIndexOf('.');
        if (i != -1) {
            String ext = servletPath.substring(i + 1);
            urlPattern = "*." + ext;
            has = hasUrlPattern(servletContext, urlPattern);

            if (has) {
                return urlPattern;
            }
        }
        return "/";
    }
}
