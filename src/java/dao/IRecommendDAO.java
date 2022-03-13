/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RecommendBean;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Phong Vu
 */
public interface IRecommendDAO {
    public int createRecommend(RecommendBean recommend) throws SQLException;
    public ArrayList<RecommendBean> getByUsername(String username) throws SQLException;
    public int numberOfAccept(String username) throws SQLException;
    public int numberOfDecline(String username) throws SQLException;
    public ArrayList<RecommendBean> getByAction(boolean action) throws SQLException;
    
    public int changeStatus(String status, int RecId) throws SQLException;
}
