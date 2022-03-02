/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Interface IArticleDAO
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-08   1.0         Hoang Long   First Implement
 */
package Dao;

import Bean.ArticleBean;
import java.util.List;

/**
 * This is the interface class that declares the methods to access the data of
 * the Article object Abstract method getallAritcle used to get article with
 * corresponding ArticleID
 *
 * @author Hoang Ngoc Long
 */
public interface IArticleDAO {

    /**
     * getAllArticle method
     *
     * @return Article. <code>java.util.List</code> object
     */
    public List<ArticleBean> getAllArticle();

    /**
     * pagingAricle with coresponding index
     *
     * @return Article. <code>java.util.List</code> object
     */
    public List<ArticleBean> pagingAricle(int index);

    public List<ArticleBean> pagingSearchArticle(int index, String txt);

    /**
     * count number of article
     *
     *
     * @return numbers.
     */
    public int totalArticle();

    public int totalSearchArticle(String txt);

    /**
     * getArticleDetail with coresponding ArticleID
     *
     * @return article object
     */

    public ArticleBean getArticleDetail(int aritcle);

    /**
     * getTop4Article method
     *
     * @return Article. <code>java.util.List</code> object
     */

    public List<ArticleBean> getTop4Article();

    /**
     * searchByTitle method
     *
     * @return Article. <code>java.util.List</code> object
     */

    public List<ArticleBean> searchByTitle(String txt);

    /**
     * acceptArticle method
     *
     * @return Article. <code>java.util.List</code> object
     */

    public void acceptArticle(String txt);

    /**
     * getAllpreparearticle
     *
     * @return Article. <code>java.util.List</code> object
     */

    public List<ArticleBean> getAllpreparearticle();

    /**
     * deleteprepare
     *
     * excute method
     */

    public void deleteprepare(String id);

    /**
     * getArticleDetail with coresponding ArticleID
     *
     * @return article object
     */

    public ArticleBean getArticlebyid(String id);

    /**
     * deleteprepare
     *
     * excute method
     */
    public void editproduct(String image, String title, String description, String id);

    /**
     * deleteprepare
     *
     * excute method
     */

    public void addNew(String title, String des, String image, String createname);

}
