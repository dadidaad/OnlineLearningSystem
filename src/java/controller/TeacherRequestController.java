/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * TeacherRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.TeacherBean;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
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
 * This is a Servlet responsible for handling the task when the Admin wants to
 * see all the Request to apply from teacher /TeacherRequest is the URL of the
 * Servlet Extend HttpServlet class
 *
 * @author Duc Minh
 */
public class TeacherRequestController extends HttpServlet {

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

            ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call    
//      Pagination   
            String page = request.getParameter("page");
            if (page == null || page.length() == 0) {
                page = "1";
            }
            int pageindex = Integer.parseInt(page);
            int pagesize = 7;
            int totalrow = iTeacherDAO.getTotalTeacherApply();
            int totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;

            List<TeacherBean> teacherList = iTeacherDAO.getAllTeacherApply(pageindex, pagesize);

            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pageindex", pageindex);

            ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            Map<Integer, String> subjectNames = iSubjectDAO.getSubjectNames();

            /*Attach Attribute teachers for request and redirect it to ListAllTeacher.jsp*/
            request.setAttribute("subjectNames", subjectNames);
            request.setAttribute("teachers", teacherList);
            request.getRequestDispatcher("./view/TeacherRequest.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(TeacherRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
