/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * AccountDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         DajtVox    First Implement
 */
package Dao;

import Bean.AccountBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contain method to find account, insert, update account Extend
 * BaseDAO class to call getConnection() method Implement IAccountDAO Interface
 *
 * @author DajtVox
 */
public class AccountDAO extends BaseDAO implements IAccountDAO {

    /**
     * getDisplayName method implement from IAccountDAO
     *
     * @return Hashmap<String, String>. <code>java.util.HashMap</code> object
     */
    @Override
    public Map<String, String> getDisplayNames() {
        Map<String, String> DisplayNames = new HashMap<>(); //initialize hashmap
        try {
            //Set up connection and Sql statement for Querry
            Connection conn = getConnection();
            String sql = "select * from Account";
            PreparedStatement statement = conn.prepareStatement(sql);

            //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();

            //Assign data to an arraylist of SubjectBean
            while (rs.next()) {
                DisplayNames.put(rs.getString("Username"), rs.getString("DisplayName"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DisplayNames;
    }

    /**
     * getAccountByUsername method implement from IAccountDAO
     *
     * @param username username of account belongs <code>java.lang.String</code>
     * object
     * @return AccountBean. <code>com.Bean.AccountBean</code> object
     */
    @Override
    public AccountBean getAccountByUsername(String username) {
        if (username == null || username.equals("")) {
            return null;
        }
        AccountBean x = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = getConnection(); //set up connection to sql
            String sql = "select * from Account where Username COLLATE Latin1_General_CS_AS_KS_WS = ?"; //sql query
            statement = conn.prepareStatement(sql);
            statement.setString(1, username); //set parameter to query
            rs = statement.executeQuery();
            /*assign data to AccountBean object*/
            while (rs.next()) {
                x = new AccountBean();
                x.setUsername(rs.getString("Username"));
                x.setPassword(rs.getString("Password"));
                x.setMail(rs.getString("Mail"));
                x.setAvatar(rs.getString("Avatar"));
                x.setDisplayName(rs.getString("DisplayName"));
                x.setDateOfBirth(rs.getDate("DateOfBirth"));
                x.setSex(rs.getBoolean("Sex"));
                x.setDescription(rs.getString("Description"));
                x.setCash(rs.getBigDecimal("Cash In Account"));
                x.setCreateDate(rs.getDate("CreatedDate"));
                x.setRole(rs.getString("Role"));
                x.setStatus(rs.getString("Status"));
                x.setState(rs.getBoolean("State"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return x;
    }

    /**
     * getAccountByMail method implement from IAccountDAO
     *
     * @param email
     * @param mail username of account belongs <code>java.lang.String</code>
     * object
     * @return AccountBean. <code>com.Bean.AccountBean</code> object
     */
    @Override
    public AccountBean getAccountByMail(String email) {
        if (email == null || email.equals("")) {
            return null;
        }
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        AccountBean x = null;
        try {
            conn = getConnection(); // get connection to database
            String sql = "select * from Account where Mail = ?"; // sql query
            statement = conn.prepareStatement(sql);
            statement.setString(1, email); //set parameter to sql query
            rs = statement.executeQuery();
            /* assign data to AccountBean object */
            while (rs.next()) {
                x = new AccountBean();
                x.setUsername(rs.getString("Username"));
                x.setPassword(rs.getString("Password"));
                x.setMail(rs.getString("Mail"));
                x.setAvatar(rs.getString("Avatar"));
                x.setDisplayName(rs.getString("DisplayName"));
                x.setDateOfBirth(rs.getDate("DateOfBirth"));
                x.setSex(rs.getBoolean("Sex"));
                x.setDescription(rs.getString("Description"));
                x.setCash(rs.getBigDecimal("Cash In Account"));
                x.setCreateDate(rs.getDate("CreatedDate"));
                x.setRole(rs.getString("Role"));
                x.setStatus(rs.getString("Status"));
                x.setState(rs.getBoolean("State"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return x;
    }

    /**
     * updateNewPassword method implement from IAccountDAO
     *
     * @param account account object of user belongs
     * <code>com.Bean.AccountBean</code>
     * @return
     */
    @Override
    public boolean updateNewPassword(AccountBean account) {
        AccountBean x = getAccountByMail(account.getMail()); // get account by mail to check if exist in db, if no return false
        if (x == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection(); // get conection to database
            String sql = "update Account \n"
                    + "set Password  = ?\n"
                    + "where Mail = ?"; //sql query
            statement = conn.prepareStatement(sql);
            /* set parameter for query */
            statement.setString(1, account.getPassword());
            statement.setString(2, account.getMail());
            int status = statement.executeUpdate();
            if (status == 1) {
                return true; // return true if success update data in database
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                /*close connection*/
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * insertNewAccount method implement from IAccountDAO
     *
     * @param account account object of user belongs
     * <code>com.Bean.AccountBean</code>
     * @return
     */
    @Override
    public boolean insertNewAccount(AccountBean account) {
        AccountBean x = getAccountByUsername(account.getUsername()); // get account from user to check exist, if null return false
        if (x != null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection(); // get connection to database
            String sql = "Insert into Account([Username], [Password], [Mail], [Sex]) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            /* set parameter for query*/
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getMail());
            statement.setBoolean(4, account.getSex());
            int status = statement.executeUpdate(); //execute query if success then status =  1 return true;
            if (status == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        IAccountDAO db = new AccountDAO();
        AccountBean x = new AccountBean();
        x.setUsername("admin");
        x.setPassword("password");
        x.setMail("123@gmail.com");
        x.setSex(true);
        System.out.println(db.insertNewAccount(x));
    }
}
