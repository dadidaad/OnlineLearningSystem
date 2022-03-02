/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * 
 * Knowledge Bean
 * Record of change:
 * DATE         Version     AUTHOR               Description
 * 2022-02-08   1.0         Hoang Ngoc Long    First Implement
 */
package Bean;

/**
 * The class contains information attribute about Article Model All attributes
 * are declare in private ArticleID, title,  description, image,
 * createName and pulished Get set methods used to retrieve data The toString
 * method is overridden to print the data
 *
 * @author Hoang Ngoc Long
 */

public class ArticleBean {

    private int id;
    private String title;
    private String description;
    private String image;
    private String createName;
    private String pulished;
  /**
     * Initialization method
     * 
     * @param id the Id of Article. <code>java.lang.Integer</code> object
     * @param title the Name of Article. <code>java.lang.String</code> object
     * @param description the Content of Article. <code>java.lang.String</code> object
     * @param image image Article belongs. <code>java.lang.Integer</code> object
     * @param pulished date of pulished Article belongs. <code>java.lang.Integer</code> object
     */
    public ArticleBean(int id, String title, String description, String image, String pulished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.pulished = pulished;
    }
    /**
     * pulished data retrieval method
     * 
     * @return pulished. <code>java.lang.Integer</code> object
     */
    
    
    public ArticleBean(int id, String title, String description, String image,  String pulished,String createName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.createName = createName;
        this.pulished = pulished;
    }

    public String getPulished() {
        return pulished;
    }
        /**
     * Set value for pulished
     * 
     * @param pulished. <code>java.lang.Integer</code> object 
     */
    public void setPulished(String pulished) {
        this.pulished = pulished;
    }

    public ArticleBean() {
    }

     /**
     * ArticleID's data retrieval method
     * 
     * @return ArticleID. <code>java.lang.Integer</code> object
     */
    public int getId() {
        return id;
    }
     /**
     * Set value for ArticleID
     * 
     * @param ArticleID. <code>java.lang.Integer</code> object 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * title data retrieval method
     * 
     * @return title. <code>java.lang.Integer</code> object
     */
    public String getTitle() {
        return title;
    }
     /**
     * Set value for title
     * 
     * @param title. <code>java.lang.Integer</code> object 
     */
    public void setTitle(String title) {
        this.title = title;
    }
       /**
     * description data retrieval method
     * 
     * @return description. <code>java.lang.Integer</code> object
     */
    public String getDescription() {
        return description;
    }
    /**
     * Set value for description
     * 
     * @param description. <code>java.lang.Integer</code> object 
     */
    public void setDescription(String description) {
        this.description = description;
    }
     /**
     * image data retrieval method
     * 
     * @return image. <code>java.lang.Integer</code> object
     */
    public String getImage() {
        return image;
    }
   /**
     * Set value for image
     * 
     * @param image. <code>java.lang.Integer</code> object 
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * createName data retrieval method
     * 
     * @return createName. <code>java.lang.Integer</code> object
     */
    public String getCreateName() {
        return createName;
    }
    /**
     * Set value for createName
     * 
     * @param createName. <code>java.lang.Integer</code> object 
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }
     /**
     * The method used to print the attribute values of Knowledge
     * 
     * @return <code>java.lang.String</code> object
     */
    @Override
    public String toString() {
        return "ArticleBean{" + "id=" + id + ", title=" + title + ", description=" + description + ", image=" + image + ", createName=" + createName + ", pulished=" + pulished + '}';
    }

}
