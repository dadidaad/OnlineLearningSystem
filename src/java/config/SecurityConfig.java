/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class SecurityConfig {

    public static final String ADMIN_ROLE = "Admin";
    public static final String TEACHER_ROLE = "Teacher";
    public static final String STUDENT_ROLE = "Student";
    private static final Map<String, List<String>> MAP_CONFIG = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> studentPattern = new ArrayList<>();
        studentPattern.add("/ViewProfile");
        studentPattern.add("/EditProfile");
        studentPattern.add("/BecomeTutor");
        studentPattern.add("/ChangePassword");
        studentPattern.add("/CreateRequest");
        studentPattern.add("/ViewRequestStu");
        studentPattern.add("/ListAllRequest");
        studentPattern.add("/DeleteRequest");
        studentPattern.add("/UpdateRequest");
        studentPattern.add("/ListRequestSearch");
        studentPattern.add("/TeacherRecommendSearch");
        MAP_CONFIG.put(STUDENT_ROLE, studentPattern);// Configure the "Student" role.

        List<String> teacherPattern = new ArrayList<>();
        teacherPattern.add("/ViewProfile");
        teacherPattern.add("/EditProfile");
        teacherPattern.add("ChangePassword");
        teacherPattern.add("/ViewRequestTea");
        teacherPattern.add("/CreateRequestReply");
        teacherPattern.add("/ListAllRequest");
        teacherPattern.add("/ListRequestSearch");
        MAP_CONFIG.put(TEACHER_ROLE, teacherPattern); // Configure the "Teacher" role.

        List<String> adminPattern = new ArrayList<>();
        adminPattern.add("/ViewProfile");
        adminPattern.add("/EditProfile");
        adminPattern.add("/ChangePassword");
        adminPattern.add("/AccountManager");
        adminPattern.add("/AccountManagerSearch");
        adminPattern.add("/TeacherRequest");
        adminPattern.add("/TeacherRequestHandle");
        adminPattern.add("/Dashboard");
        adminPattern.add("/TeacherRequestSearch");
        adminPattern.add("/ChangeStatusAccount");
        MAP_CONFIG.put(ADMIN_ROLE, adminPattern); // Configure the "Admin" role.
    }

    public static Set<String> getAllAppRoles() {
        return MAP_CONFIG.keySet();
    }

    public static List<String> getUrlPatternForRole(String role) {
        return MAP_CONFIG.get(role);
    }

}
