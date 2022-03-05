/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * EditProfileController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-25   1.0         DajtVox    First Implement
 */
package controller;

import bean.AccountBean;
import dao.AccountDAO;
import dao.IAccountDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

/**
 * This is a Servlet responsible for handle edit info from login user in web
 * page Extend HttpServlet class
 *
 * @author DajtVox
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class EditProfileController extends HttpServlet {

    private static final String DATA_DIRECTORY = "assets\\image\\avatar";

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
        try {
            HttpSession session = request.getSession(false); //get session from request
            AccountBean loginUser = (AccountBean) session.getAttribute("user"); //check user login, if not exist then redirect to login
            String avatarPath = null;
            Part avatar = request.getPart("avatar"); //get part object of avatar
            if (avatar != null) {
                String fileName = "ava_" + loginUser.getUsername() + "." + FilenameUtils.getExtension(avatar.getSubmittedFileName()); // create name for picture
                InputStream is = avatar.getInputStream();
                Files.copy(is, Paths.get(uploadFolder + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING); //upload to server image
                avatarPath = "/assets/image/avatar/" + fileName;
            }
            String displayName = request.getParameter("displayName").trim();
            String description = request.getParameter("description").trim();
            String dob = request.getParameter("dob").trim();
            IAccountDAO accountDAO = new AccountDAO();
            /*set new information for user*/
            loginUser.setAvatar(avatarPath);
            loginUser.setDisplayName(displayName);
            loginUser.setDateOfBirth(Date.valueOf(dob));
            loginUser.setDescription(description);
            accountDAO.updateInformation(loginUser); //call to update information method, return true if success
            response.sendRedirect("ViewProfile"); //redirect to ViewProfile
        } catch (Exception ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("Login");
        }
    }
}
