/*
 * Copyright(C) 2022, FPT University.
 * OLS
 * Online Learning System
 * AppUtils
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-09      1.0                 Dajtvox          
 */
package utils;

import bean.AccountBean;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 * The class contains method storeLoginedUser, getLoginedUser To support store user in session 
 * after logined to application
 * Bugs: Still not have yet
 *
 * @author Dajtvox
 */
public class AppUtils {

    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> ID_URI_MAP = new HashMap<Integer, String>();
    private static final Map<String, Integer> URI_ID_MAP = new HashMap<String, Integer>();

    /**
     * Add information of user to session .
     *
     * @param session session from request It is
     * a <code>javax.servlet.http.HttpSession</code> object
     * @param loginedUser object
     *
     */
    public static void storeLoginedUser(HttpSession session, AccountBean loginedUser) {
        // Trên JSP có thể truy cập thông qua ${loginedUser}
        session.setMaxInactiveInterval(60 * 30);
        session.setAttribute("user", loginedUser);
    }

    /**
     * Get information of user from session .
     *
     * @param session session from request It is
     * a <code>javax.servlet.http.HttpSession</code> object
     * @return AccountBean object
     *
     */
    public static AccountBean getLoginedUser(HttpSession session) {
        AccountBean loginedUser = (AccountBean) session.getAttribute("user");
        return loginedUser;
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = URI_ID_MAP.get(requestUri);

        if (id == null) {
            id = REDIRECT_ID++;

            URI_ID_MAP.put(requestUri, id);
            ID_URI_MAP.put(id, requestUri);
            return id;
        }

        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = ID_URI_MAP.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }

}
