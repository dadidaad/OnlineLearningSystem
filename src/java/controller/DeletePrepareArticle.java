/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * DeletePrepareArticle
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-22   1.0         Hoang Ngoc Long    First Implement
 */
package controller;

import dao.ArticleDAO;
import dao.IArticleDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Document: DeletePrepareArticle Create on: 2022-02-22 10:20:35 PM
 *
 * @author Hoang Ngoc Long
 */
@WebServlet(name = "DeletePrepareArticle", urlPatterns = {"/deleteprepare"})
public class DeletePrepareArticle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
         /*Get index ID from request*/
        String id = request.getParameter("pid");
        /*Use DAO class to get data from database for Article with corresponding */
        IArticleDAO articleDAO = new ArticleDAO();
         //deleteprepare article with id
        articleDAO.deleteprepare(id);
        response.sendRedirect("loadpreparearticle");
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
