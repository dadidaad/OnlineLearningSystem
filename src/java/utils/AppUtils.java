/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import bean.AccountBean;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class AppUtils {

    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> ID_URI_MAP = new HashMap<Integer, String>();
    private static final Map<String, Integer> URI_ID_MAP = new HashMap<String, Integer>();

    // Lưu trữ thông tin người dùng vào Session.
    public static void storeLoginedUser(HttpSession session, AccountBean loginedUser) {
        // Trên JSP có thể truy cập thông qua ${loginedUser}
        session.setAttribute("user", loginedUser);
    }

    // Lấy thông tin người dùng lưu trữ trong Session.
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
