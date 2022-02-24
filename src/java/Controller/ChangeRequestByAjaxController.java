/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * ChangeRequestByAjaxController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package Controller;

import Bean.AccountBean;
import Bean.RequestBean;
import Dao.AccountDAO;
import Dao.IAccountDAO;
import Dao.IRequestDAO;
import Dao.ISubjectDAO;
import Dao.ITeacherDAO;
import Dao.RequestDAO;
import Dao.SubjectDAO;
import Dao.TeacherDAO;
import Utils.SortRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a Servlet responsible for handling the task when the user wants to see the list of Request by type of status
 * /ChangeRequestByAjax is the URL of the Servlet
 * Extend HttpServlet class
 * @author Duc Minh
 */
public class ChangeRequestByAjaxController extends HttpServlet {


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
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        HttpSession session = request.getSession();   
        AccountBean account =(AccountBean) session.getAttribute("user");
        
        SortRequest sortRequest = new SortRequest(); // Call the sort class modify
        ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
        Map<Integer, String> subjectNames = iSubjectDAO.getSubjectNames();
        
        ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ISubjectDAO interface to call
                
        IAccountDAO iAccountDAO = new AccountDAO(); //Use ISubjectDAO interface to call
        Map<String, String> displayNames = iAccountDAO.getDisplayNames();
        
        String rqStatus = request.getParameter("rqStatus");
        IRequestDAO iRequestDAO = new RequestDAO();
        
        int index = 1;

        ArrayList<RequestBean> requestList = new ArrayList<>();
        
        if(account.getRole().equalsIgnoreCase("student")){
            
            requestList = iRequestDAO.getRequestForStudent(account.getUsername(), rqStatus);
            
            for (RequestBean r : requestList) {  //If user is a student
            out.println("<tr>\n" +
"                        <td>"+index+"</td>\n" +
"                        <td>"+formatDate.format(r.getCreatedTime())+"</td>\n" +
"                        <td>"+r.getTitle()+"</td>\n" +
"                        <td>Class "+r.getLevel() +"</td>\n" +
"                        <td>"+ subjectNames.get(r.getSubjectID())+"</td>\n" +
"                        <td>"+ r.getCost()+" <Span>VND</Span></td>\n" +
"                        <td>"+r.getStatus()+"</td>\n" +
"                        <td>\n" +
"                          <a href=\"ViewRequestStu?requestId="+r.getRequestID()+"\"><i class=\"far fa-eye\"></i></a>\n" +
"                        </td>\n" +
"                        \n" +
"                      </tr> ");
            index++;
            }
        }
        
        else if(account.getRole().equalsIgnoreCase("teacher")){ //If user is a teacher
            if(rqStatus.equalsIgnoreCase("Approved") || rqStatus.equalsIgnoreCase("Report")){
                requestList = iRequestDAO.getRequestForEachTeacher(account.getUsername(), iTeacherDAO.getSubjectId(account.getUsername()), rqStatus); 
            }
            else{
                requestList = iRequestDAO.getRequestForTeacher(iTeacherDAO.getSubjectId(account.getUsername()), rqStatus); 
            }
        //Sort the request list
        requestList = sortRequest.requestListSorted(requestList, account.getUsername());
            for (RequestBean r : requestList) {
                String htmlStar="";
                if(account.getUsername().equalsIgnoreCase(r.getTutorGet())) htmlStar = "<i class=\"far fa-star\"></i>"; 
            out.println("<tr>\n" +
"                        <td>"+index+"</td>\n" +
"                        <td>"+formatDate.format(r.getCreatedTime())+"</td>\n" +
"                        <td>"+displayNames.get(r.getStudentSent())+"</td>\n" +
"                        <td>"+r.getTitle()+"</td>\n" +
"                        <td>Class "+r.getLevel()+"</td>\n" +
"                        <td>"+r.getCost() +"<Span>VND</Span></td>\n" +
"                        <td>\n" +
"                          <a href=\"ViewRequestTea?requestId="+r.getRequestID()+"\"><i class=\"far fa-eye\"></i></a>\n" +
"                        </td>\n" +
"                        <td>"+htmlStar+"</td>\n" +
"                      </tr> ");
            index++;
            }
        }
        
    }catch(Exception e){
    
    }
  }

}
