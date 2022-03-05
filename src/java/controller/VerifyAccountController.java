/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * VerifyAccountController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         DajtVox    First Implement
 */
package controller;

import bean.AccountBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import utils.SendMailVerify;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling verify captcha of the sign up
 * function Extend HttpServlet class
 *
 * @author DajtVox
 */
public class VerifyAccountController extends HttpServlet {

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
        try(PrintWriter out = response.getWriter()){
            String captcha = request.getParameter("captcha"); //get catpcha from request
            HttpSession session = request.getSession(false); //call session from request
            AccountBean newUser = (AccountBean) session.getAttribute("userRes"); //call newUser from session create in SignUpController
            if(newUser == null){
                out.print("Time out for captcha!! Please create new one!!"); //check if session is still exist, if no then return
                return;
            }
            boolean checkToken = captcha.equals(newUser.getToken()); //create boolean to check equals with input captcha and captcha in session
            if(checkToken){
                IAccountDAO accountDAO = new AccountDAO();
                boolean checkInsertAccount = accountDAO.insertNewAccount(newUser); //insert account in session to database
                /*check status of inserting*/
                if(checkInsertAccount){
                    out.print("success");
                }
                else{
                    out.print("Error when create new account!! Please try again!!");
                }
            }
            else{
                out.print("Invalid captcha");
            }
        }
        catch(Exception ex){
             Logger.getLogger(VerifyAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
