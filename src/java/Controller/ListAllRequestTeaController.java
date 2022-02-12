package Controller;

import Bean.AccountBean;
import Bean.RequestBean;
import Dao.AccountDAO;
import Dao.IAccountDAO;
import Dao.IRequestDAO;
import Dao.ISubjectDAO;
import Dao.RequestDAO;
import Dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author win
 */
public class ListAllRequestTeaController extends HttpServlet {

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
            out.println("<title>Servlet ListAllRequestTeaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListAllRequestTeaController at " + request.getContextPath() + "</h1>");
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
                
            HttpSession session = request.getSession();   
            AccountBean account =(AccountBean) session.getAttribute("account");
            if(account!=null){}
                
                ArrayList <RequestBean> requestList = new ArrayList<>();
                IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
                requestList = iRequestDAO.getAllRequest();
                
                ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();
                
                IAccountDAO iAccountDAO = new AccountDAO(); //Use ISubjectDAO interface to call
                Map<String, String> DisplayNames = iAccountDAO.getDisplayNames();
                
//                //Attach Attribute teachers for request and redirect it to ListAllRequestStu.jsp
                request.setAttribute("requests", requestList);
                request.setAttribute("subjectNames", SubjectNames);
                request.setAttribute("displayNames", DisplayNames);

                
                
            
                request.getRequestDispatcher("./view/ListAllRequestTea.jsp").forward(request, response);
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
