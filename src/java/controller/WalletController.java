/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AccountBean;
import bean.FinanceBean;
import bean.PaginationBean;
import dao.AccountDAO;
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
        AccountBean account = (AccountBean)session.getAttribute("user");
        List<FinanceBean> list = db.GetAllFinanceHistory(account);
        
        int page;
        int row_per_page = 6;
        if(request.getParameter("page") != null)
            page = (Integer.parseInt(request.getParameter("page")));
        else page = 1;
        
        
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
            
            AccountBean account = (AccountBean)session.getAttribute("user");
            double cash = account.getCash().doubleValue();
            String status = "";
            String warning = "";
            double amount = 0;
            if(request.getParameter("amount") != null) {
                amount = Integer.parseInt(request.getParameter("amount"));
            }
            
            if(request.getParameter("status") != null)
                status = request.getParameter("status");
            
            if(status.equals("withdrawal")) {
                if(amount >0) amount = -amount;
                if(cash + amount >= 0){
                    walletDB.UpdateMoney(account, amount, "admin",status);
                    warning = "successed!";
                }
                else
                    warning = "failed";
            }
            else if(status.equals("recharge")) {
                
                if(amount >= 0){
                    walletDB.UpdateMoney(account, amount, "admin",status);
                    warning = "successed!";
                }
                else
                    warning = "failed";
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
