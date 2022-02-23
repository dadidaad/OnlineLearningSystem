/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * LoginController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         DajtVox    First Implement
 */
package Controller;

import Bean.AccountBean;
import Dao.AccountDAO;
import Dao.IAccountDAO;
import Utils.EncryptAndDecryptPassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling login function
 * /Login is the URL of the web site
 * Extend HttpServlet class
 * 
 * @author DajtVox
 */
public class LoginController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("./view/Login.jsp").forward(request, response); //if uri is Login then forward to this page
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username").trim(); // get username input from Login form
            String password = request.getParameter("password").trim(); // get password input from Login form
            String role = request.getParameter("role").trim(); //get role input from Login form
            Map<String, String> messages = new HashMap<>(); //initalize hashmap to hold message 
            messages.put("role", role);
            HttpSession session = request.getSession(); 
            session.setMaxInactiveInterval(1800); //set age for session
            IAccountDAO db = new AccountDAO();
            AccountBean userGetFromDb = db.getAccountByUsername(username); //get AccountBean from database 

            /*check if userGetFromDb is null then no exist user in database, put message to hashmap*/
            if (userGetFromDb == null) {
                messages.put("loginNoti", "User isn't exist");
            } else {
                EncryptAndDecryptPassword passwordUtils = new EncryptAndDecryptPassword();
                /*compare pw input from user and pw in db by decryption pw from db*/
                boolean checkPass = passwordUtils.validatePassword(password, userGetFromDb.getPassword()); 
                boolean checkRole = role.equalsIgnoreCase(userGetFromDb.getRole()); //check role from user and in db
                if (!checkPass) {
                    messages.put("loginNoti", "Invalid password");
                } else if (!checkRole) {
                    messages.put("loginNoti", "Invalid role");
                } else {
                    String remember = request.getParameter("remember"); //check if user tick remember option
                    /* if user tick remember option then create cookie to store user*/
                    if (remember != null) {
                        Cookie c_user = new Cookie("username", username);
                        Cookie c_pass = new Cookie("password", password);
                        c_user.setMaxAge(3600 * 24 * 30);
                        c_pass.setMaxAge(3600 * 24 * 30);
                        response.addCookie(c_pass);
                        response.addCookie(c_user);
                    }
                    session.setAttribute("user", userGetFromDb); // set user in session if login success
                    session.setAttribute("remember", remember);
                    response.sendRedirect("Home"); //redirect to home page
                    return;
                }
            }
            /*set noti in hashmap to request attribute if login fail and forward to login page */
            request.setAttribute("message_forward", messages);
            request.getRequestDispatcher("./view/Login.jsp").forward(request, response);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
