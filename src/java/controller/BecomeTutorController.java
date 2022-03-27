/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * BecomeTutorController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-28   1.0         DajtVox    First Implement
 */
package controller;

import bean.AccountBean;
import bean.TeacherBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import dao.ITeacherDAO;
import dao.TeacherDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import utils.AppUtils;

/**
 * This is a Servlet responsible for handle data from user want become tutor
 * page Extend HttpServlet class
 *
 * @author DajtVox
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class BecomeTutorController extends HttpServlet {

    private static final String DATA_DIRECTORY = "assets\\image\\teacherCV";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("ViewProfile");
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
        String uploadFolder = getServletContext().getRealPath("")
                + File.separator + DATA_DIRECTORY;// constructs the folder where uploaded file will be stored
        File uploadDir = new File(uploadFolder);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false); //get session from request
            AccountBean loginUser = AppUtils.getLoginedUser(session); //check user login, if not exist then redirect to login
            TeacherBean teacher = new TeacherBean();
            teacher.setUsername(loginUser.getUsername());
            String cvPath = null;
            Part teacherCV = request.getPart("teacherCV"); //get part object of cv
            if (teacherCV != null) {
                String fileName = "cv_" + loginUser.getUsername() + "." + FilenameUtils.getExtension(teacherCV.getSubmittedFileName()); // create name for picture
                InputStream is = teacherCV.getInputStream();
                Files.copy(is, Paths.get(uploadFolder + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING); //upload to server image
                cvPath = "/assets/image/teacherCV/" + fileName;
            }
            String subjectID = request.getParameter("subject");
            /*set new information for user*/
            teacher.setCvImg(cvPath);
            teacher.setSubjectId(Integer.parseInt(subjectID));
            ITeacherDAO teacherDAO = new TeacherDAO();
            boolean checkInsert = false;
            if(!teacherDAO.getTeacherStatus(loginUser.getUsername())){
                checkInsert = teacherDAO.insertNewTeacher(teacher);
            }
            else{
                checkInsert = teacherDAO.UpdateNewTeacher(teacher);
            }
            if (checkInsert) {
                out.print("Success upload CV!! Please wait for admin check your CV");
            } else {
                out.print("Error when upload your CV, please try again");
            }
        } catch (Exception ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("Home");
        }

    }
}
