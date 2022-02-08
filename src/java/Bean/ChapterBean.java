package Bean;

/**
 * Document: Java bean for Chapter object
 * Created on: Feb 8, 2022, 8:22:04 PM
 * @author Doan Tu
 */
public class ChapterBean {
    private int chapterID;
    private String chapterName;
    private int semester;
    private String chapterContent;
    private int subjectID;

    public ChapterBean() {
    }

    public ChapterBean(int chapterID, String chapterName, int semester, String chapterContent, int subjectID) {
        this.chapterID = chapterID;
        this.chapterName = chapterName;
        this.semester = semester;
        this.chapterContent = chapterContent;
        this.subjectID = subjectID;
    }

    public int getChapterID() {
        return chapterID;
    }

    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public String toString() {
        return "ChapterBean{" + "chapterID=" + chapterID + ", chapterName=" + chapterName + ", semester=" + semester + ", chapterContent=" + chapterContent + ", subjectID=" + subjectID + '}';
    }
    
    
}
