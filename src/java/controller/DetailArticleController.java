/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * DetailArticleController
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-11   1.0         Hoang Ngoc Long    First Implement
 */
package controller;

import bean.ArticleBean;
import dao.ArticleDAO;
import dao.IArticleDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Document: DetailArticleController Create on: Feb 9, 2022, 10:20:35 PM
 *
 * @author Hoang Ngoc Long
 */
@WebServlet(name = "DetailArticleController", urlPatterns = {"/detail"})
public class DetailArticleController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get id of article from listarticle
        String aid = request.getParameter("did");
        int id = Integer.parseInt(aid);
        IArticleDAO articleDAO = new ArticleDAO();
        //get article by id
        ArticleBean a = articleDAO.getArticleDetail(id);
        //Attach Attribute for request and redirect it to ListArticle.jsp
        request.setAttribute("article", a);
        request.getRequestDispatcher("./view/ArticleDetail.jsp").forward(request, response);

    }

}
