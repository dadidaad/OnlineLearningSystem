package Controller;

import Bean.ChapterBean;
import Bean.KnowledgeBean;
import Bean.SubjectBean;
import Dao.ChapterDAO;
import Dao.IChapterDAO;
import Dao.IKnowledgeDAO;
import Dao.ISubjectDAO;
import Dao.KnowledgeDAO;
import Dao.SubjectDAO;
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
public class KnowledgeController extends HttpServlet {

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
            out.println("<title>Servlet KnowledgeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KnowledgeController at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            //Get ChapterID from request
            String chapterID = request.getParameter("chapId");
            
            //Use DAO class to get data from database for Knowledge with corresponding ChapterID
            ArrayList<KnowledgeBean> knowledges = new ArrayList<>();
            IKnowledgeDAO knowledgeDao = new KnowledgeDAO(); //Use IKnowledgeDAO interface to call
            knowledges = knowledgeDao.getByChapterId(Integer.parseInt(chapterID));
            
            //Use DAO class to get data from database for all Subject
            ArrayList <SubjectBean> subjects = new ArrayList<>();
            ISubjectDAO subjectDao = new SubjectDAO(); //Use ISubjectDAO interface to call
            subjects = subjectDao.getAllSubject();
            
            //Use DAO class to get data for Current Chapter with correspoding ChapterID from request
            ChapterBean currentChapter = new ChapterBean();
            IChapterDAO chapterDao = new ChapterDAO();
            currentChapter = chapterDao.getChapterById(Integer.parseInt(chapterID));
             out.print(1);
            //Attach Attribute for request and redirect it to SubjectDetail.jsp
            request.setAttribute("subjects", subjects);
            request.setAttribute("knowledges", knowledges);
            request.setAttribute("currentChapter", currentChapter);
            request.getRequestDispatcher("./view/KnowledgeDetail.jsp").forward(request, response);
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
