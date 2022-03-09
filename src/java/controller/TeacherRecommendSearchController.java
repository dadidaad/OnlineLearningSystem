/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * TeacherRecommendSearchController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package controller;

import bean.TeacherBean;
import dao.ISubjectDAO;
import dao.ITeacherDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the student wants to search teacher to create request
 * /AccountManager is the URL of the Servlet
 * Extend HttpServlet class
 * @author Duc Minh
 */
public class TeacherRecommendSearchController extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
                try (PrintWriter out = response.getWriter()) {
            
            String searchString = request.getParameter("searchString");
            String subjectId = request.getParameter("subjectId");
            
            ITeacherDAO iTeacherDAO = new TeacherDAO();
            ISubjectDAO iSubjectDAO = new SubjectDAO();
            Map<Integer, String> listSubject = iSubjectDAO.getSubjectNames();
            ArrayList<TeacherBean> list = new ArrayList<>();
            if(subjectId!=null && !subjectId.equals("")) list = iTeacherDAO.getTeacherBySearching(searchString, Integer.parseInt(subjectId));
            else list = iTeacherDAO.getTeacherBySearching(searchString);
            if (list.size() == 0) {
                out.print("<tr>List Empty</tr>");
            } else {
                for (TeacherBean x : list) {
                    out.print("<tr>\n" 
+"                                            <td>"+(list.indexOf(x)+1)+"</td>\n" 
+"                                            <td>\n" 
+"                                                <a class=\"teacherInfo\" href=\"#\"\n" 
+"                                                   ><img\n" 
+"                                                        class=\"teacherAvt\"\n" 
+"                                                        src=\"" + (request.getContextPath()+ x.getAvatar())+"\"\n" 
+"                                                        alt=\"\"\n" 
+"                                                        />"+x.getDisplayName()+"</a\n" 
+"                                                >\n" 
+"                                            </td>\n" 
+"                                            <td>"
+"                                            <div id=\"rating\">\n" +
"                                                    <input type=\"radio\" id=\"star5"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"5\" disabled/>\n" +
"                                                    <label class=\"full\" for=\"star5"+(list.indexOf(x)+1)+"\" title=\"Awesome - 5 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star4half"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"4 and a half\" disabled/>\n" +
"                                                    <label class=\"half\" for=\"star4half"+(list.indexOf(x)+1)+"\" title=\"Pretty good - 4.5 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star4"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"4\" disabled/>\n" +
"                                                    <label class=\"full\" for=\"star4"+(list.indexOf(x)+1)+"\" title=\"Pretty good - 4 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star3half"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"3 and a half\" disabled/>\n" +
"                                                    <label class=\"half\" for=\"star3half"+(list.indexOf(x)+1)+"\" title=\"Meh - 3.5 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star3"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"3\" disabled/>\n" +
"                                                    <label class=\"full\" for=\"star3"+(list.indexOf(x)+1)+"\" title=\"Meh - 3 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star2half"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"2 and a half\" disabled/>\n" +
"                                                    <label class=\"half\" for=\"star2half"+(list.indexOf(x)+1)+"\" title=\"Kinda bad - 2.5 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star2"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"2\" disabled/>\n" +
"                                                    <label class=\"full\" for=\"star2"+(list.indexOf(x)+1)+"\" title=\"Kinda bad - 2 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star1half"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"1 and a half\" disabled/>\n" +
"                                                    <label class=\"half\" for=\"star1half"+(list.indexOf(x)+1)+"\" title=\"Meh - 1.5 stars\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"star1"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"1\" disabled/>\n" +
"                                                    <label class=\"full\" for=\"star1"+(list.indexOf(x)+1)+"\" title=\"Sucks big time - 1 star\"></label>\n" +
"\n" +
"                                                    <input type=\"radio\" id=\"starhalf"+(list.indexOf(x)+1)+"\" name=\"rating"+(list.indexOf(x)+1)+"\" value=\"half\" disabled/>\n" +
"                                                    <label class=\"half\" for=\"starhalf"+(list.indexOf(x)+1)+"\" title=\"Sucks big time - 0.5 stars\"></label>\n" +
"                                                </div>"
+"                                            </td>\n" 
+"                                            <td>"+listSubject.get(x.getSubjectId())+"</td>\n" 
+"                                            <td>\n" 
+"                                                <input type=\"hidden\" id=\"teacherUsername\" value=\""+x.getUsername()+"\"> \n" 
+"                                            </td>\n" 
+"                                            <td>\n" 
+"                                                <button\n" 
+"                                                    type=\"button\"\n" 
+"                                                    class=\"btn btn-primary requestBtn\"\n" 
+"                                                    value=\""+x.getUsername()+"\"\n" 
+"                                                    aria-label=\"Close\"\n" 
+"                                                    data=\""+x.getDisplayName()+"\"\n" 
+"                                                    id=\"closemodal\"\n" 
+"                                                    >\n" 
+"                                                    Select\n" 
+"                                                </button>\n" 
+"                                            </td>\n" 
+"                                        </tr>");
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(TeacherRecommendSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
