package controller;

import bean.AccountBean;
import bean.NotificationBean;
import dao.INotificationDAO;
import dao.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author win
 */
public class ShowmoreNotificationController extends HttpServlet {

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
            out.println("<title>Servlet ShowmoreNotificationController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowmoreNotificationController at " + request.getContextPath() + "</h1>");
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
            AccountBean account = (AccountBean) session.getAttribute("user");
            String index = request.getParameter("index");
            INotificationDAO iNotificationDAO = new NotificationDAO();
            List<NotificationBean> notiList = iNotificationDAO.getNotification(Integer.parseInt(index), 10, account.getUsername());
            for (NotificationBean n : notiList) {
                String notiTitle = n.getTitle();
                String notiIcon="";
                if(notiTitle.toLowerCase().equals("request")){
                    notiIcon= "<span class=\"icon\"><i class=\"fas fa-file-import\"></i></span>";
                }
                else if(notiTitle.toLowerCase().equals("subject")){
                    notiIcon= "<span class=\"icon\"><i class=\"fab fa-leanpub\"></i></span>";
                }
                else if(notiTitle.toLowerCase().equals("forum")){
                    notiIcon= "<span class=\"icon\"><i class=\"fab fa-forumbee\"></i></span>";
                }
                else if(notiTitle.toLowerCase().equals("admin")){
                    notiIcon= "<span class=\"icon\"><i class=\"fas fa-user\"></i></span>";
                }

                out.print("<div class=\"alert alert-warning alert-dismissible fade show noti-item\" role=\"alert\">\n"
                        + notiIcon                                            
                        + "                                            <strong>"+n.getTitle()+"</strong>"+n.getContent()+"\n"
                        + "                                            <button type=\"button\" value=\""+n.getNotificationID()+"\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n"
                        + "                                        </div>");
            }
        } catch (Exception ex) {
            Logger.getLogger(DeleteNotificationController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("Home");
        }
    }

}
