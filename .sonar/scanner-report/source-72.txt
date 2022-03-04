/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * SortRequest
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package Utils;

import Bean.RequestBean;
import Dao.RequestDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *Document: SortRequest sort data for RequestList of Teacher role from database
 * Create on: Feb 13, 2022, 9:12:04 PM
 * @author Duc Minh
 */
public class SortRequest {
    
    
    /**
     * requestListSorted method implement from IRequestDAO
     * 
     * sort the request from student for teacher
     * @return requests. <code>java.util.ArrayList</code> object  
     */
    public ArrayList<RequestBean> requestListSorted (ArrayList<RequestBean> rqList, String accUsername){
//      Separate the element with star                        
            ArrayList<RequestBean> requestListWithStar = new ArrayList<>();
            ArrayList<RequestBean> requestListWithoutStar = new ArrayList<>();
            
            for(RequestBean rq : rqList){
                if(accUsername.equals(rq.getTutorGet())){
                    requestListWithStar.add(rq);
                }else{
                    requestListWithoutStar.add(rq);
                }
            }
        
//      Sort by Createdtime
        Collections.sort(requestListWithStar, new Comparator<RequestBean>() {
            @Override
            public int compare(RequestBean rq1,RequestBean rq2 ) {
                return -rq1.getCreatedTime().compareTo(rq2.getCreatedTime());
            }
        });
        
        Collections.sort(requestListWithoutStar, new Comparator<RequestBean>() {
            @Override
            public int compare(RequestBean rq1,RequestBean rq2 ) {
                return -rq1.getCreatedTime().compareTo(rq2.getCreatedTime());
            }
        });
        rqList.clear();
        rqList.addAll(requestListWithStar);     
        rqList.addAll(requestListWithoutStar);
        
        return rqList;
    
    }
    
}
