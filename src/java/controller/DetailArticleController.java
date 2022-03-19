/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * DetailArticleController
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-11   1.0         Hoang Ngoc Long    First Implement
 */
package controller;

import bean.AccountBean;
import bean.ArticleBean;
import bean.CommentArticleBean;
import bean.NotificationBean;
import dao.ArticleDAO;
import dao.IArticleDAO;
import dao.INotificationDAO;
import dao.NotificationDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Document: DetailArticleController Create on: Feb 9, 2022, 10:20:35 PM
 *
 * @author Hoang Ngoc Long
 */
@WebServlet(name = "DetailArticleController", urlPatterns = {"/detailarticle"})
public class DetailArticleController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Get id of article from listarticle
        String aid = request.getParameter("did");
        int id = Integer.parseInt(aid);
        IArticleDAO articleDAO = new ArticleDAO();
        //get article by id
        ArticleBean a = articleDAO.getArticleDetail(id);
         /*Use session*/          
         HttpSession session = request.getSession();
         AccountBean b = (AccountBean) session.getAttribute("user");
          List<CommentArticleBean> list = articleDAO.getAllComment(id);
        request.setAttribute("comments", list);
        request.setAttribute("article", a);   
        if(b!=null){
        request.setAttribute("name", b.getUsername());
            }
         request.getRequestDispatcher("./view/ArticleDetail.jsp").forward(request, response);
        if(b.getUsername()!=null){
         articleDAO.getview(id);
        }
                //Attach Attribute for request and redirect it to ListArticle.jsp

    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
