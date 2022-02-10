package Bean;

import java.sql.Date;

/**
 * Document: Java bean for Teacher's Account object
 * Created on: Feb 10, 2022, 8:25:03 PM
 * @author Duc Minh
 */
public class TeacherBean extends AccountBean{
    private String cvImg;
    private String subjectName;

    public TeacherBean() {
    }

    public TeacherBean(String cvImg, String subjectName) {
        this.cvImg = cvImg;
        this.subjectName = subjectName;
    }

    public TeacherBean(String cvImg, int subjectId, String username, String password, String mail, String avatar, String displayName, Date dateOfBirth, boolean sex, String description, int cash, Date createDate, String role, String status, boolean state) {
        super(username, password, mail, avatar, displayName, dateOfBirth, sex, description, cash, createDate, role, status, state);
        this.cvImg = cvImg;
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return super.toString() + "TeacherBean{" + "cvImg=" + cvImg + ", subjectId=" + subjectName + '}';
    }

    public String getCvImg() {
        return cvImg;
    }

    public void setCvImg(String cvImg) {
        this.cvImg = cvImg;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    
    
    
}
