package Controller;

import Dao.AccountDAO;
import Dao.IAccountDAO;
import Dao.IRequestDAO;
import Dao.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DashboardController extends HttpServlet {

    

    
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
        IAccountDAO iAccountDAO = new AccountDAO(); 
        IRequestDAO iRequestDAO = new RequestDAO();
        
        int totalAccount = iAccountDAO.totalAccount();
        int totalRequest = iRequestDAO.getTotalPendingRequest();
        
        request.setAttribute("totalAccount", totalAccount);
        request.setAttribute("totalRequest", totalRequest);
            
        request.getRequestDispatcher("./view/AdminDashboard.jsp").forward(request, response);
        }catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
