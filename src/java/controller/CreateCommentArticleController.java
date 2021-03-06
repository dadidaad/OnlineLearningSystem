/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * CreateCommentArticleController
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-11   1.0         Hoang Ngoc Long    First Implement
 */
package controller;

import bean.AccountBean;
import dao.ArticleDAO;
import dao.IArticleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Document: CreateCommentArticleController Create on: Feb 9, 2022, 10:20:35 PM
 *
 * @author Hoang Ngoc Long
 */
@WebServlet(name = "CreateCommentArticleController", urlPatterns = {"/createcommentarticle"})
public class CreateCommentArticleController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*Use DAO class to get data from database for Article with corresponding */
        IArticleDAO articleDAO = new ArticleDAO();
        /*Get index aid from request*/
        String content = request.getParameter("title").replaceAll("\\s\\s+", " ").trim();
        String articleid = request.getParameter("articleId").replaceAll("\\s\\s+", " ").trim();
       /*Use session*/
        HttpSession session = request.getSession();
        AccountBean a = (AccountBean) session.getAttribute("user"); 
          // insert comment article
          if(a!=null){
          articleDAO.AddNewComment(a.getUsername(), articleid, content);
         response.sendRedirect("detailarticle?did="+articleid);
          }
          else{
               response.sendRedirect("Login");
          }
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
