package Bean;

/**
 * Document: Java bean for Subject object
 * Created on: Feb 8, 2022, 8:20:03 PM
 * @author Doan Tu
 */
public class SubjectBean {
    private int subjectID;
    private String subjectName;
    private String description;
    private String subjectImage;

    public SubjectBean() {
    }

    
    public SubjectBean(int subjectID, String subjectName, String description, String subjectImage) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.description = description;
        this.subjectImage = subjectImage;
    }

    
 
    public String getSubjectImage() {
        return subjectImage;
    }

    public void setSubjectImage(String subjectImage) {
        this.subjectImage = subjectImage;
    }

    

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SubjectBean{" + "subjectID=" + subjectID + ", subjectName=" + subjectName + ", description=" + description + ", subjectImage=" + subjectImage + '}';
    }



    
}
