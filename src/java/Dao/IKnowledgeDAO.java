package Dao;

import Bean.KnowledgeBean;
import java.util.ArrayList;

/**
 * Document: IKnowledgeDAO Interface
 * Create on: Feb 9, 2022, 10:10:20 PM
 * @author Doan Tu
 */
public interface IKnowledgeDAO {
    public ArrayList<KnowledgeBean> getByChapterId(int chapId);// Get all Knowledge with coresponding ChapterID
}
