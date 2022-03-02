/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ListArticleController
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-11   1.0         Hoang Ngoc Long    First Implement
 */
package Controller;

import Dao.ArticleDAO;
import Dao.IArticleDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "CreateArticleControl", urlPatterns = {"/createarticle"})
public class CreateArticleControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //read and write vietnamese
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
          /*Get image,description,id title from request*/
        String image = request.getParameter("image").trim();
        String title = request.getParameter("title").trim();
        String des = request.getParameter("description");
         String createname = request.getParameter("createname").trim();
          /*Use DAO class to get data from database for Article with corresponding */
         IArticleDAO articleDAO =new ArticleDAO();
         //add new article
         articleDAO.addNew(title, des, image, createname);
           /*Attach Attribute  redirect it to CreateArticle.jsp*/
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
