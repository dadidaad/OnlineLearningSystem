/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.ArticleBean;
import Dao.ArticleDAO;
import Dao.IArticleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "SearchInArticle", urlPatterns = {"/searcharticle"})
public class SearchInArticle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchInArticle</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchInArticle at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
         IArticleDAO articleDAO = new ArticleDAO();
         /*get txttitle from page*/
        String txt=request.getParameter("name").replaceAll("\\s\\s+", " ").trim();
        
         String indexpage = request.getParameter("index");
        /*Caculate total page*/
        if (indexpage == null) {
            indexpage = "1";
        }
        /*Caculate total page*/
        int idex = Integer.parseInt(indexpage);
        int count = articleDAO.totalSearchArticle(txt);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        //get top 4 newest article and total article
        List<ArticleBean> list = articleDAO.pagingSearchArticle(idex,txt);

        List<ArticleBean> list2 = articleDAO.getTop4Article();
         request.setAttribute("listT", list2);
         request.setAttribute("txtS", txt);
        if(list.size()==0){
             request.setAttribute("message","There is no title of Article");
        }
        else{
      
        //Attach Attribute for request and redirect it to ListArticle.jsp
        request.setAttribute("listP", list);
        request.setAttribute("tag", idex);
        request.setAttribute("endP", endPage);
        }
        request.getRequestDispatcher("./view/ListArticle.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
