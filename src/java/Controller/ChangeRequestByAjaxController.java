package Controller;

import Bean.RequestBean;
import Dao.AccountDAO;
import Dao.IAccountDAO;
import Dao.IRequestDAO;
import Dao.ISubjectDAO;
import Dao.RequestDAO;
import Dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author win
 */
public class ChangeRequestByAjaxController extends HttpServlet {

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
            out.println("<title>Servlet ChangeRequestByAjaxController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeRequestByAjaxController at " + request.getContextPath() + "</h1>");
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
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
//            HttpSession session = request.getSession();   
//            AccountBean account =(AccountBean) session.getAttribute("account");
//            if(account!=null){}
                String status = request.getParameter("rqStatus");

                ArrayList <RequestBean> requestList = new ArrayList<>();
                IRequestDAO iRequestDAO = new RequestDAO(); //Use ITeacherDAO interface to call
                requestList = iRequestDAO.getRequestByStatus("minhduc07", status);
                ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
                Map<Integer, String> subjectNames = iSubjectDAO.getSubjectNames();
                IAccountDAO iAccountDAO = new AccountDAO(); //Use ISubjectDAO interface to call
                Map<String, String> displayNames = iAccountDAO.getDisplayNames();
                
                int index = 1;
                
//             if   Student Role
//                for(RequestBean r: requestList){
//                out.println(" <tr>\n" +
//"                        <td>"+index+"</td>\n" +
//"                        <td>"+format.format(r.getCreatedTime())+"</td>\n" +
//"                        <td>"+r.getTitle()+"</td>\n" +
//"                        <td>Class "+r.getLevel()+"</td>\n" +
//"                        <td>"+subjectNames.get(r.getSubjectID())+"</td>\n" +
//"                        <td>"+r.getCost()+" <Span>VND</Span></td>\n" +
//"                        <td>"+r.getStatus()+"</td>\n" +
//"                        <td>\n" +
//"                          <a href=\"ViewRequestStu?requestId=${r.getRequestID()}\"><i class=\"far fa-eye\"></i></a>\n" +
//"                        </td>\n" +
//"                        \n" +
//"                      </tr> ");
//                    index++;
//                }
//              If  Teacher Role

            String starHtml = "<i class=\"far fa-star\"></i>";
            
                for(RequestBean r: requestList){
                out.println(" <tr>\n" +
"                        <td>"+index+"</td>\n" +
"                        <td>"+format.format(r.getCreatedTime())+"</td>\n" +
"                        <td>"+displayNames.get(r.getStudentSent())+"</td>\n" +
"                        <td>"+r.getTitle()+"</td>\n" +
"                        <td>Class "+r.getLevel()+"</td>\n" +
"                        <td>"+r.getCost()+" <Span>VND</Span></td>\n"+
"                        <td>\n" +
"                          <a href=\"ViewRequestStu?requestId="+r.getRequestID()+"><i class=\"far fa-eye\"></i></a>\n" +
"                        </td>\n" +
"                        \n" +
"                        <td>\n" +
                            starHtml     +
"                        </td>\n" +
"                        \n" +        
"                      </tr> ");
                    index++;
                }
                               
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
