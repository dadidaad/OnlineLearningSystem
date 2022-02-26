/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.ConstantBean;
import java.util.ArrayList;

/**
 *
 * @author Phong Vu
 */
public interface IConstantDAO {
    public ArrayList<ConstantBean> getAllConstant();
    public ArrayList<ConstantBean> getByConstantName(String constantName);
    public ArrayList<ConstantBean> getBySignOrConvention(String sign);
    public ArrayList<ConstantBean> getByNameAndSign(String name, String sign);
}
