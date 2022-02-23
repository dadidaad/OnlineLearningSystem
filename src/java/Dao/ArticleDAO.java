/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * KnowledgeDAO 
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-10   1.0         Hoang Ngoc Long    First Implement
 */
package Dao;

import Bean.ArticleBean;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Document: ArticleDAO for get data for Article bean from database Create on:
 * Feb 9, 2022, 8:11:23 PM
 *
 * @author Hoang Ngoc Long
 */
public class ArticleDAO extends BaseDAO implements IArticleDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    /**
     * getAllArticle method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    @Override
    public List<ArticleBean> getAllArticle() {
        List<ArticleBean> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select *, SUBSTRING([description], 0, 750) +'...' as [descripcut] from Article ";
            con = new BaseDAO().getConnection();
            ps = con.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
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
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(con, ps, rs);
        }
        return null;
    }

    /**
     * getAllMovie following paging method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    public List<ArticleBean> pagingAricle(int index) {
        List<ArticleBean> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "with t as(\n"
                    + "select  ArticleID, title,imageLink, SUBSTRING([description], 0, 750) +'...' as [descripcut], published from Article\n"
                    + ")\n"
                    + "SELECT ArticleID,title,descripcut,imageLink, published FROM (SELECT ROW_NUMBER() OVER (ORDER BY ArticleID ASC)\n"
                    + "as rownum,t.ArticleID,t.title,t.descripcut,t.imageLink , t.published FROM t ) as tblHuman WHERE rownum > ? AND rownum <= ?";
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, (index - 1) * 6);
            statement.setInt(2, (index) * 6);
            /*Query and save in ResultSet*/
            ResultSet rs = statement.executeQuery();
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
                        rs.getString(5)
                ));
            }
            return list;
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(con, ps, rs);
        }
        return null;
    }

    /**
     * count number of article following paging method implement from
     * IArticleDAO
     *
     *
     * @return numbers.
     */
    public int totalArticle() {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Article";
            con = new BaseDAO().getConnection();
            ps = con.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(con, ps, rs);

        }
        return 0;
    }

    /**
     * getArticleDetail method implement from IArticleDAO
     *
     * @param ArticleID of the article. <code>java.lang.Integer</code> object
     * @return article object
     */
    public ArticleBean getArticleDetail(int aritcle) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select ArticleID,title,description,imageLink,published from Article where ArticleID=?";
            con = new BaseDAO().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, aritcle);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
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
                        rs.getString(5));
            }
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(con, ps, rs);
        }
        return null;
    }

    /**
     * getTop4Article newest method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    @Override
    public List<ArticleBean> getTop4Article() {
        List<ArticleBean> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select top 4 * from Article order by published desc";
            //Set up connection and Sql statement for Querry
            con = new BaseDAO().getConnection();
            ps = con.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();;
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
                        rs.getString(5)
                ));
            }
            return list;
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(con, ps, rs);
        }
        return null;
    }

    @Override
    public List<ArticleBean> searchByTitle(String txt) {
        List<ArticleBean> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select *, SUBSTRING([description], 0, 750) +'...' as [descripcut] from Article  where Lower(title) like ?";
            //Set up connection and Sql statement for Querry
            con = new BaseDAO().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + txt.toLowerCase() + "%");
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();;
            //Assign data to an List of Article
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
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(con, ps, rs);
        }
        return null;
    }

    @Override
    public List<ArticleBean> pagingSearchArticle(int index, String txt) {
        List<ArticleBean> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "with t as(\n"
                    + "select  ArticleID, title,imageLink, SUBSTRING([description], 0, 750) +'...' as [descripcut], published from Article where Lower(title) like ?\n"
                    + ")\n"
                    + "SELECT ArticleID,title,descripcut,imageLink, published FROM (SELECT ROW_NUMBER() OVER (ORDER BY ArticleID ASC)\n"
                    + "as rownum,t.ArticleID,t.title,t.descripcut,t.imageLink , t.published FROM t  where Lower(title) like ?) as tblHuman WHERE rownum > ? AND rownum <= ?\n"
                    + "                    \n"
                    + "                    \n"
                    + "                    ";
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%" + txt.toLowerCase() + "%");
             statement.setString(2, "%" + txt.toLowerCase() + "%");
            statement.setInt(3, (index - 1) * 6);
            statement.setInt(4, (index) * 6);
            /*Query and save in ResultSet*/
            ResultSet rs = statement.executeQuery();
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
                        rs.getString(5)
                ));
            }
            return list;
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(con, ps, rs);
        }
        return null;
    }

    @Override
    public int totalSearchArticle(String txt) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Article where Lower(title) like ?";
            con = new BaseDAO().getConnection();
            ps = con.prepareStatement(query);
            /*Query and save in ResultSet*/
            ps.setString(1, "%" + txt.toLowerCase() + "%");
            rs = ps.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            BaseDAO.close(con, ps, rs);

        }
        return 0;
    }

}
