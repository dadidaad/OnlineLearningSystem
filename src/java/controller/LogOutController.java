/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * LogOutController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         DajtVox    First Implement
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling log out function /Home is the URL
 * of the web site Extend HttpServlet class
 *
 * @author DajtVox
 */
public class LogOutController extends HttpServlet {

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
            response.setHeader("Cache-Control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");

            request.getSession().invalidate(); // kill all session exist in request
            response.sendRedirect("Home"); //redirect to Home
        } catch(Exception e){
            Logger.getLogger(LogOutController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
