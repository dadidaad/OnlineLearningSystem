package Controller;

import Bean.RequestBean;
import Bean.RequestReplyBean;
import Dao.IRequestDAO;
import Dao.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author win
 */
public class CreateRequestReplyController extends HttpServlet {

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
            out.println("<title>Servlet CreateRequestReply</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateRequestReply at " + request.getContextPath() + "</h1>");
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
        try (PrintWriter out = response.getWriter()) {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String teacherSent = request.getParameter("teacherSent");
        String studentSent = request.getParameter("studentSent");
        String contentReply = request.getParameter("contentReply");
        String imgReply = "/assets/image/" + request.getParameter("imgReply");
        
//        out.print(requestId + " "+ teacherSent +" "+ studentSent +" "+ contentReply+ " "+ imgReply);
        
        RequestReplyBean rpReply = new RequestReplyBean();
        rpReply.setRequestID(requestId);
        rpReply.setTutorSent(teacherSent);
        rpReply.setStudentGet(studentSent);
        rpReply.setContentReply(contentReply);
        rpReply.setImageLinkReply(imgReply);
        
        
        
        IRequestDAO iRequestDAO = new RequestDAO();
        iRequestDAO.updateRequestStatus("Approved", requestId);
        iRequestDAO.createRequestReply(rpReply);
        
        response.sendRedirect("listAllRequestTea");
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