/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * ViewRequestStuController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.AccountBean;
import bean.ReportBean;
import bean.RequestBean;
import bean.RequestReplyBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import dao.IRequestDAO;
import dao.ISubjectDAO;
import dao.ReportDAO;
import dao.RequestDAO;
import dao.SubjectDAO;
import dao.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the student wants to view and handle Request
 * /ViewRequestStu is the URL of the Servlet
 * Extend HttpServlet class
 * @author Duc Minh
 */
public class ViewRequestStuController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            int rqId = Integer.parseInt(request.getParameter("requestId"));
            
                IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
                RequestBean rq  = iRequestDAO.getRequestById(rqId);
                RequestReplyBean rqReply  = iRequestDAO.getRequestReplyById(rqId);
                
                ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                Map<Integer, String> subjectNames = iSubjectDAO.getSubjectNames();
                
                 IAccountDAO iAccountDAO = new AccountDAO(); //Use ISubjectDAO interface to call
                Map<String, String> displayNames = iAccountDAO.getDisplayNames();
                
                //Attach Attribute teachers for request and redirect it to ListAllRequestStu.jsp
                request.setAttribute("request", rq);
                request.setAttribute("requestReply", rqReply);
                request.setAttribute("subjectNames", subjectNames);
                request.setAttribute("displayNames", displayNames);
            

                /*Attach Attribute subjects for request and redirect it to ViewRequestDetailStu.jsp*/
                request.getRequestDispatcher("./view/ViewRequestDetailStu.jsp").forward(request, response);
        }catch(Exception ex){
             Logger.getLogger(ViewRequestStuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String status = request.getParameter("btn-status");
        
        int rqId = Integer.parseInt(request.getParameter("requestId"));
            
        IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
        RequestBean rq  = iRequestDAO.getRequestById(rqId);
        RequestReplyBean rqReply  = iRequestDAO.getRequestReplyById(rqId);
        WalletDAO walletDB = new WalletDAO();
        ReportDAO reportDB = new ReportDAO();
        AccountDAO accountDB = new AccountDAO();
        AccountBean tutorAccount = accountDB.getAccountByUsername(rqReply.getTutorSent());
        
        if(status.equalsIgnoreCase("accept")) {
            //Send money to Tutor
            walletDB.UpdateMoney(tutorAccount, rq.getCost(), tutorAccount.getUsername(), "done request");
        }
        else if(status.equalsIgnoreCase("not-accept")){
            //Send report to admin
            reportDB.CreateReport(rqId, rq.getStudentSent(), rqReply.getTutorSent(), rq.getTitle());
        }
        
        response.sendRedirect("ListAllRequest");
    }
    
    
}
