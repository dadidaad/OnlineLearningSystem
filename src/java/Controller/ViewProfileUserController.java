/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * ViewProfileUserController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-25   1.0         DajtVox    First Implement
 */
package Controller;

import Bean.AccountBean;
import Bean.SubjectBean;
import Dao.ISubjectDAO;
import Dao.ITeacherDAO;
import Dao.SubjectDAO;
import Dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for view detail information of login user in
 * web page Extend HttpServlet class
 *
 * @author DajtVox
 */
public class ViewProfileUserController extends HttpServlet {

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
            HttpSession session = request.getSession(false); //call session in request
            AccountBean loginUser = (AccountBean) session.getAttribute("user"); //get account bean object in session
            /* check if user is existed in session, if not then redirect to login */
            if (loginUser == null) {
                response.sendRedirect("Login");
                return;
            }
            ISubjectDAO subjectDAO = new SubjectDAO();
            List<SubjectBean> listSubject = subjectDAO.getAllSubject();
            ITeacherDAO teacherDAO = new TeacherDAO();
            boolean checkTeacherStatus = teacherDAO.checkTeacherStatus(loginUser.getUsername());
            request.setAttribute("teacherStatus", checkTeacherStatus);
            request.setAttribute("listSubject", listSubject);
            request.setAttribute("userProfile", loginUser);
            request.getRequestDispatcher("./view/UserSettings.jsp").forward(request, response);
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(ViewProfileUserController.class.getName()).log(Level.SEVERE, null, e);

        }
    }
}
