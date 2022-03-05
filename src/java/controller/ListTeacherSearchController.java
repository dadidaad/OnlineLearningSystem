/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * ListTeacherSearchController
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
import java.util.List;
import java.util.Map;
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
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String searchString = request.getParameter("searchString");
            ITeacherDAO iTeacherDAO = new TeacherDAO();
            ISubjectDAO iSubjectDAO = new SubjectDAO();
            Map<Integer, String> listSubject = iSubjectDAO.getSubjectNames();
            List<TeacherBean> list = iTeacherDAO.getTeacherBySearching(searchString);
            if (list.isEmpty()) {
                out.print("<tr>List Empty</tr>");
            } else {
                for (TeacherBean x : list) {
                    out.print("<tr>\n"
+ "                                                    <td>" + (list.indexOf(x) +1) + "</td>\n"
+ "                                                    <td>\n"
+ "                                                        <a class=\"teacherInfo\" href=\"#\"\n"
+ "                                                           ><img\n"
+ "                                                                class=\"teacherAvt\"\n"
+ "                                                                src=\"" + (request.getContextPath()+ x.getAvatar())+ "\"\n"
+ "                                                                alt=\"\"\n"
+ "                                                                />" + x.getDisplayName() + "</a\n"
+ "                                                        >\n"
+ "                                                    </td>\n"
+ "                                                    <td>4.1</td>\n"
+ "                                                    <td>"+ listSubject.get(x.getSubjectId())  +"</td>\n"
+ "                                                    <td>\n"
+ "                                                        <img\n"
+ "                                                            class=\"teacherCv imgZoom\"\n"
+ "                                                            src=\""+ (request.getContextPath() + x.getCvImg()) + "\"\n"
+ "                                                            alt=\"\"\n"
+ "                                                            />\n"
+ "                                                    </td>\n"
+ "                                                    <c:if test = \"${fn:toLowerCase(userRole) ne 'teacher'}\">\n"
+ "                                                        <td>\n"
+ "                                                            <a href=\"CreateRequest?teacherRcmFromList=" + x.getUsername() + "\"><i class=\"far fa-share-square\"></i></a>\n"
+ "                                                        </td>\n"
+ "                                                    </c:if>\n"
+ "                                                </tr>");
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ListAllTeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
