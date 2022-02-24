package Controller;

import Bean.AccountBean;
import Bean.TeacherBean;
import Dao.ISubjectDAO;
import Dao.ITeacherDAO;
import Dao.SubjectDAO;
import Dao.TeacherDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author win
 */
public class ListAllTeacherSearchController extends HttpServlet {

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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            String searchString = request.getParameter("searchString");
            ArrayList<TeacherBean> teacherList = new ArrayList<>();
            ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
            teacherList = iTeacherDAO.getTeacherBySearch(searchString);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
//            HttpSession session = request.getSession();
//            AccountBean account = (AccountBean) session.getAttribute("user");
//            ArrayList<TeacherBean> teacherList = new ArrayList<>();
//            ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
//            teacherList = iTeacherDAO.getTeacherBySearch(searchString);
//
//            ISubjectDAO iSubjectDAO = new SubjectDAO(); //Use ISubjectDAO interface to call
//            Map<Integer, String> subjectNames = iSubjectDAO.getSubjectNames();
//
//            int index = 1;
//            String requestButtonStyle = "";
//            if (account.getRole().equalsIgnoreCase("Teacher")) {
//                requestButtonStyle = "d-none";
//            }
//            request.setAttribute("teachers", teacherList);

//            out.print("success");
//            for(TeacherBean t : teacherList){
//            out.println("<tr>\n" +
//"                        <td>"+index+"</td>\n" +
//"                        <td>\n" +
//"                          <a class=\"teacherInfo\" href=\"#\">\n" +
//"                              <img class=\"teacherAvt\" src=\"${t.getAvatar()}\"/>\n" +
//"                              "+t.getDisplayName()+"\n" +
//"                          </a>\n" +
//"                        </td>" +
//"                        </td>\n" +
//"                        <td>"+"4.1"+"</td>\n" +
//"                        <td>"+subjectNames.get(t.getSubjectId())+"</td>\n" +
//"                        <td>\n" +
//"                          <img\n" +
//"                            class=\"teacherCv imgZoom\"\n" +
//"                            src=\""+t.getCvImg()+"\"\n" +
//"                            alt=\"\"\n" +
//"                          />\n" +
//"                        </td>\n" +
//"                        <td>\n" +
//"                          <a class="+requestButtonStyle+" href=\"CreateRequest?teacherRcmFromList="+t.getUsername()+"\"><i class=\"far fa-share-square\"></i></a>\n" +
//"                        </td>\n" +
//"                      </tr>");
//            index++;
//            }
        } catch (Exception e) {

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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String searchString = request.getParameter("searchString");
            ArrayList<TeacherBean> teacherList = new ArrayList<>();
            ITeacherDAO iTeacherDAO = new TeacherDAO(); //Use ITeacherDAO interface to call
            teacherList = iTeacherDAO.getTeacherBySearch(searchString);
        
            String jsonData = new ObjectMapper().writeValueAsString(teacherList); //convert object to json
//            teacherList = ApproverDao.requestGetter();  
            out.print(jsonData); //send data to client
            out.flush();
        
        }catch(Exception e){
            
            
        }
    }

}
