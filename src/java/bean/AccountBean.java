/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * OnlineLearningSystem
 * OLS
 * AccountBean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-02-07   1.0         Duc Minh    First Implement
 */
package bean;

import dao.AccountDAO;
import dao.IAccountDAO;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Document: Java bean for Account object Created on: Feb 10, 2022, 8:20:03 PM
 *
 * @author Duc Minh
 */
public class AccountBean implements HttpSessionBindingListener {

    private String username;
    private String password;
    private String mail;
    private String avatar;
    private String displayName;
    private Date dateOfBirth;
    private boolean sex;
    private String description;
    private BigDecimal cash;
    private Date createDate;
    private String role;
    private String status;
    private boolean state;
    private String token;
    private static Map<AccountBean, HttpSession> loginedUser = new HashMap<>();

    public AccountBean() {
        //default constructor
    }

    public AccountBean(String username, String password, String mail, String avatar, String displayName, Date dateOfBirth, boolean sex, String description, BigDecimal cash, Date createDate, String role, String status, boolean state, String token) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.avatar = avatar;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.description = description;
        this.cash = cash;
        this.createDate = createDate;
        this.role = role;
        this.status = status;
        this.state = state;
        this.token = token;
    }

    @Override
    public String toString() {
        return "AccountBean{" + "username=" + username + ", password=" + password + ", mail=" + mail + ", avatar=" + avatar + ", displayName=" + displayName + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", description=" + description + ", cash=" + cash + ", createDate=" + createDate + ", role=" + role + ", status=" + status + ", state=" + state + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String isSex() {
        return !this.sex ? "male" : "female";
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setSex(String sex) {
        this.sex = !sex.equalsIgnoreCase("male");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof AccountBean) && (username != null) ? username.equals(((AccountBean) other).username) : (other == this);
    }

    @Override
    public int hashCode() {
        return (username != null) ? (this.getClass().hashCode() + username.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = loginedUser.remove(this);
        if (session != null) {
            session.invalidate();
        }
        loginedUser.put(this, event.getSession());
        IAccountDAO db = new AccountDAO();
        this.state = true;
        db.updateStateACcount(this);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        IAccountDAO db = new AccountDAO();
        this.state = false;
        db.updateStateACcount(this);
        loginedUser.remove(this);
    }

    public static int getSize() {
        return loginedUser.size();
    }
}
