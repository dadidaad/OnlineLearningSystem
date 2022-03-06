/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * WalletDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-10   1.0         Danh Tinh    First Implement
 */
package dao;

import bean.AccountBean;
import bean.FinanceBean;
import static dao.BaseDAO.getConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tinht
 */
public class WalletDAO extends BaseDAO{    
    public void UpdateMoney(AccountBean currentAccount, double amount){
        double value = currentAccount.getCash().doubleValue() + amount;
        String message = "Recharge";
        if(amount < 0) message = "Withdrawal";
        AddFianaceHistory(currentAccount, amount, message);
        try {
            Connection conn = getConnection();
            String sql = "update [Account] set [Cash In Account] = "+ value
                    +" where [Username] = '"+ currentAccount.getUsername() +"'";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<FinanceBean> GetAllFinanceHistory(AccountBean account){
        List<FinanceBean> list = new ArrayList<FinanceBean>();
        try {
            Connection conn = getConnection();
            String sql = "select * from [Finance_History] where [UserGet] = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, account.getUsername());
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                list.add(new FinanceBean(rs.getString("UserGet"), 
                            rs.getString("Status"), 
                            rs.getBigDecimal("Money"), 
                            rs.getDate("Time"), 
                            rs.getString("Message"), 
                            rs.getString("UserSent")));
            }
            
            conn.close();
        } catch (SQLException e) {
        }
        
        return list;
    }
    
    public List<FinanceBean> GetFinanceHistoryByPage(List<FinanceBean> allList, int page, int row_per_page){
        List<FinanceBean> pageList;
        int start = (page - 1)* row_per_page;
        int end = start + row_per_page;
        
        pageList = allList.subList(start, end);
        
        return pageList;
    }
    
    public void AddFianaceHistory(AccountBean currentAccount, double amount, String message){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            
            Connection conn = getConnection();
            String sql = "insert into [Finance_History] ([UserGet], [Status], [Money], [Time], [Message], [UserSent])\n" +
                            "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, currentAccount.getUsername());
            statement.setString(2, "True");
            statement.setDouble(3, amount);
            statement.setString(4, dtf.format(now));
            statement.setString(5, message);
            statement.setString(6, "admin");
            ResultSet rs = statement.executeQuery();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
       Date date = new Date(2001-07-10);
       Date crdate = new Date(2022-02-10);
       WalletDAO db = new WalletDAO();
       AccountBean account = new AccountBean("minhduc07", "Aa123456", "minhmomang69@gmail.com", "https://i.ndh.vn/2020/12/18/anh-1-1608284854.jpg", "Duc Minh", date, true, "duc minh dang hoc bai", BigDecimal.ZERO, date, "Teacher", "actived", true, "1");
       List<FinanceBean> list = db.GetFinanceHistoryByPage(db.GetAllFinanceHistory(account), 3, 2);
       
       for(FinanceBean f : list) {
           System.out.println(f.getMoney());
       }
       
    }
}
