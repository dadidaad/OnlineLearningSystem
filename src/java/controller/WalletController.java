/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * ViewRequestTeaController
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Danh Tinh    First Implement
 */
package controller;

import bean.AccountBean;
import bean.FinanceBean;
import bean.NotificationBean;
import bean.PaginationBean;
import dao.AccountDAO;
import dao.INotificationDAO;
import dao.NotificationDAO;
import dao.WalletDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DateCompare;

/**
 *
 * @author tinht
 */
public class WalletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        WalletDAO db = new WalletDAO();
        AccountBean account = (AccountBean) session.getAttribute("user");
        List<FinanceBean> list = db.GetAllFinanceHistory(account);

        /*Notification*/
        if (account != null) {
            INotificationDAO iNotificationDAO = new NotificationDAO();

            int notiUnread = iNotificationDAO.getTotalNotiUnread(account.getUsername());
            request.setAttribute("notiUnread", notiUnread);
            List<NotificationBean> notiList = iNotificationDAO.getTopNotification(account.getUsername());
            request.setAttribute("notificationList", notiList);
        }

        int page;
        int row_per_page = 6;
        if (request.getParameter("page") != null) {
            page = (Integer.parseInt(request.getParameter("page")));
        } else {
            page = 1;
        }

        DateCompare dc = new DateCompare();

        list = dc.sortedList(list);
        PaginationBean pagination = new PaginationBean(page, row_per_page, list.size());
        list = db.GetFinanceHistoryByPage(list, page, row_per_page);

        request.setAttribute("listFinance", list);
        request.setAttribute("page", page);
        request.setAttribute("row_per_page", row_per_page);
        request.setAttribute("pagination", pagination);
        request.getRequestDispatcher("./view/Wallet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        WalletDAO walletDB = new WalletDAO();
        AccountDAO accountDB = new AccountDAO();

        AccountBean account = (AccountBean) session.getAttribute("user");
        double cash = account.getCash().doubleValue();
        String status = "";
        String warning = "";
        double amount = 0;
        if (request.getParameter("amount") != null) {
            amount = Integer.parseInt(request.getParameter("amount"));
        }

        if (request.getParameter("status") != null) {
            status = request.getParameter("status");
        }

        if (status.equals("withdrawal")) {
            if (amount > 0) {
                amount = -amount;
            }
            if (cash + amount >= 0) {
                walletDB.UpdateMoney(account, amount, "admin", status);
                warning = "successed!";
            } else {
                warning = "failed";
            }
        } else if (status.equals("recharge")) {

            if (amount >= 0) {
                walletDB.UpdateMoney(account, amount, "admin", status);
                warning = "successed!";
            } else {
                warning = "failed";
            }
        }

        amount = 0;

        account = accountDB.getAccountByUsername(account.getUsername());
        session.setAttribute("user", account);
        request.setAttribute("warning", warning);
        request.setAttribute("amount", amount);
        response.sendRedirect("Wallet");

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
