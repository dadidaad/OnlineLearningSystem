/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * SignUpController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         DajtVox    First Implement
 */
package controller;

import bean.AccountBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import utils.PasswordUtils;
import utils.SendMailVerify;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling sign up function of the web site
 * Extend HttpServlet class
 *
 * @author DajtVox
 */
public class SignUpController extends HttpServlet {

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
        request.getRequestDispatcher("./view/SignUp.jsp").forward(request, response); // forward sign up page
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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* get data from input form from user*/
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String email = request.getParameter("email").trim();
            String sex = request.getParameter("sex").trim();
            String encryptionPassword = PasswordUtils.generatePasswordHash(password); // encryp password to PBKD type then reutnr encryption password
            /* set value to AccountBean object */
            AccountBean newUser = new AccountBean();
            newUser.setUsername(username);
            newUser.setPassword(encryptionPassword);
            newUser.setMail(email);
            newUser.setSex(sex);
            Map<String, String> message = new HashMap<>();
            IAccountDAO accountDAO = new AccountDAO();
            boolean checkUserExist = accountDAO.getAccountByUsername(username) == null; // check if username exist in data, if exist then put to message
            boolean checkMailExist = accountDAO.getAccountByMail(email) == null; //check if email is exist in data, if exist then put to message
            if (!checkUserExist) {
                message.put("userInvalid", "User is exist");
            }
            if (!checkMailExist) {
                message.put("mailInvalid", "Mail is exist");
            }
            /* if not both exist then do next action*/
            if (checkUserExist && checkMailExist) {
                SendMailVerify mailUtils = new SendMailVerify();
                String token = mailUtils.generateCaptchaString(); // generate captcha string from mailUtils
                newUser.setToken(token); // set token from generated token for new user
                boolean sendMailStatus = mailUtils.sendEmail(newUser); // send mail to user, if success then do next action
                if (sendMailStatus) {
                    /*if success then create new session hold AccountBean object of user*/
                    HttpSession session = request.getSession();
                    session.setAttribute("userRes", newUser);
                    message.put("notiRes", "success");
                } else {
                    message.put("notiRes", "error");
                }
            }
            String jsonData = new ObjectMapper().writeValueAsString(message); //convert hashmap to json
            out.print(jsonData); //send data to client
            out.flush();
        } catch (Exception ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
