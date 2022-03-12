/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author tinht
 */
public class ReportBean {
    int id;
    String userSent, userReported, message;

    public ReportBean() {
    }

    
    
    public ReportBean(int id, String userSent, String userReported, String message) {
        this.id = id;
        this.userSent = userSent;
        this.userReported = userReported;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getUserSent() {
        return userSent;
    }

    public String getUserReported() {
        return userReported;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserSent(String userSent) {
        this.userSent = userSent;
    }

    public void setUserReported(String userReported) {
        this.userReported = userReported;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
