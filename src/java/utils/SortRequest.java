/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System

 * SortRequest
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package utils;

import bean.RequestBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Document: SortRequest sort data for RequestList of Teacher role from database
 * Create on: Feb 13, 2022, 9:12:04 PM
 *
 * @author Duc Minh
 */
public class SortRequest {

    /**
     * requestListSorted method implement from IRequestDAO
     *
     * sort the request from student for teacher
     *
     * @param rqList
     * @param accUsername
     * @return requests. <code>java.util.ArrayList</code> object
     */
    public List<RequestBean> requestListSorted(List<RequestBean> rqList, String accUsername) {
//      Separate the element with star                        
        List<RequestBean> requestListWithStar = new ArrayList<>();
        List<RequestBean> requestListWithoutStar = new ArrayList<>();

        rqList.forEach(rq -> {
            if (accUsername.equals(rq.getTutorGet())) {
                requestListWithStar.add(rq);
            } else {
                requestListWithoutStar.add(rq);
            }
        });

//      Sort by Createdtime
        Collections.sort(requestListWithStar, (RequestBean rq1, RequestBean rq2) -> {
            if(rq1.getCreatedTime().after(rq2.getCreatedTime())){
                return 1;
            }
            return 0;
        });

        Collections.sort(requestListWithoutStar, (RequestBean rq1, RequestBean rq2) -> {
            if(rq1.getCreatedTime().after(rq2.getCreatedTime())){
                return 1;
            }
            return 0;
        });
        rqList.clear();
        rqList.addAll(requestListWithStar);
        rqList.addAll(requestListWithoutStar);

        return rqList;

    }

}
