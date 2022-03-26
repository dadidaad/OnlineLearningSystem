/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * ChangeStatusAccountController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.AccountBean;
import bean.NotificationBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import dao.INotificationDAO;
import dao.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the Admin wants to
 * ban or active an account /ChangeStatusAccount is the URL of the Servlet Extend
 * HttpServlet class
 *
 * @author Duc Minh
 */
public class ChangeStatusAccountController extends HttpServlet {
  
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            IAccountDAO iAccount = new AccountDAO();
            AccountBean account = iAccount.getAccountByUsername(username);
            String checkActived= "",checkBanned="";
            if(account.getStatus().equalsIgnoreCase("Actived")) checkActived = "checked";
                else checkBanned="checked";
            
            
            out.print("<h1 class=\"h3 mt-2 ml-5 mb-3 text-gray-800\">Edit Detail</h1>\n" +
"           <form action=\"ChangeStatusAccount\" method=\"post\" id=\"updateAccountRequest\">\n" +
"                        <div class=\"card-body\">\n" +
"                            <div class=\"mb-3\">\n" +
"                                <input\n" +
"                                    type=\"hidden\"\n" +
"                                    class=\"form-control\"\n" +
"                                    id=\"exampleFormControlInput1\"\n" +
"                                    value=\""+account.getUsername()+"\"\n" +
"                                    name=\"username\"\n" +
"                                    />\n" +
"                            </div>\n" +
"                            <div class=\"mb-3\">\n" +
"                                <label for=\"exampleFormControlInput1\" class=\"form-label\">Name</label>\n" +
"                                <input\n" +
"                                    type=\"text\"\n" +
"                                    class=\"form-control\"\n" +
"                                    id=\"exampleFormControlInput1\"\n" +
"                                    value=\""+account.getDisplayName()+"\"\n" +
"                                    readonly\n" +
"                                    />\n" +
"\n" +
"                            </div>\n" +
"                            <div class=\"mb-3\">\n" +
"                                <label for=\"exampleFormControlInput1\" class=\"form-label\">Email</label>\n" +
"                                <input\n" +
"                                    type=\"email\"\n" +
"                                    class=\"form-control\"\n" +
"                                    id=\"exampleFormControlInput1\"\n" +
"                                    value=\""+account.getMail()+"\"\n" +
"                                    readonly\n" +
"                                    />\n" +
"                            </div>\n"+ 
"                            <div class=\"mb-3\">\n" +
"                                <label for=\"exampleFormControlInput1\" class=\"form-label\">Role</label>\n" +
"                                <input\n" +
"                                    type=\"text\"\n" +
"                                    class=\"form-control\"\n" +
"                                    id=\"exampleFormControlInput1\"\n" +
"                                    value=\""+account.getRole()+"\"\n" +
"                                    readonly\n" +
"                                    />\n" +
"\n" +
"                            </div>" +
"                            <div class=\"mb-3\">\n" +
"                                <div class=\"form-check\">\n" +
"                                    <input\n" +
"                                        class=\"form-check-input\"\n" +
"                                        type=\"radio\"\n" +
"                                        name=\"accountStatus\"\n" +
"                                        id=\"flexRadioDefault1\"\n" +
"                                        value=\"Actived\"\n" +
"                                        "+checkActived+"\n" +
"                                        />\n" +
"                                    <label class=\"form-check-label\" for=\"flexRadioDefault1\"> Active </label>\n" +
"                                </div>\n" +
"                                <div class=\"form-check\">\n" +
"                                    <input\n" +
"                                        class=\"form-check-input\"\n" +
"                                        type=\"radio\"\n" +
"                                        name=\"accountStatus\"\n" +
"                                        id=\"flexRadioDefault2\"\n" +
"                                        value=\"Banned\"\n" +        
                                        ""+checkBanned+"\n"+
"                                        />\n" +
"                                    <label class=\"form-check-label\" for=\"flexRadioDefault2\"> Ban </label>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                            <button type=\"submit\" class=\"btn btn-success\">Update</button>\n" +
"                            <a href=\"AccountManager\" type=\"button\" class=\"btn btn-secondary\">Cancel</a>\n" +
"                        </div>"+ 
//        "<input type=\"submit\" class=\"btn btn-primary mt-3\" value=\"ReupLoad Request\" />\n" +
"                </form>");
        
        } catch (Exception ex) {
            Logger.getLogger(ChangeStatusAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String status = request.getParameter("accountStatus");
            
            IAccountDAO iAccount = new AccountDAO();
            iAccount.updateStatusAccount(username, status);
            INotificationDAO iNotificationDAO = new NotificationDAO();
            if(status.toLowerCase().equals("actived")){
                iNotificationDAO.insertNotification(new NotificationBean(username,"Admin", "Your account has been actived by Admin!"));
            }else if(status.toLowerCase().equals("banned")){
                iNotificationDAO.insertNotification(new NotificationBean(username,"Admin", "Your account has been banned by Admin!"));
            }
            
            response.sendRedirect("AccountManager");
        }catch(Exception e){
        
        }
        
    }



}
