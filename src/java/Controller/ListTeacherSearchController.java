package Controller;

import Bean.TeacherBean;
import Dao.ITeacherDAO;
import Dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author win
 */
public class ListTeacherSearchController extends HttpServlet {

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
        
            String searchString = request.getParameter("searchString");
            ITeacherDAO iTeacherDAO = new TeacherDAO();
            ArrayList<TeacherBean> list = iTeacherDAO.getTeacherBySearching(searchString);
            
            out.print(list);
        
        }catch(Exception e){
            
        }
    
    }


}
