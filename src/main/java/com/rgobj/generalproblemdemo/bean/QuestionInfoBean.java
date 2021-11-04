package com.rgobj.generalproblemdemo.bean;


import groovy.transform.ToString;

import java.util.Date;

/**
 * @author nekotaku
 * @create 2021-05-19 11:11
 */
public class QuestionInfoBean {
    private String question_title;
    private String question_author;
    private int question_code;
    private String question_time;
    private String question_type;
    private String question_username;
    private int question_totalpoints;

    public QuestionInfoBean() {
    }

    public QuestionInfoBean(String question_title, String question_author, String question_time, String question_type, String question_username, int question_totalpoints) {
        this.question_title = question_title;
        this.question_author = question_author;
        this.question_time = question_time;
        this.question_type = question_type;
        this.question_username = question_username;
        this.question_totalpoints = question_totalpoints;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getQuestion_author() {
        return question_author;
    }

    public void setQuestion_author(String question_author) {
        this.question_author = question_author;
    }

    public int getQuestion_code() {
        return question_code;
    }

    public void setQuestion_code(int question_code) {
        this.question_code = question_code;
    }

    public String getQuestion_time() {
        return question_time;
    }

    public void setQuestion_time(String question_time) {
        this.question_time = question_time;
    }


    public String getQuestion_username() {
        return question_username;
    }

    public void setQuestion_username(String question_username) {
        this.question_username = question_username;
    }

    public int getQuestion_totalpoints() {
        return question_totalpoints;
    }

    public void setQuestion_totalpoints(int question_totalpoints) {
        this.question_totalpoints = question_totalpoints;
    }

    @Override
    public String toString() {
        return "QuestionInfoBean{" +
                "question_title='" + question_title + '\'' +
                ", question_author='" + question_author + '\'' +
                ", question_code=" + question_code +
                ", question_time='" + question_time + '\'' +
                ", question_type='" + question_type + '\'' +
                ", question_username='" + question_username + '\'' +
                ", question_totalpoints=" + question_totalpoints +
                '}';
    }
}
