
package controller;

import bean.SubjectBean;
import dao.ISubjectDAO;
import dao.SubjectDAO;
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
@WebServlet(name = "SubjectUpdateController", urlPatterns = {"/SubjectUpdateController"})
public class SubjectUpdateController extends HttpServlet {

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
            try (PrintWriter out = response.getWriter()) {
                String subId = request.getParameter("subId");
                
                ISubjectDAO subjectDAO = new SubjectDAO();
                SubjectBean subject = new SubjectBean();
                subject = subjectDAO.getSubjectById(Integer.parseInt(subId));
                
                request.setAttribute("subject",subject);
                request.getRequestDispatcher("./view/UpdateSubject.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SubjectUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
            /*get data from parameter of request*/
            String subName = request.getParameter("subName").replaceAll("\\s\\s+", " ").trim();
            String currentSubName = request.getParameter("currentSubject").replaceAll("\\s\\s+", " ").trim();
            String subId = request.getParameter("subId");
            String description = request.getParameter("description").replaceAll("\\s\\s+", " ").trim();
            String currentImage = request.getParameter("currentImage");
            Part part = request.getPart("Image"); 
            String subImage = part.getSubmittedFileName();
            String actuallySubImage = "assets/image/" + subImage;
            if(subImage.equals("")){
                actuallySubImage = currentImage;
            }
            
            /*Query for check whether Subject Name has existed*/
            ISubjectDAO subjectDAO = new SubjectDAO();
            boolean check = subjectDAO.searchBySubName(subName);
            
            /*If existed, reiderect*/
            if (check == false && !currentSubName.equals(subName)) {
                SubjectBean currentSubject = new SubjectBean();
                currentSubject = subjectDAO.getSubjectById(Integer.parseInt(subId));
                
                request.setAttribute("subject",currentSubject);
                request.setAttribute("check", check);
                request.getRequestDispatcher("./view/UpdateSubject.jsp").forward(request, response);
            }else{
                SubjectBean subject = new SubjectBean(Integer.parseInt(subId), subName, description, actuallySubImage);
                int numberOfRows = subjectDAO.updateSubject(subject);
                response.sendRedirect("AdminSubjectController");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
