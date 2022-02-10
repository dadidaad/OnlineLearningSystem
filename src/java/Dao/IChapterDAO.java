package Dao;

import Bean.ChapterBean;
import java.util.ArrayList;

/**
 *Document: Interface IChapterDAO
 * Create on: Feb 10, 2022, 10:13:06 PM
 * @author Doan Tu
 */
public interface IChapterDAO {
    public ArrayList<ChapterBean> getBySubId(int subId); //Get All Chapter with coresponding SubjectID
}
