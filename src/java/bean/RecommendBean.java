
package bean;

public class RecommendBean {
    private int RecommendID;
    private String username;
    private int subjectID;
    private boolean action;
    private String description;
    private String status;
    
    public RecommendBean() {
    }

    public RecommendBean(int RecommendID, String username, int subjectID, boolean action, String description, String status) {
        this.RecommendID = RecommendID;
        this.username = username;
        this.subjectID = subjectID;
        this.action = action;
        this.description = description;
        this.status = status;
    }

    public int getRecommendID() {
        return RecommendID;
    }

    public void setRecommendID(int RecommendID) {
        this.RecommendID = RecommendID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RecommendBean{" + "RecommendID=" + RecommendID + ", username=" + username + ", subjectID=" + subjectID + ", action=" + action + ", description=" + description + ", status=" + status + '}';
    }
    
    
}
