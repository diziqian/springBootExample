package com.demo.springboot.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_test")
public class User {
	private Integer userId;
    private String userName;
    private Boolean sex;
    private String createdTime;
    
    public User(Integer userId, String userName, Boolean sex, String createdTime) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.createdTime = createdTime;
    }
    
    public User() {
        super();
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "userName", nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "sex", nullable = false)
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Column(name = "created_time", nullable = false)
    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
    	if(null == createdTime) {
    		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		this.createdTime = form.format(new Date());
    	}
    	else {
    		this.createdTime = createdTime;
    	}
    }
    
    @Override
    public String toString() {
        return "User [id=" + userId + ", userName=" + userName + ", sex=" + sex + ", createdTime=" + createdTime
       + "]";
    }
}
