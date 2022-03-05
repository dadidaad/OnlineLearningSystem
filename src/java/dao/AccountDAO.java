/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * AccountDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-11   1.0         DajtVox    First Implement
 */
package dao;

import bean.AccountBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Map<String, String> displayNames = new HashMap<>(); //initialize hashmap
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            //Set up connection and Sql statement for Querry
            conn = getConnection();
            String sql = "select * from Account";
            statement = conn.prepareStatement(sql);

            //Querry and save in ResultSet
            rs = statement.executeQuery();

            //Assign data to an arraylist of SubjectBean
            while (rs.next()) {
                displayNames.put(rs.getString("Username"), rs.getString("DisplayName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return displayNames;
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
            close(conn, statement, rs);
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
            close(conn, statement, rs);
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
            close(conn, statement, null);
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
            int status = statement.executeUpdate();
            if (status == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            close(conn, statement, null);
        }
        return false;
    }

    /**
     * updateInformation method implement from IAccountDAO
     *
     * @param account account object of user belongs
     * <code>com.Bean.AccountBean</code>
     * @return
     */
    @Override
    public boolean updateInformation(AccountBean account) {
        AccountBean x = getAccountByUsername(account.getUsername());
        if (x == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = getConnection();
            String sql = "Update Account\n"
                    + "Set DisplayName = '" + account.getDisplayName() + "',\n"
                    + "DateOfBirth = '" + account.getDateOfBirth() + "'\n";
            /*check if some custom edit part is null or not then join it to sql query*/
            if (account.getDescription() != null) {
                sql += ",Description = '" + account.getDescription() + "'\n";
            }
            if (account.getAvatar() != null) {
                sql += ",Avatar = '" + account.getAvatar() + "'\n";
            }
            sql += "where Username = '" + account.getUsername() + "'";
            statement = conn.prepareStatement(sql);
            int result = statement.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, null);
        }
        return false;
    }

    /**
     * totalAccount method implement from IAccountDAO
     *
     * @return total Integer<Integer>.
     */
    @Override
    public int totalAccount() {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "SELECT COUNT(Username) AS NumberOfAccount FROM Account WHERE Role <> 'Admin'";

            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }

            /*Close all the connection */
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * totalAccountSearch method implement from IAccountDAO
     *
     * @param searchString
     * @return total Integer<Integer>.
     */
    @Override
    public int totalAccountSearch(String searchString) {
        int total = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "SELECT COUNT(Username) AS NumberOfAccount FROM Account WHERE (DisplayName like ? or Mail like ? ) and Role <> 'Admin' and\n"
                    + "username not in (select Username from Tutor where Status<>'Approved')";

            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchString + "%"); //set parameter to query
            statement.setString(2, "%" + searchString + "%");
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an variable of Request*/
            while (rs.next()) {
                total = rs.getInt("NumberOfAccount");
            }

            /*Close all the connection */
        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return total;
    }

    /**
     * getAllAccount method implement from IAccountDAO
     *
     * @param searchString  <code>java.lang.String</code>
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return ArrayList<AccountBean>. <code>java.util.ArrayList</code> object
     */
    @Override
    public List<AccountBean> getAllAccountBySearch(String searchString, int pageindex, int pagesize) {
        List<AccountBean> accounts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "select Account.*\n"
                    + "from Account\n"
                    + "where (DisplayName like ? or Mail like ? ) and Role <> 'Admin' and \n"
                    + "username not in (select Username from Tutor where Status<>'Approved')"
                    + "ORDER BY CreatedDate desc\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchString + "%"); //set parameter to query
            statement.setString(2, "%" + searchString + "%");
            statement.setInt(3, (pageindex - 1) * pagesize);
            statement.setInt(4, pagesize);
            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Request*/
            while (rs.next()) {
                AccountBean account = new AccountBean();

                account.setUsername(rs.getString("Username"));
                account.setPassword(rs.getString("Password"));
                account.setMail(rs.getString("Mail"));
                account.setAvatar(rs.getString("Avatar"));
                account.setDisplayName(rs.getString("DisplayName"));
                account.setDateOfBirth(rs.getDate("DateOfBirth"));
                account.setSex(rs.getBoolean("Sex"));
                account.setDescription(rs.getString("Description"));
                account.setCash(rs.getBigDecimal("Cash In Account"));
                account.setCreateDate(rs.getDate("CreatedDate"));
                account.setRole(rs.getString("Role"));
                account.setStatus(rs.getString("Status"));
                account.setState(rs.getBoolean("State"));

                accounts.add(account);
            }
            /*Close all the connection */

        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return accounts;
    }

    /**
     * getAllAccount method implement from IAccountDAO
     *
     * @param pageindex <code>java.lang.Integer</code>
     * @param pagesize <code>java.lang.Integer</code>
     * @return ArrayList<AccountBean>. <code>java.util.ArrayList</code> object
     */
    @Override
    public List<AccountBean> getAllAccount(int pageindex, int pagesize) {
        List<AccountBean> accounts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "SELECT Account.*\n"
                    + "FROM Account\n"
                    + "WHERE Role <> 'Admin'\n"
                    + "ORDER BY CreatedDate desc\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, (pageindex - 1) * pagesize);
            statement.setInt(2, pagesize);

            /*Query and save in ResultSet */
            rs = statement.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
                AccountBean account = new AccountBean();

                account.setUsername(rs.getString("Username"));
                account.setPassword(rs.getString("Password"));
                account.setMail(rs.getString("Mail"));
                account.setAvatar(rs.getString("Avatar"));
                account.setDisplayName(rs.getString("DisplayName"));
                account.setDateOfBirth(rs.getDate("DateOfBirth"));
                account.setSex(rs.getBoolean("Sex"));
                account.setDescription(rs.getString("Description"));
                account.setCash(rs.getBigDecimal("Cash In Account"));
                account.setCreateDate(rs.getDate("CreatedDate"));
                account.setRole(rs.getString("Role"));
                account.setStatus(rs.getString("Status"));
                account.setState(rs.getBoolean("State"));

                accounts.add(account);
            }

        } catch (SQLException ex) {
            /*Exception Handle*/
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return accounts;
    }

    /**
     * updateRequest method implement from IRequestDAO
     *
     * @param username username of account belongs <code>java.lang.String</code>
     * @param status status of account belongs <code>java.lang.String</code>
     * This method update the request and update to database
     */
    @Override
    public void updateStatusAccount(String username, String status) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "update Account\n"
                    + "               set Status= ?  WHERE username = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, status);
            statement.setString(2, username);

            /*Excuse Query*/
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
    }

    /**
     * deleteAccount method implement from IRequestDAO
     *
     * @param username username of account belongs <code>java.lang.String</code>
     * This method update the request and update to database
     */
    @Override
    public void deleteAccount(String username) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query */
            conn = getConnection();
            String sql = "delete from Tutor where Username = ? \n"
                    + "update Request set Tutor_get = null where Tutor_get = ? \n"
                    + "delete from Request_Reply where Tutor_sent = ? \n"
                    + "delete from Vote where User_get = ? \n"
                    + "delete from Post_Reply where User_reply = ? or PostID in(select PostID from Post where UserPost= ? )\n"
                    + "delete from Post where UserPost = ? \n"
                    + "delete from Account where Username = ? ;";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, username);
            statement.setString(3, username);
            statement.setString(4, username);
            statement.setString(5, username);
            statement.setString(6, username);
            statement.setString(7, username);
            statement.setString(8, username);

            /*Excuse Query*/
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
    }

}
