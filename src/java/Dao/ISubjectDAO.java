package Dao;

import Bean.SubjectBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Document: Interface ISubjectDAO
 * Create on: Feb 9, 2022, 9:14:35 PM
 * @author Doan Tu
 */
public interface ISubjectDAO {
    public ArrayList<SubjectBean> getAllSubject(); //Lisst all Subject from database
    public Map<Integer, String> getSubjectNames();//Lisst all and hash ID and Name of Subject from database
}
