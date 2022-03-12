/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CounterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CounterViewDAO extends BaseDAO implements ICounterViewDAO {

    @Override
    public List<CounterBean> getAllCounter() {
        List<CounterBean> listCounter = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "Select * from CounterView";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                CounterBean x = new CounterBean();
                x.setCounter(rs.getInt("Counter"));
                x.setDate(rs.getDate("Date"));
                listCounter.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CounterViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return listCounter;
    }

    @Override
    public void insertNewRecord(CounterBean x) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection();
            String sql = "Insert into CounterView(Date, Counter) values(?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setDate(1, x.getDate());
            statement.setInt(2, x.getCounter());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CounterViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, null);
        }
    }

    @Override
    public int getTotalView() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "select SUM([Counter]) from CounterView";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CounterViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
