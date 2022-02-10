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
 
 * @author win
 */
public class ArticleDAO extends BaseDAO implements IArticleDAO{
     @Override
     public List<ArticleBean> getAllArticle() {
        String query = "select * from Article";
        List<ArticleBean> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
            
            //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
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
      public List<ArticleBean> gettop4() {
         String query = "select top 4 * from Article order by published desc";
        List<ArticleBean> list = new ArrayList<>();
        try {
             Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
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
}
