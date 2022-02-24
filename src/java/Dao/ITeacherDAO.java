package Dao;

import Bean.TeacherBean;
import java.util.ArrayList;

/**
 * Document: Interface ITeacherDAO
 * Create on: Feb 10, 2022, 9:14:35 PM
 * @author Duc Minh
 */
public interface ITeacherDAO {
     public ArrayList<TeacherBean> getAllTeacher();
}
