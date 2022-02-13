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
 * Document: KnowledgeDAO for get data for Knowledge bean from database
 * Create on: Feb 9, 2022, 8:11:23 PM
 * @author Hoang Ngoc Long
 */
public class ArticleDAO extends BaseDAO implements IArticleDAO {

    @Override
    public List<ArticleBean> getAllArticle() {
        String query = "select *, SUBSTRING([description], 0, 900) +'...' as [descripcut] from Article ";
        List<ArticleBean> list = new ArrayList<>();
        try {
            //Set up connection and Sql statement for Querry
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);

             //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
              //Assign data to an List of Article
            while (rs.next()) {
                list.add(new ArticleBean(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(9),
                        rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<ArticleBean> gettop4() {
        String query = "select top 4 * from Article order by published desc";
        List<ArticleBean> list = new ArrayList<>();
        try {
            //Set up connection and Sql statement for Querry
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
            //Assign data to an List of Article
            while (rs.next()) {
                list.add(new ArticleBean(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<ArticleBean> pagingAricle(int index) {
        List<ArticleBean> list = new ArrayList<>();
        String query = "with t as(\n"
                + "select  ArticleID, title,imageLink, SUBSTRING([description], 0, 900) +'...' as [descripcut] from Article\n"
                + ")\n"
                + "\n"
                + "SELECT ArticleID,title,descripcut,imageLink FROM (SELECT ROW_NUMBER() OVER (ORDER BY ArticleID ASC) \n"
                + "as rownum,t.ArticleID,t.title,t.descripcut,t.imageLink FROM t ) as tblHuman WHERE rownum > ? AND rownum <= ?";
        try {
            //Set up connection and Sql statement for Querry
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, (index - 1) * 6);
            statement.setInt(2, (index) * 6);
             //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
            //Assign data to an List of Article
            while (rs.next()) {
                list.add(new ArticleBean(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public int total() {
        String query = "select count(*) from Article";
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
     public ArticleBean getArticleDetail(int aritcle) {
        String query = "select * from Article where ArticleID=?";

        try {
             Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, aritcle);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new ArticleBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
