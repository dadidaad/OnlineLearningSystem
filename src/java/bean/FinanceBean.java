/*
 * Copyright(C) 2022, FPT University.
 * OLS
 * Online Learning System
 * Finance Bean
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-11      1.0                 Danh Tinh          
 */
package bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author tinht
 */
public class FinanceBean {
    private String userGet, status, message, usetSent;
    private BigDecimal money;
    private Date time;

    public FinanceBean() {
    }

    public FinanceBean(String userGet, String status, BigDecimal money, Date time, String message, String usetSent) {
        this.userGet = userGet;
        this.status = status;
        this.message = message;
        this.usetSent = usetSent;
        this.money = money;
        this.time = time;
    }

    public String getUserGet() {
        return userGet;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getUsetSent() {
        return usetSent;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Date getTime() {
        return time;
    }

    public void setUserGet(String userGet) {
        this.userGet = userGet;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUsetSent(String usetSent) {
        this.usetSent = usetSent;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
