/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * ResendCaptchaController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-15   1.0         DajtVox    First Implement
 */
package controller;

import bean.AccountBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import utils.PasswordUtils;
import utils.SendMailVerify;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling resend captcha function of the
 * sign up screen and forgot password Extend HttpServlet class
 *
 * @author DajtVox
 */
@WebServlet(name = "ResendCaptchaController", urlPatterns = {"/ResendToken"})
public class ResendCaptchaController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost_SendFromReset(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            String resetEmail = request.getParameter("email_reset"); //get email reset
            IAccountDAO accountDAO = new AccountDAO();
            AccountBean resetUser = accountDAO.getAccountByMail(resetEmail); //check if data has been changed
            SendMailVerify mailUtils = new SendMailVerify();
            String token = mailUtils.generateCaptchaString(); // generate captcha string from mailUtils
            resetUser.setToken(token); // set token from generated token for new user
            boolean sendMailStatus = mailUtils.sendEmail(resetUser); // send mail to user, if success then do next action
            if (sendMailStatus) {
                /*if success then create new session hold AccountBean object of user*/
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(900); //set age for session
                session.setAttribute("userReset", resetUser);
                out.print("Resended captcha!!");
            } else {
                out.print("Error when resend!! Please try again");
            }
        } catch (Exception ex) {
            Logger.getLogger(ResendCaptchaController.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print("Invalid data!! Please try again!");
        }
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
        if(request.getParameter("email_reset") != null){
            doPost_SendFromReset(request, response);
            return;
        }
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String email = request.getParameter("email").trim();
            String sex = request.getParameter("sex").trim();
            String encryptionPassword = PasswordUtils.generatePasswordHash(password); // encryp password to PBKD type then return encryption password
            /* set value to AccountBean object */
            AccountBean newUser = new AccountBean();
            newUser.setUsername(username);
            newUser.setPassword(encryptionPassword);
            newUser.setMail(email);
            newUser.setSex(sex);
            IAccountDAO accountDAO = new AccountDAO();
            boolean checkUserExist = accountDAO.getAccountByUsername(username) == null; // check if username exist in data, if exist then put to message
            boolean checkMailExist = accountDAO.getAccountByMail(email) == null; //check if email is exist in data, if exist then put to message
            /*check if input value changed, if haved then return*/
            if (!checkUserExist || !checkMailExist) {
                out.print("Invalid data!! Please try again");
                return;
            }
            if (checkUserExist && checkMailExist) {
                SendMailVerify mailUtils = new SendMailVerify();
                String token = mailUtils.generateCaptchaString(); // generate captcha string from mailUtils
                newUser.setToken(token); // set token from generated token for new user
                boolean sendMailStatus = mailUtils.sendEmail(newUser); // send mail to user, if success then do next action
                if (sendMailStatus) {
                    /*if success then create new session hold AccountBean object of user*/
                    HttpSession session = request.getSession();
                    session.setAttribute("userRes", newUser);
                    out.print("Resended captcha!!");
                } else {
                    out.print("Error when resend!! Please try again");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ResendCaptchaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
