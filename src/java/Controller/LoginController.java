package Controller;

import Bean.AccountBean;
import Dao.AccountDAO;
import Utils.EncryptAndDecryptPassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author win
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("./view/Login.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        Map<String, String> messages = new HashMap<>();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1800);
        AccountDAO db = new AccountDAO();
        AccountBean userGetFromDb = db.getAccountByUsername(username);
        if (userGetFromDb == null) {
            messages.put("loginInvalid", "User isn't exist");
        } else {
            EncryptAndDecryptPassword passwordUtils = new EncryptAndDecryptPassword();
            boolean checkPass = false;
            boolean checkRole = role.equalsIgnoreCase(userGetFromDb.getRole());
            try {
                checkPass = passwordUtils.validatePassword(password, userGetFromDb.getPassword());
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!checkPass) {
                messages.put("loginError", "Invalid password");
            }
            else if(!checkRole){
                messages.put("loginError", "Invalid role");
            }
            else{
                String remember = request.getParameter("remember");
                if (remember != null) {
                    Cookie c_user = new Cookie("username", username);
                    Cookie c_pass = new Cookie("password", password);
                    c_user.setMaxAge(3600 * 24 * 30);
                    c_pass.setMaxAge(3600 * 24 * 30);
                    response.addCookie(c_pass);
                    response.addCookie(c_user);
                }
                session.setAttribute("user", userGetFromDb);
                session.setAttribute("remember", remember);
                response.sendRedirect("./view/Home.jsp");
                return;
            }
        }
        response.getWriter().print(messages.values());
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
