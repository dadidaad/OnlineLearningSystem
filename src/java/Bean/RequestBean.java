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
    private double cost;
    private String content;
    private String imageLink;
    private String subjectID;

    public RequestBean() {
    }

    public RequestBean(String studentSent, String tutorGet, Date createdTime, String status, double cost, String content, String imageLink, String subjectID) {
        this.studentSent = studentSent;
        this.tutorGet = tutorGet;
        this.createdTime = createdTime;
        this.status = status;
        this.cost = cost;
        this.content = content;
        this.imageLink = imageLink;
        this.subjectID = subjectID;
    }

    public RequestBean(int requestID, String studentSent, String tutorGet, Date createdTime, String status, double cost, String content, String imageLink, String subjectID) {
        this.requestID = requestID;
        this.studentSent = studentSent;
        this.tutorGet = tutorGet;
        this.createdTime = createdTime;
        this.status = status;
        this.cost = cost;
        this.content = content;
        this.imageLink = imageLink;
        this.subjectID = subjectID;
    }

    @Override
    public String toString() {
        return "RequestBean: " + "requestID=" + requestID + ", studentSent=" + studentSent + ", tutorGet=" + tutorGet + ", createdTime=" + createdTime + ", status=" + status + ", cost=" + cost + ", content=" + content + ", imageLink=" + imageLink + ", subjectID=" + subjectID + '}';
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
    
}
