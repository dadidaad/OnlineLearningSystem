/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface IRecommendDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-08   1.0         Doan Tu    First Implement
 */
package dao;

import bean.RecommendBean;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the interface class that declares the methods to access the data of the Recommend object
 * 
 * @author Doan Tu
 */
public interface IRecommendDAO {
    /**
     * createRecommend method
     * This method will insert new recommend into Database
     * 
     * @param recommend <code>bean.RecommendBean</code>
     * @return numberOfRowsAffected. <code>java.lang.Integer</code>
     * @throws SQLException 
     */
    public int createRecommend(RecommendBean recommend) throws SQLException;
    
    /**
     * getByUsername method 
     * This method will get all Recommend with corresponding username
     * 
     * @param username <code>java.lang.String</code>
     * @return recommends. <code>java.ultil.ArrayList</code>
     * @throws SQLException 
     */
    public ArrayList<RecommendBean> getByUsername(String username) throws SQLException;
    
    /**
     * numberOfAccept Method
     * This method will return number of recommend with status is accept
     * 
     * @param username <code>java.lang.String</code>
     * @return numberOfRecommend. <code>java.lang.Integer</code>
     * @throws SQLException 
     */
    public int numberOfAccept(String username) throws SQLException;
    
    /**
     * numberOfAccept Method
     * This method will return number of recommend with status is decline
     * 
     * @param username <code>java.lang.String</code>
     * @return numberOfRecommend. <code>java.lang.Integer</code>
     * @throws SQLException 
     */
    public int numberOfDecline(String username) throws SQLException;
    
    /**
     * getByAction method
     * This method will get all Recommend with corresponding action
     * 
     * @param action <code>java.lang.Boolean</code>
     * @return recommends. <code>java.ultil.ArrayList</code>
     * @throws SQLException  
     */
    public ArrayList<RecommendBean> getByAction(boolean action) throws SQLException;
    
    /**
     * changeStatus method
     * This method will change the status of recommend with corresponding Recommend ID
     * 
     * @param status <code>java.lang.String</code>
     * @param RecId <code>java.lang.Integer</code>
     * @return numberOfRowsAffected <code>java.lang.Integer</code>
     * @throws SQLException 
     */
    public int changeStatus(String status, int RecId) throws SQLException;
}
