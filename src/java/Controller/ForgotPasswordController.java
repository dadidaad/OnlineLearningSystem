/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * ForgotPasswordController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         DajtVox    First Implement
 */
package Controller;

import Bean.AccountBean;
import Dao.AccountDAO;
import Dao.IAccountDAO;
import Utils.EncryptAndDecryptPassword;
import Utils.SendMailVerify;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling forgot password function of the
 * web site Extend HttpServlet class
 *
 * @author DajtVox
 */
public class ForgotPasswordController extends HttpServlet {

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
        request.getRequestDispatcher("./view/ForgotPassword.jsp").forward(request, response); //forward forgotpassword page
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost_CheckMailExist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email").trim(); //get email from request parammeter
            IAccountDAO accountDAO = new AccountDAO();
            AccountBean userGetFromDb = accountDAO.getAccountByMail(email);
            if (userGetFromDb == null) {
                out.print("Email isn't exist");
            } else {
                SendMailVerify mailUtils = new SendMailVerify();
                String token = mailUtils.generateCaptchaString(); // generate captcha string from mailUtils
                userGetFromDb.setToken(token); // set token from generated token for new user
                boolean sendMailStatus = mailUtils.sendEmail(userGetFromDb); // send mail to user, if success then do next action
                if (sendMailStatus) {
                    /*if success then create new session hold AccountBean object of user*/
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(900); //set age for session
                    session.setAttribute("userReset", userGetFromDb);
                    out.print("success");
                } else {
                    out.print("Error while trying to send verify captcha to email!! Try again");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost_VerifyCaptcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            String captcha = request.getParameter("captcha"); //get captcha from user input
            HttpSession session = request.getSession(false); //call session in requét
            AccountBean userResetPw = (AccountBean) session.getAttribute("userReset"); //get AccountBean object of user reset password
            if (userResetPw == null) {
                out.print("Time out!! Please resend new captcha or input new email");
                return;
            }
            boolean checkToken = captcha.equals(userResetPw.getToken()); //compare captcha in session and captcha user input
            if (checkToken) {
                out.print("success");
            } else {
                out.print("Invalid captcha");
            }
        } catch (Exception ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost_ResetPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            String newPassword = request.getParameter("password"); //get new password from input form
            HttpSession session = request.getSession(false);
            AccountBean resetUser = (AccountBean) session.getAttribute("userReset"); //call reset User from session
            EncryptAndDecryptPassword pwUtils = new EncryptAndDecryptPassword();
            String encryptionPw = pwUtils.generatePasswordHash(newPassword); //encrypt password and set it to reset User
            resetUser.setPassword(encryptionPw);
            IAccountDAO accountDAO = new AccountDAO();
            boolean checkUpdatePw = accountDAO.updateNewPassword(resetUser); //call updateNewPassword method from AccountDAO
            if(checkUpdatePw){
                out.print("success");
                session.removeAttribute("userReset");
            }
            else{
                out.print("Error while update new password!! Please try again");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
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
        String step = request.getParameter("step"); //get step of reseting password from user;
        /*check step to call corresspoding method*/
        if (step.equalsIgnoreCase("mailverify")) {
            doPost_CheckMailExist(request, response);
        }
        if (step.equalsIgnoreCase("captchaverify")) {
            doPost_VerifyCaptcha(request, response);
        }
        if (step.equalsIgnoreCase("resetpassword")) {
            doPost_ResetPassword(request, response);
        }
    }

}
