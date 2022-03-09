package controller;

import bean.AccountBean;
import bean.RequestBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import dao.IRequestDAO;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
import dao.RequestDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import utils.SortRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class ListRequestSearchController extends HttpServlet {

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
            HttpSession session = request.getSession();
            AccountBean account = (AccountBean) session.getAttribute("user");
            SortRequest sortRequest = new SortRequest();//call the sort modify class
            String searchString = request.getParameter("searchString").replaceAll("\\s\\s+", " ").trim();
            String rqStatus = request.getParameter("rqStatus");

            if (rqStatus == null) {
                rqStatus = "Waiting";
            }

            if (searchString.equals("")) {
                response.sendRedirect("ListAllRequest");
            }
            ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
            Map<Integer, String> SubjectNames = iSubjectDAO.getSubjectNames();

            IAccountDAO iAccountDAO = new AccountDAO(); //Use ISubjectDAO interface to call
            Map<String, String> DisplayNames = iAccountDAO.getDisplayNames();

            request.setAttribute("subjectNames", SubjectNames);
            request.setAttribute("displayNames", DisplayNames);
            request.setAttribute("status", rqStatus);
            request.setAttribute("searchMode", "on");
            request.setAttribute("searchString", searchString);

            List<RequestBean> requestList = new ArrayList<>();
            IRequestDAO iRequestDAO = new RequestDAO();;

            String page = request.getParameter("page");
            if (page == null || page.length() == 0) {
                page = "1";
            }

            int pageindex = Integer.parseInt(page);
            int pagesize = 10;
            int totalrow, totalpage;

            if (account.getRole().equalsIgnoreCase("student")) {

                totalrow = iRequestDAO.getTotalRequestSearchForStudent(account.getUsername(), rqStatus, searchString);
                totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;

                requestList = iRequestDAO.getRequestSearchForStudent(account.getUsername(), rqStatus, searchString, pageindex, pagesize);
                request.setAttribute("requests", requestList);

                request.setAttribute("totalpage", totalpage);
                request.setAttribute("pageindex", pageindex);
                request.setAttribute("totalsearch", totalrow);

                /*Attach Attribute teachers for request and redirect it to ListAllRequestStu.jsp  */
                request.getRequestDispatcher("./view/ListAllRequestStu.jsp").forward(request, response);

            } else if (account.getRole().equalsIgnoreCase("teacher")) {

                ITeacherDAO iteacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
                int subjectId = iteacherDAO.getSubjectId(account.getUsername());

                if (rqStatus.equalsIgnoreCase("Approved") || rqStatus.equalsIgnoreCase("Report")) {
                    totalrow = iRequestDAO.getTotalRequestSearchForTeacher(account.getUsername(), rqStatus, searchString);
                } else {
                    totalrow = iRequestDAO.getTotalRequestSearchForTeacher(subjectId, rqStatus, searchString);
                }

                totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;

                if (rqStatus.equalsIgnoreCase("Approved") || rqStatus.equalsIgnoreCase("Report")) {
                    requestList = iRequestDAO.getRequestSearchForTeacher(account.getUsername(), rqStatus, searchString, pageindex, pagesize);
                } else {
                    requestList = iRequestDAO.getRequestSearchForTeacher(subjectId, rqStatus, searchString, pageindex, pagesize);
                }

                request.setAttribute("totalpage", totalpage);
                request.setAttribute("pageindex", pageindex);
                request.setAttribute("totalsearch", totalrow);

                /* Sort the list */
                requestList = sortRequest.requestListSorted(requestList, account.getUsername());
                request.setAttribute("requests", requestList);
                /*Attach Attribute teachers for request and redirect it to ListAllRequestTea.jsp*/
                request.getRequestDispatcher("./view/ListAllRequestTea.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(ListRequestSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
