/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * TeacherRequestSearchController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package Controller;

import bean.TeacherBean;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author win
 */
public class TeacherRequestSearchController extends HttpServlet {

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

            String searchString = request.getParameter("searchString").replaceAll("\\s\\s+", " ").trim();
            String status = request.getParameter("rqStatus");
            
            if (searchString.equals("")) {
                response.sendRedirect("TeacherRequest");
            }
            ITeacherDAO iTeacherDAO = new TeacherDAO();
            
            String page = request.getParameter("page");

            if (page == null || page.length() == 0) {
                page = "1";
            }
            int pageindex = Integer.parseInt(page);
            int pagesize = 10;
            int totalrow, totalpage;

            ArrayList<TeacherBean> teacherList = new ArrayList<>();
           
            if (status.equals("waiting")) {
                totalrow = iTeacherDAO.getTotalTeacherApplySearch(status,searchString);
                totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;
                teacherList = iTeacherDAO.getTeacherApplyBySearching(status,searchString, pageindex, pagesize);
                 
            } else {
                totalrow = iTeacherDAO.getTotalTeacherApplySearch(searchString);
                totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;
                teacherList = iTeacherDAO.getTeacherApplyBySearching(searchString, pageindex, pagesize);
            }
            
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("status", status);

            ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();

            /*Attach Attribute teachers for request and redirect it to ListAllTeacher.jsp*/
            request.setAttribute("subjectNames", SubjectNames);
            request.setAttribute("teachers", teacherList);

            request.setAttribute("searchString", searchString);
            request.setAttribute("searchMode", "on");
            request.setAttribute("totalsearch", totalrow);

            request.getRequestDispatcher("./view/TeacherRequest.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(TeacherRequestSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
