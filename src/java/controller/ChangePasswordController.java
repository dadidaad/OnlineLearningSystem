/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * ViewProfileUserController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-25   1.0         DajtVox    First Implement
 */
package controller;

import bean.AccountBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import utils.PasswordUtils;
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
 * This is a Servlet responsible for change password of login user web page
 * Extend HttpServlet class
 *
 * @author DajtVox
 */
public class ChangePasswordController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String oldPassword = request.getParameter("oldPassword").trim(); //get old password from input
            HttpSession session = request.getSession(false); // get session from request
            AccountBean loginUser = (AccountBean) session.getAttribute("user"); //get account bean object from session
            boolean checkOldPassword = PasswordUtils.validatePassword(oldPassword, loginUser.getPassword());
            /*check if old password is correct if not then return*/
            if (!checkOldPassword) {
                out.print("Wrong old password");
                return;
            }
            String newPassword = request.getParameter("newPassword").trim(); //get new password
            newPassword = PasswordUtils.generatePasswordHash(newPassword); //hash new password and set it to user account 
            loginUser.setPassword(newPassword);
            IAccountDAO accountDAO = new AccountDAO();
            boolean checkUpdatePass = accountDAO.updateNewPassword(loginUser); //pass account user to dao, if success update then return true
            if (checkUpdatePass) {
                out.print("Update password success");
            } else {
                out.print("Error when change password!! Try again");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
