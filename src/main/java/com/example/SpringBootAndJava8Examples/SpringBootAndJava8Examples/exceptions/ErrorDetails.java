package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.exceptions;

import java.util.Date;

public class ErrorDetails {

    private Date time;

    private String message;

    private String desc;

    public ErrorDetails(Date time, String message, String desc) {
        this.time = time;
        this.message = message;
        this.desc = desc;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
