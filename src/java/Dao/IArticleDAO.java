package Dao;

import Bean.ArticleBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public interface IArticleDAO {
      public List<ArticleBean> getAllArticle();
      public List<ArticleBean> gettop4();
}
