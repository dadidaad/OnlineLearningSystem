package Bean;
import java.sql.Date;

/**
 *
 * @author win
 */
public class RequestBean {
    private int requestID;
    private String studentSent;
    private String tutorGet;
    private Date createdTime;
    private String status;
    private int cost;
    private String content;
    private String imageLink;
    private int subjectID;
    private int level;
    private String title;

    public RequestBean() {
    }

    public RequestBean(String studentSent, String tutorGet, String status, int cost, String content, String imageLink, int subjectID, int level, String title) {
        this.studentSent = studentSent;
        this.tutorGet = tutorGet;
        this.status = status;
        this.cost = cost;
        this.content = content;
        this.imageLink = imageLink;
        this.subjectID = subjectID;
        this.level = level;
        this.title = title;
    }

    public RequestBean(int requestID, String tutorGet, String status, int cost, String content, String imageLink, int subjectID, int level, String title) {
        this.requestID = requestID;
        this.tutorGet = tutorGet;
        this.status = status;
        this.cost = cost;
        this.content = content;
        this.imageLink = imageLink;
        this.subjectID = subjectID;
        this.level = level;
        this.title = title;
    }

    public RequestBean(int requestID, String studentSent, String tutorGet, Date createdTime, String status, int cost, String content, String imageLink, int subjectID, int level, String title) {
        this.requestID = requestID;
        this.studentSent = studentSent;
        this.tutorGet = tutorGet;
        this.createdTime = createdTime;
        this.status = status;
        this.cost = cost;
        this.content = content;
        this.imageLink = imageLink;
        this.subjectID = subjectID;
        this.level = level;
        this.title = title;
    }

    @Override
    public String toString() {
        return "RequestBean{" + "requestID=" + requestID + ", studentSent=" + studentSent + ", tutorGet=" + tutorGet + ", createdTime=" + createdTime + ", status=" + status + ", cost=" + cost + ", content=" + content + ", imageLink=" + imageLink + ", subjectID=" + subjectID + ", level=" + level + ", title=" + title + '}';
    }

  
    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getStudentSent() {
        return studentSent;
    }

    public void setStudentSent(String studentSent) {
        this.studentSent = studentSent;
    }

    public String getTutorGet() {
        return tutorGet;
    }

    public void setTutorGet(String tutorGet) {
        this.tutorGet = tutorGet;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

  

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
