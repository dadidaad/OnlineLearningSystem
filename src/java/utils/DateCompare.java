/*
 * Copyright(C) 2022, FPT University.
 * OLS
 * Online Learning System
 * Date Compare
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-11      1.0                 Danh Tinh          
 */
package utils;

import bean.FinanceBean;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DateCompare {
    
    public List<FinanceBean> sortedList(List<FinanceBean>list) {
        Collections.sort(list, new Comparator<FinanceBean>() {
            @Override
            public int compare(FinanceBean rq1,FinanceBean rq2 ) {
                return -rq1.getTime().compareTo(rq2.getTime());
            }
        });
        return list;
    }
}
