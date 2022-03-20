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
import bean.CommentArticleBean;
import static dao.BaseDAO.getConnection;
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
 * Document: ArticleDAO for get data for Article bean from database Create on:
 * Feb 9, 2022, 8:11:23 PM
 *
 * @author Hoang Ngoc Long
 */
public class ArticleDAO extends BaseDAO implements IArticleDAO {

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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * getAllMovie following paging method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    @Override
    public List<ArticleBean> pagingAricle(int index) {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "with t as(\n"
                    + "                    select  ArticleID, title,imageLink, SUBSTRING([description], 0, 750) +'...' as [descripcut], published, createName, views  from Article where approved='True'\n"
                    + "                    )\n"
                    + "                    SELECT ArticleID,title,descripcut,imageLink, published,createName,views FROM (SELECT ROW_NUMBER() OVER (ORDER BY ArticleID ASC)\n"
                    + "                    as rownum,t.ArticleID,t.title,t.descripcut,t.imageLink , t.published,t.createName,t.views  FROM t ) as tblHuman WHERE rownum > ? AND rownum <= ?";
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
                        rs.getString(6),
                        rs.getInt(7)
                ));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * count number of article following paging method implement from
     * IArticleDAO
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
        return 0;
    }

    /**
     * getArticleDetail method implement from IArticleDAO
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * searchByTitle newest method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * pagingSearchArticle newest method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * totalSearchArticle newest method implement from IArticleDAO
     *
     *
     * @return int count.
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
        return 0;
    }

    /**
     * acceptArticle newest method implement from IArticleDAO
     *
     *
     *
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
    }

    /**
     * getAllpreparearticle newest method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * deleteprepare newest method implement from IArticleDAO
     *
     *
     *
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
    }

    /**
     * getAllpreparearticle newest method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return null;
    }

    /**
     * editproduct newest method implement from IArticleDAO
     *
     *
     *
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
    }

    /**
     * addNew newest method implement from IArticleDAO
     *
     *
     *
     */
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
    }

    /**
     * like newest method implement from IArticleDAO
     *
     *
     *
     */
    @Override
    public void like(String uid, String aid) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "insert into Favorite_Article values(?,?)";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, uid);
            statement.setString(2, aid);

            rs = statement.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }

    }

    /**
     * getFavor newest method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    @Override
    public List<ArticleBean> getFavor(String id) {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select  a.*,  SUBSTRING(a.[description], 0, 750),f.Username  from Favorite_Article f\n"
                    + " join Article a on a.ArticleID= f.ArticleID\n"
                    + " where f.Username like ?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + id + "%");
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
                        rs.getString(9),
                        /*get descripcut of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get createName of article*/
                        rs.getString(8)
                ));
            }
            return list;
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * deleteFavor newest method implement from IArticleDAO
     *
     *
     *
     */
    @Override
    public void deleteFavor(String username, String article) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "delete from Favorite_Article where Username like ? and ArticleID  like ?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, "%" + username + "%");
            statement.setString(2, "%" + article + "%");
            rs = statement.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
    }

    /**
     * pagingManager method implement from IArticleDAO
     *
     *
     * @return article. <code>java.util.List</code> object
     */
    @Override
    public List<ArticleBean> pagingManager(int index) {
        List<ArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "with t as(\n"
                    + "select  ArticleID, title,imageLink, description , published, createName  from Article where approved='True'\n"
                    + ")\n"
                    + "SELECT ArticleID,title,description,imageLink, published,createName FROM (SELECT ROW_NUMBER() OVER (ORDER BY ArticleID ASC)\n"
                    + "as rownum,t.ArticleID,t.title,t.description,t.imageLink , t.published,t.createName  FROM t ) as tblHuman WHERE rownum > ? AND rownum <= ? ";
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    /**
     * getArticleLike newest method implement from IArticleDAO
     *
     *
     * return false
     */
    @Override
    public boolean getArticleLike(String username, String article) {
        boolean check = true;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Favorite_Article where Username like ? and ArticleID  like ?";
            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet*/
            statement.setString(1, "%" + username + "%");
            statement.setString(2, "%" + article + "%");

            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            while (rs.next()) {
                check = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return check;
    }

    /**
     * getview newest method implement from IArticleDAO
     *
     *
     *
     */
    @Override
    public void getview(int id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "update Article set views=views+1 where ArticleID=?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setInt(1, id);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
    }

    @Override
    public List<CommentArticleBean> getAllComment(int id) {
        List<CommentArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select a.Username, a.DisplayName,a.Avatar,f.commentdate,f.comment,f.ArticleID,f.feedbackId\n"
                    + "from Account a join Feedback_Article f on a.Username=f.username and  f.ArticleID=? order by f.commentdate desc";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setInt(1, id);
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                list.add(new CommentArticleBean(
                        /*get ArticleID*/
                        rs.getString(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get descripcut of article*/
                        rs.getString(3),
                        /*get imagelink of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get published of article*/
                        rs.getInt(6),
                        rs.getInt(7)
                ));
            }
            return list;
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    @Override
    public void AddNewComment(String username, String articleid, String content) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String query = "insert into Feedback_Article(username,ArticleID,comment,commentdate,ban) values(?,?,?,?,'False')";
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, articleid);
            statement.setString(3, content);
            statement.setString(4, date);
            statement.executeUpdate();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
    }

    @Override
    public int totalcomment() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Feedback_Article";
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
        return 0;
    }

    @Override
    public int totalview() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select SUM(views) from Article";
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
        return 0;
    }

    /**
     * getArticleLike newest method implement from IArticleDAO
     *
     *
     * return false
     */
    @Override
    public boolean checkArticleUpdateCreate(String title) {
        boolean check = true;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Querry*/
            conn = getConnection();
            String sql = "select * from Article where title like ?";
            statement = conn.prepareStatement(sql);
            /*Query and save in ResultSet*/
            statement.setString(1, title);
            /*Querry and save in ResultSet*/
            rs = statement.executeQuery();

            while (rs.next()) {
                check = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return check;
    }

    @Override
    public void deleteComment(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "delete from Feedback_Article where feedbackId=?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, id);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
    }

    @Override
    public int getArticleID(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select ArticleID  from Feedback_Article where feedbackId=?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, id);
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
        return 0;
    }

    @Override
    public List<CommentArticleBean> pagingcomment(String articlid, int index) {
        List<CommentArticleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "with t as(SELECT feedbackId,username,ArticleID, comment,commentdate,ban FROM (SELECT ROW_NUMBER() \n"
                    + "OVER (ORDER BY commentdate desc) as rownum,p.feedbackId,p.username,p.ArticleID,p.comment,p.commentdate,p.ban \n"
                    + "FROM Feedback_Article p where p.ArticleID=?) as tblHuman WHERE rownum > ? AND rownum <=? )\n"
                    + "select a.Username, a.DisplayName,a.Avatar,t.commentdate,t.comment,t.ArticleID,t.feedbackId\n"
                    + "     from Account a join t on a.Username=t.username ";
            statement = conn.prepareStatement(query);
             statement.setString(1, articlid);
            statement.setInt(1, (index - 1) * 6);
            statement.setInt(2, (index) * 6);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                list.add(new CommentArticleBean(
                        /*get ArticleID*/
                        rs.getString(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get descripcut of article*/
                        rs.getString(3),
                        /*get imagelink of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get published of article*/
                        rs.getInt(6),
                        rs.getInt(7)
                ));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return Collections.emptyList();
    }

    @Override
    public int totalview(String articleid) {
         Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Feedback_Article where ArticleID=?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            /*Query and save in ResultSet*/
            statement.setString(1, articleid);
            rs = statement.executeQuery();
            /*Assign data to an List of Article*/
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);

        }
        return 0;
    }

    @Override
    public CommentArticleBean getComment(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select a.Username, a.DisplayName,a.Avatar,t.commentdate,t.comment,t.ArticleID,t.feedbackId\n" +
"  from Account a join Feedback_Article t on a.Username=t.username where t.feedbackId = ?";
            //Set up connection and Sql statement for Querry
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, id);
            /*Query and save in ResultSet*/
            rs = statement.executeQuery();
            //Assign data to an List of Article
            while (rs.next()) {
                return new CommentArticleBean(
                         /*get ArticleID*/
                        rs.getString(1),
                        /*get title of article*/
                        rs.getString(2),
                        /*get descripcut of article*/
                        rs.getString(3),
                        /*get imagelink of article*/
                        rs.getString(4),
                        /*get published of article*/
                        rs.getString(5),
                        /*get published of article*/
                        rs.getInt(6),
                        rs.getInt(7)
                );
            }

        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            ArticleDAO.close(conn, statement, rs);
        }
        return null;
    }

}
