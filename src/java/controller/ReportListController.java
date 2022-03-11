/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Online Learning System

 * ListAllRequestController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-06   1.0         Danh Tinh   First Implement
 */
package controller;

import bean.AccountBean;
import bean.ReportBean;
import dao.ReportDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tinht
 */
public class ReportListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if((AccountBean)session.getAttribute("user") == null) {
            response.sendRedirect("LoginController");
        }
        
        String status = (request.getParameter("status") == null) ? "report" : "feedback";
        
        if(status.equalsIgnoreCase("report")){
            ArrayList<ReportBean> list;
            ReportDAO reportDB = new ReportDAO();
            list = reportDB.GetAllReport();
            request.setAttribute("reportList", list);
        }
        else{
            
        }
        
        request.getRequestDispatcher("./view/ReportList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
