/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.KnowledgeBean;
import dao.IKnowledgeDAO;
import dao.KnowledgeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Phong Vu
 */
@MultipartConfig
@WebServlet(name = "KnowledgeUpdateController", urlPatterns = {"/KnowledgeUpdateController"})
public class KnowledgeUpdateController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String knowledgeId = request.getParameter("knowledgeId");

            IKnowledgeDAO knowledgeDAO = new KnowledgeDAO();
            KnowledgeBean knowledge = new KnowledgeBean();
            knowledge = knowledgeDAO.getKnowledgeById(Integer.parseInt(knowledgeId));

            request.setAttribute("knowledge", knowledge);
            request.getRequestDispatcher("./view/UpdateKnowledge.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*get data from parameter of request*/
            String knowledgeName = request.getParameter("knowledgeName").replaceAll("\\s\\s+", " ").trim();
            String currentKnowledgeName = request.getParameter("currentName").replaceAll("\\s\\s+", " ").trim();
            String knowledgeId = request.getParameter("knowledgeId");
            
            String currentKnowledge = request.getParameter("currentKnowledge");
            String chapId = request.getParameter("chapId");
            
            Part part = request.getPart("Image"); 
            String subImage = part.getSubmittedFileName();
            String actuallyKnowContent = "assets/image/Algebra/" + subImage;
            if(subImage.equals("")){
                actuallyKnowContent = currentKnowledge;
            }
            
            /*Query for check whether Subject Name has existed*/
            IKnowledgeDAO knowledgeDAO = new KnowledgeDAO();
            boolean check = knowledgeDAO.searchByKnowledgeNameOfChap(knowledgeName, Integer.parseInt(chapId));
            
            /*If existed, reiderect*/
            if (check == false && !currentKnowledgeName.equals(knowledgeName)) {
                KnowledgeBean curKnowledge = new KnowledgeBean();
                curKnowledge = knowledgeDAO.getKnowledgeById(Integer.parseInt(knowledgeId));
                
                request.setAttribute("knowledge",curKnowledge);
                request.setAttribute("check", check);
                request.getRequestDispatcher("./view/UpdateKnowledge.jsp").forward(request, response);
            }else{
                KnowledgeBean knowledge = new KnowledgeBean(Integer.parseInt(knowledgeId), knowledgeName, actuallyKnowContent, Integer.parseInt(chapId));
                int numberOfRows = knowledgeDAO.updateKnowledge(knowledge);
                response.sendRedirect("AdminKnowledgeController?chapId="+chapId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
