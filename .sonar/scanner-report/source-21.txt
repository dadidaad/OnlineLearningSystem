package Controller;

import Bean.RequestBean;
import Bean.SubjectBean;
import Bean.TeacherBean;
import Dao.IRequestDAO;
import Dao.ISubjectDAO;
import Dao.ITeacherDAO;
import Dao.RequestDAO;
import Dao.SubjectDAO;
import Dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author win
 */
public class CreateRequestController extends HttpServlet {

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
            out.println("<title>Servlet CreateRequestController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateRequestController at " + request.getContextPath() + "</h1>");
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
        try (PrintWriter out = response.getWriter()) {
                ArrayList <SubjectBean> s = new ArrayList<>();
                ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                s = iSubjectDAO.getAllSubject();
                Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();
                
                String teacherRcmFromList = request.getParameter("teacherRcmFromList");
                if(teacherRcmFromList!=null){
                    request.setAttribute("rqTeacherRcmFromList", teacherRcmFromList);
                }
                
                 
                ArrayList <TeacherBean> teacherList = new ArrayList<>();
                ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
                teacherList = iTeacherDAO.getAllTeacher();
                //Attach Attribute subjects for request and redirect it to CreateRequest.jsp
                request.setAttribute("subjects", s);
                request.setAttribute("teachers", teacherList);
                request.setAttribute("subjectNames", SubjectNames);
//                out.print("create");
                request.getRequestDispatcher("./view/CreateRequest.jsp").forward(request, response);
            } catch (SQLException ex) {
            Logger.getLogger(CreateRequestController.class.getName()).log(Level.SEVERE, null, ex);
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
        try (PrintWriter out = response.getWriter()) {
            
        String requestTitle = request.getParameter("rqTitle");
        String requestSubject = request.getParameter("rqSubject");
        String requestLevel = request.getParameter("rqLevel");
        String requestPrice = request.getParameter("rqPrice");
        String requestStudentSent = request.getParameter("studentSent");
        
        String requestTeacherRcm = "";
        String rqTeacherRcmFromList = request.getParameter("rqTeacherRcmFromList");
        if(rqTeacherRcmFromList == null && request.getParameter("rqTeacherRcm").length() > 0) 
            requestTeacherRcm = request.getParameter("rqTeacherRcm");
        else requestTeacherRcm =null;
        
        
        String requestContent = request.getParameter("content");
        String requestImg = "/assets/image/" + request.getParameter("imgContent");
        
//        out.print( requestTitle + " "+ requestSubject  + " "+ requestTeacherRcm   + " "+  requestContent + " "+ requestImg);
        
        RequestBean rq = new RequestBean();
        rq.setStudentSent(requestStudentSent);
        rq.setTutorGet(requestTeacherRcm);
        rq.setCost(Integer.parseInt(requestPrice));
        rq.setContent(requestContent);
        rq.setImageLink(requestImg);
        rq.setSubjectID(Integer.parseInt(requestSubject));
        rq.setLevel(Integer.parseInt(requestLevel));
        rq.setTitle(requestTitle);
        
        IRequestDAO iRequestDAO = new RequestDAO();
        iRequestDAO.createRequest(rq);
       
        response.sendRedirect("ListAllRequestStu");
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
