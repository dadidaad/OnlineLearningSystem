/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CounterBean;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICounterViewDAO {

    public List<CounterBean> getAllCounter();

    public void insertNewRecord(CounterBean x);

    public int getTotalView();
}
