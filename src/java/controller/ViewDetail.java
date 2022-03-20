/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * ViewDetail
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-22   1.0         Hoang Ngoc Long    First Implement
 */
package controller;

import bean.ArticleBean;
import dao.ArticleDAO;
import dao.IArticleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Document: ViewDetail Create on: 2022-02-22 10:20:35 PM
 *
 * @author Hoang Ngoc Long
 */
@WebServlet(name = "ViewDetail", urlPatterns = {"/viewdetailarticle"})
public class ViewDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("idService");
        IArticleDAO articleDAO = new ArticleDAO();
        ArticleBean ad = articleDAO.getArticlebyid(id);
        try {
            String modal = "<div class=\"modal fade\" id=\"exampleModalLong\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLongTitle\" aria-hidden=\"true\">\n"
                    + "<div class=\"modal-dialog\" role=\"document\">\n"
                    + "    <div class=\"modal-content\">\n"
                    + "      <div class=\"modal-header\">\n"
                    + "        <h5 class=\"modal-title\" id=\"exampleModalLongTitle\">"+ad.getTitle()+"+</h5>\n"
                    + "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                    + "          <span aria-hidden=\"true\">&times;</span>\n"
                    + "        </button>\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-body\">\n"
                    + "        "+ad.getDescription()+"+\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-footer\">\n"
                    + "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "  </div>"
                    + "  </div>";
            out.print(modal);
        } catch (Exception e) {
            out.print("error");
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
