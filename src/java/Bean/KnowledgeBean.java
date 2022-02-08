package Bean;

/**
 * Document: Java bean for Knowledge object
 * Created on: Feb 8, 2022, 8:25:15 PM
 * @author Doan Tu
 */
public class KnowledgeBean {
    private int knowledgeID;
    private String knowledgeName;
    private String knowledgeContent;
    private int chapterID;

    public KnowledgeBean() {
    }

    public KnowledgeBean(int knowledgeID, String knowledgeName, String knowledgeContent, int chapterID) {
        this.knowledgeID = knowledgeID;
        this.knowledgeName = knowledgeName;
        this.knowledgeContent = knowledgeContent;
        this.chapterID = chapterID;
    }

    public int getKnowledgeID() {
        return knowledgeID;
    }

    public void setKnowledgeID(int knowledgeID) {
        this.knowledgeID = knowledgeID;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public String getKnowledgeContent() {
        return knowledgeContent;
    }

    public void setKnowledgeContent(String knowledgeContent) {
        this.knowledgeContent = knowledgeContent;
    }

    public int getChapterID() {
        return chapterID;
    }

    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }

    @Override
    public String toString() {
        return "KnowledgeBean{" + "knowledgeID=" + knowledgeID + ", knowledgeName=" + knowledgeName + ", knowledgeContent=" + knowledgeContent + ", chapterID=" + chapterID + '}';
    }
    
    
}
