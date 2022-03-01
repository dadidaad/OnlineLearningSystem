/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Online Learning System

 * ListAllRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         Duc Minh   First Implement
 */
package Controller;

import Bean.AccountBean;
import Bean.RequestBean;
import Dao.AccountDAO;
import Dao.IAccountDAO;
import Dao.IRequestDAO;
import Dao.ISubjectDAO;
import Dao.ITeacherDAO;
import Dao.RequestDAO;
import Dao.SubjectDAO;
import Dao.TeacherDAO;
import Utils.SortRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when the user wants to see the list of Request
 * /ListALlRequest is the URL of the Servlet
 * Extend HttpServlet class
 * @author Duc Minh
 */
public class ListAllRequestController extends HttpServlet {


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
                
            HttpSession session = request.getSession();   
            AccountBean account =(AccountBean) session.getAttribute("user");
            if(account!=null){
                SortRequest sortRequest = new SortRequest();
                ArrayList <RequestBean> requestList = new ArrayList<>();//call the sort modify class
                IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
                
                ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();
                
                IAccountDAO iAccountDAO = new AccountDAO(); //Use ISubjectDAO interface to call
                Map<String, String> DisplayNames = iAccountDAO.getDisplayNames();
                
                
                request.setAttribute("subjectNames", SubjectNames);
                request.setAttribute("displayNames", DisplayNames);
              if(account.getRole().equalsIgnoreCase("student")){ 
                  requestList = iRequestDAO.getRequestForStudent(account.getUsername(), "Waiting");
                  request.setAttribute("requests", requestList);
               
                 /*Attach Attribute teachers for request and redirect it to ListAllRequestStu.jsp  */
                request.getRequestDispatcher("./view/ListAllRequestStu.jsp").forward(request, response);
                
              }else if( account.getRole().equalsIgnoreCase("teacher")){
                    
                    ITeacherDAO iteacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
                    int subjectId = iteacherDAO.getSubjectId(account.getUsername());
                    requestList = iRequestDAO.getRequestForTeacher(subjectId, "Waiting");
//                    Sort the list
                    
                    requestList = sortRequest.requestListSorted(requestList, account.getUsername());
                    request.setAttribute("requests", requestList);
                     /*Attach Attribute teachers for request and redirect it to ListAllRequestTea.jsp*/
                    request.getRequestDispatcher("./view/ListAllRequestTea.jsp").forward(request, response);
              }
            }
            /*Redirect it to Login*/
            else response.sendRedirect("Login");
        } catch(Exception e){
        
        }
    }

}
