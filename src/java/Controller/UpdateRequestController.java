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
public class UpdateRequestController extends HttpServlet {

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
            out.println("<title>Servlet UpdateRequestController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRequestController at " + request.getContextPath() + "</h1>");
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
        
            int rqId = Integer.parseInt(request.getParameter("requestId"));
            
            IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
            RequestBean rq  = iRequestDAO.getRequestById(rqId);
                
            ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();
            ArrayList <SubjectBean> subjects = new ArrayList<>();
            subjects = iSubjectDAO.getAllSubject();
            
                
            ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
            ArrayList <TeacherBean> teacherList =  iTeacherDAO.getAllTeacher();
                
                //Attach Attribute subjects for request and redirect it to CreateRequest.jsp
                request.setAttribute("teachers", teacherList);
                
            //Attach Attribute teachers for request and redirect it to UpdateRequestStu.jsp
            request.setAttribute("request", rq);
            request.setAttribute("subjectNames", SubjectNames);
            request.setAttribute("subjects", subjects);

//            out.print("minh");
            request.getRequestDispatcher("./view/UpdateRequest.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateRequestController.class.getName()).log(Level.SEVERE, null, ex);
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
         
        int requestId = Integer.parseInt(request.getParameter("rqId"));    
        String requestTitle = request.getParameter("rqTitle");
        String requestSubject = request.getParameter("rqSubject");
        String requestLevel = request.getParameter("rqLevel");
        String requestPrice = request.getParameter("rqPrice");
        String requestStudentSent = request.getParameter("studentSent");
        
        String requestTeacherRcm =  request.getParameter("rqTeacherRcm");
        
        
        String requestContent = request.getParameter("content");
        String requestImg = "/assets/image/" + request.getParameter("imgContent");
        
//        out.print( requestId + " "+ requestStudentSent  + "Teacher: "+ requestTeacherRcm + " "+ requestPrice + " "+ requestContent + "\n "+
//                requestImg   + " "+  requestSubject + " "+ requestLevel + " " + requestTitle);
        
        RequestBean rq = new RequestBean();
        
        rq.setRequestID(requestId);
        rq.setStudentSent(requestStudentSent);
        rq.setTutorGet(requestTeacherRcm);
        rq.setCost(Integer.parseInt(requestPrice));
        rq.setContent(requestContent);
        rq.setImageLink(requestImg);
        rq.setSubjectID(Integer.parseInt(requestSubject));
        rq.setLevel(Integer.parseInt(requestLevel));
        rq.setTitle(requestTitle);
        
        IRequestDAO iRequestDAO = new RequestDAO();
        iRequestDAO.updateRequest(rq);
       
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
