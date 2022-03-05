/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * KnowledgeDAO 
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-10   1.0         Hoang Ngoc Long    First Implement
 */
package dao;

import bean.ArticleBean;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 * Document: BaseDAO for get data for Article bean from database Create on: Feb
 * 9, 2022, 8:11:23 PM
 *
 * @author Hoang Ngoc Long
 */
public class ArticleDAO extends BaseDAO implements IArticleDAO {

    private String query;

    /**
     * getAllArticle method implement from IBaseDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    @Override
    public List<ArticleBean> getAllArticle() {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select top 4 *, SUBSTRING([description], 0, 45) +'...' as [descripcut] from Article where approved='True' order by published desc ";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                list.add(new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get descripcut of article*/
                        rs.getString(9),
                        /*get imagelink of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5)
                ));
            }
            return list;
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * getAllMovie following paging method implement from IBaseDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    public List<ArticleBean> pagingAricle(int index) {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "with t as(\n"
                    + "select  ArticleID, title,imageLink, SUBSTRING([description], 0, 750) +'...' as [descripcut], published, createName  from Article where approved='True'\n"
                    + ")\n"
                    + "SELECT ArticleID,title,descripcut,imageLink, published,createName FROM (SELECT ROW_NUMBER() OVER (ORDER BY ArticleID ASC)\n"
                    + "as rownum,t.ArticleID,t.title,t.descripcut,t.imageLink , t.published,t.createName  FROM t ) as tblHuman WHERE rownum > ? AND rownum <= ? ";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setInt(1, (index - 1) * 6);
            statement.setInt(2, (index) * 6);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                list.add(new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get imagelink of article*/
                        rs.getString(3),
                        /*get descripcut of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * count number of article following paging method implement from IBaseDAO
     *
     *
     * @return numbers.
     */
    @Override
    public int totalArticle() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Article where approved='True'";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);

        }
        return 0;
    }

    /**
     * getArticleDetail method implement from IBaseDAO
     *
     * @param aritcle of the article. <code>java.lang.Integer</code> object
     * @return article object
     */
    @Override
    public ArticleBean getArticleDetail(int aritcle) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select ArticleID,title,description,imageLink,published, createName from Article where ArticleID=? and approved='True'";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setInt(1, aritcle);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            while (rs.next()) {
                return new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get description of article*/
                        rs.getString(3),
                        /*get imageLink of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get createname of article*/
                        rs.getString(6)
                );
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);

        }
        return null;
    }

    /**
     * getTop4Article newest method implement from IBaseDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    @Override
    public List<ArticleBean> getTop4Article() {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select top 4 *, SUBSTRING([description], 0, 50) +'...' as [descripcut] from Article where approved='True' order by published desc";
            //Set up connection and Sql statement for Querry
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            //Assign data to an List of Article
            while (rs.next()) {
                list.add(new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get imagelink of article*/
                        rs.getString(9),
                        /*get descripcut of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5)
                ));
            }
            return list;
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    @Override
    public List<ArticleBean> searchByTitle(String txt) {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select *, SUBSTRING([description], 0, 750) +'...' as [descripcut] from Article  where Lower(title) like ? and approved='True'";
            //Set up connection and Sql statement for Querry
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + txt.toLowerCase() + "%");
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            //Assign data to an List of Article
            while (rs.next()) {
                list.add(new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get descripcut of article*/
                        rs.getString(3),
                        /*get imagelink of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get createname of article*/
                        rs.getString(8)
                ));
            }
            return list;
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    @Override
    public List<ArticleBean> pagingSearchArticle(int index, String txt) {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "with t as(\n"
                    + "select  ArticleID, title,imageLink, SUBSTRING([description], 0, 750) +'...' as [descripcut], published,createName from Article where Lower(title) like ? and approved='True'\n"
                    + ")\n"
                    + "SELECT ArticleID,title,descripcut,imageLink, published,createName FROM (SELECT ROW_NUMBER() OVER (ORDER BY ArticleID ASC)\n"
                    + "as rownum,t.ArticleID,t.title,t.descripcut,t.imageLink , t.published, t.createName FROM t  where Lower(title) like ?) as tblHuman WHERE rownum > ? AND rownum <= ? \n"
                    + "                    \n"
                    + "                    \n"
                    + "                    ";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + txt.toLowerCase() + "%");
            statement.setString(2, "%" + txt.toLowerCase() + "%");
            statement.setInt(3, (index - 1) * 6);
            statement.setInt(4, (index) * 6);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                list.add(new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get imagelink of article*/
                        rs.getString(3),
                        /*get descripcut of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get createName of article*/
                        rs.getString(6)
                ));
            }
            return list;
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    @Override
    public int totalSearchArticle(String txt) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Article where Lower(title) like ? and approved='True'";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, "%" + txt.toLowerCase() + "%");
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);

        }
        return 0;
    }

    @Override
    public void acceptArticle(String txt) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "update Article set approved='true' where ArticleID=?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, txt);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);

        }
    }

    @Override
    public List<ArticleBean> getAllpreparearticle() {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select * from Article where approved='False'";
            //Set up connection and Sql statement for Querry
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            //Assign data to an List of Article
            while (rs.next()) {
                list.add(new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get imagelink of article*/
                        rs.getString(3),
                        /*get descripcut of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get createdName of article*/
                        rs.getString(8)
                ));
            }
            return list;
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    @Override
    public void deleteprepare(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "delete from Article where ArticleID=?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, id);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);

        }
    }

    @Override
    public ArticleBean getArticlebyid(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select * from Article  where ArticleID=?";
            //Set up connection and Sql statement for Querry
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, id);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            //Assign data to an List of Article
            while (rs.next()) {
                return new ArticleBean(
                        /*get ArticleID*/
                        rs.getInt(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get descripcut of article*/
                        rs.getString(3),
                        /*get imagelink of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get createname of article*/
                        rs.getString(8)
                );
            }

        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
        return null;
    }

    @Override
    public void editproduct(String image, String title, String description, String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "update Article set title=?,imageLink=?,description=? where ArticleID=?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, title);
            statement.setString(2, image);
            statement.setString(3, description);
            statement.setString(4, id);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);

        }
    }

    @Override
    public void addNew(String title, String des, String image, String createname) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String query = "insert into Article(title,description,imageLink,published,approved,views,createName) values(?,?,?,?,?,?,?)";
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        boolean approved = false;
        int view = 0;
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, des);
            statement.setString(3, image);
            statement.setString(4, date);
            statement.setBoolean(5, approved);
            statement.setInt(6, view);
            statement.setString(7, createname);
            statement.executeUpdate();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(conn, statement, rs);
        }
    }
}
