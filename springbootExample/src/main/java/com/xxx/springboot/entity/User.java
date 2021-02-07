package com.xxx.springboot.entity;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
