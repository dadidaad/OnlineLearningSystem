/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * CreateRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.RequestBean;
import bean.SubjectBean;
import bean.TeacherBean;
import dao.IRequestDAO;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
import dao.RequestDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the student wants to create Request
 * /CreateRequest is the URL of the Servlet
 * Extend HttpServlet class
 * @author Duc Minh
 */
public class CreateRequestController extends HttpServlet {

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
                List <SubjectBean> s = new ArrayList<>();
                ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                s = iSubjectDAO.getAllSubject();
                Map<Integer, String> subjectNames = iSubjectDAO.getSubjectNames();
                
                String teacherRcmFromList = request.getParameter("teacherRcmFromList");
                if(teacherRcmFromList!=null){
                    request.setAttribute("rqTeacherRcmFromList", teacherRcmFromList);
                }
                
                 
                List <TeacherBean> teacherList = new ArrayList<>();
                ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
                teacherList = iTeacherDAO.getTopTeacher();
                //Attach Attribute subjects for request and redirect it to CreateRequest.jsp
                request.setAttribute("subjects", s);
                request.setAttribute("teachers", teacherList);
                request.setAttribute("subjectNames", subjectNames);

                request.getRequestDispatcher("./view/CreateRequest.jsp").forward(request, response);
        }catch(Exception e){
        
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
            
        String requestTitle = request.getParameter("rqTitle").replaceAll("\\s\\s+", " ").trim();
        String requestSubject = request.getParameter("rqSubject");
        String requestLevel = request.getParameter("rqLevel");
        String requestPrice = request.getParameter("rqPrice");
        String requestStudentSent = request.getParameter("studentSent");
        
        String requestTeacherRcm = "";
        String rqTeacherRcmFromList = request.getParameter("rqTeacherRcmFromList");
        if(rqTeacherRcmFromList == null && request.getParameter("rqTeacherRcm").length() > 0) 
            requestTeacherRcm = request.getParameter("rqTeacherRcm");
        else requestTeacherRcm =null;
        
        
        String requestContent = request.getParameter("content").replaceAll("\\s\\s+", " ").trim();
        String requestImg = "/assets/image/" + request.getParameter("imgContent");
        
        
        RequestBean rq = new RequestBean();
        rq.setStudentSent(requestStudentSent);
        rq.setTutorGet(requestTeacherRcm);
        rq.setCost(Integer.parseInt(requestPrice));
        rq.setContent(requestContent);
        rq.setImageLink(requestImg);
        rq.setSubjectID(Integer.parseInt(requestSubject));
        rq.setLevel(Integer.parseInt(requestLevel));
        rq.setTitle(requestTitle);
        
        IRequestDAO iRequestDAO = new RequestDAO();
        iRequestDAO.createRequest(rq);
       
        response.sendRedirect("ListAllRequest");
        }catch (Exception ex) {
            Logger.getLogger(CreateRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
