/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * CommentArticleBean Bean
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-08   1.0         Hoang Ngoc Long    First Implement
 */
package bean;

/**
 * The class contains information attribute about Knowledge Model
 * All attributes are declare String username, String name,String pulished, String content
 * Get set methods used to retrieve data
 * The toString method is overridden to print the data
 * 
 * @author Hoang Ngoc Long 
 */
public class CommentArticleBean {
    private int commentid;
    private String username;
    private String name;
    private String image;
    private String pulished;
    private String content;
    private int articleid;

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    
    

    /**
     * Initialization method
     * 
     * @param username the Id of CommentArticleBean. <code>java.lang.Integer</code> object
     * @param name the Name of CommentArticleBean. <code>java.lang.String</code> object
     * @param pulished the Content of CommentArticleBean. <code>java.lang.String</code> object
     * @param content image CommentArticleBean belongs. <code>java.lang.Integer</code> object
     * @param articleid date of pulished CommentArticleBean belongs. <code>java.lang.Integer</code> object
     * 
     */
    /**
     * ArticleID's data retrieval method
     * 
     * @return ArticleID. <code>java.lang.Integer</code> object
     */

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

 /**
     * Username's data retrieval method
     * 
     * @return Username. <code>java.lang.Integer</code> object
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Name's data retrieval method
     * 
     * @return Name. <code>java.lang.Integer</code> object
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     /**
     * pulished data retrieval method
     * 
     * @return pulished. <code>java.lang.Integer</code> object
     */
    
    public String getPulished() {
        return pulished;
    }

    public void setPulished(String pulished) {
        this.pulished = pulished;
    }

    public String getContent() {
        return content;
    }
     /**
     * pulished data retrieval method
     * 
     * @return pulished. <code>java.lang.Integer</code> object
     */
    public void setContent(String content) {
        this.content = content;
    }

    public CommentArticleBean(String username, String name, String image, String pulished, String content, int articleid) {
        this.username = username;
        this.name = name;
        this.image = image;
        this.pulished = pulished;
        this.content = content;
        this.articleid = articleid;
    }

    public CommentArticleBean( String username, String name, String image, String pulished, String content, int articleid,int commentid) {
        this.commentid = commentid;
        this.username = username;
        this.name = name;
        this.image = image;
        this.pulished = pulished;
        this.content = content;
        this.articleid = articleid;
    }


    
}
