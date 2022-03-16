/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bean.RequestBean;
import dao.IRequestDAO;
import dao.RequestDAO;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class RequestAcceptListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        RequestBean requestAccept = (RequestBean) session.getAttribute("requestAccept");
        if (requestAccept != null) {
            IRequestDAO db = new RequestDAO();
            db.updateRequestStatus(requestAccept.getStatus(), requestAccept.getRequestID());
        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        RequestBean requestAccept = (RequestBean) session.getAttribute("requestAccept");
        if (requestAccept != null) {
            IRequestDAO db = new RequestDAO();
            if (requestAccept.getStatus().equals("On-time")) {
                requestAccept.setStatus("Waiting");
                db.updateRequestStatus(requestAccept.getStatus(), requestAccept.getRequestID());
            }
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        RequestBean requestAccept = (RequestBean) session.getAttribute("requestAccept");
        if (requestAccept != null) {
            IRequestDAO db = new RequestDAO();
            db.updateRequestStatus(requestAccept.getStatus(), requestAccept.getRequestID());
        }
    }
}
