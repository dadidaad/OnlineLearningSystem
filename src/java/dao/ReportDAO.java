/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * WalletDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-08   1.0         Danh Tinh    First Implement
 */
package dao;

import bean.ReportBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tinht
 */
public class ReportDAO extends BaseDAO{
    public ArrayList<ReportBean> GetAllReport(){
        ArrayList<ReportBean> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select * from [Report]";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                list.add(new ReportBean(rs.getInt("id"), 
                                        rs.getString("UserSent"), 
                                        rs.getString("UserReported"), 
                                        rs.getString("message")));
            }
            conn.close();
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    public ArrayList<ReportBean> GetReportByUserSent(String userSent){
        ArrayList<ReportBean> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select * from [Report] where [UserSent] = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, userSent);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                list.add(new ReportBean(rs.getInt("id"), 
                                        rs.getString("UserSent"), 
                                        rs.getString("UserReported"), 
                                        rs.getString("message")));
            }
            conn.close();
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    public void CreateReport(int reportID, String userSent, String userReported, String title){
        try {
            Connection conn = getConnection();
            String sql = "insert into [Report]\n" +
                            "values (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, reportID);
            statement.setString(2, userSent);
            statement.setString(3, userReported);
            statement.setString(4, title);
            ResultSet rs = statement.executeQuery();
            conn.close();
        } catch (SQLException e) {
            
        }
    }
    
    public static void main(String[] args) {
        ReportDAO db = new ReportDAO();
        ReportBean report = new ReportBean(40, "minhduc07", "lanhuong", "abc");
//        ArrayList<ReportBean> list = db.GetAllReport();
//        System.out.println(list.get(0).getId());
        db.CreateReport(report.getId(), report.getUserSent(), report.getUserReported(), report.getMessage());
    }
}
