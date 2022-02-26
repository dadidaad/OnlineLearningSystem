/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.ConstantBean;
import Bean.SubjectBean;
import Dao.ConstantDAO;
import Dao.IConstantDAO;
import Dao.ISubjectDAO;
import Dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phong Vu
 */
@WebServlet(name = "ConstantTableController", urlPatterns = {"/ConstantTableController"})
public class ConstantTableController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConstantTableController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConstantTableController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<ConstantBean> constants = new ArrayList<>();
            IConstantDAO constantDAO = new ConstantDAO();
            constants = constantDAO.getAllConstant();
            
            ArrayList<SubjectBean> subjects = new ArrayList<>();
            ISubjectDAO subjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            subjects = subjectDAO.getAllSubject();
            
            request.setAttribute("subjects", subjects);
            request.setAttribute("constants", constants);
            request.getRequestDispatcher("./view/ConstantLookUp.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConstantTableController.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name").replaceAll("\\s\\s+", " ").trim();
            String sign = request.getParameter("sign").replaceAll("\\s\\s+", " ").trim();
            
            IConstantDAO constantDAO = new ConstantDAO();
            ArrayList<ConstantBean> constants = new ArrayList<>();
            
            if(name.equals("")){
                constants = constantDAO.getBySignOrConvention(sign);
            }else if(sign.equals("")){
                constants = constantDAO.getByConstantName(name);
            }else{
                constants = constantDAO.getByNameAndSign(name, sign);
            }
            
            ArrayList<SubjectBean> subjects = new ArrayList<>();
            ISubjectDAO subjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            subjects = subjectDAO.getAllSubject();
            
            request.setAttribute("constants", constants);
            request.setAttribute("subjects", subjects);
            request.getRequestDispatcher("./view/ConstantLookUp.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConstantTableController.class.getName()).log(Level.SEVERE, null, ex);
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
