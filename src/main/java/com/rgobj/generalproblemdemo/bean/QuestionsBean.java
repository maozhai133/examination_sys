package com.rgobj.generalproblemdemo.bean;

import groovy.transform.ToString;

/**
 * @author nekotaku
 * @create 2021-05-20 8:21
 */
public class QuestionsBean {
    private String questions;
    private String answer_a;
    private String answer_b;
    private String answer_c;
    private String answer_d;
    private String answer_right;
    private String questions_author;
    private int questions_code;
    private int questions_counter;
    private int questions_score;


    public QuestionsBean() {
    }

    public QuestionsBean(String questions_author, int questions_code, int questions_counter, int questions_score) {
        this.questions_author = questions_author;
        this.questions_code = questions_code;
        this.questions_counter = questions_counter;
        this.questions_score = questions_score;
    }

    public QuestionsBean(String questions, String answer_a, String answer_b, String answer_c, String answer_d, String answer_right, String questions_author, int questions_code, int questions_counter, int questions_score) {
        this.questions = questions;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.answer_right = answer_right;
        this.questions_author = questions_author;
        this.questions_code = questions_code;
        this.questions_counter = questions_counter;
        this.questions_score = questions_score;
    }

    public int getQuestions_score() {
        return questions_score;
    }

    public void setQuestions_score(int questions_score) {
        this.questions_score = questions_score;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }

    public String getAnswer_right() {
        return answer_right;
    }

    public void setAnswer_right(String answer_right) {
        this.answer_right = answer_right;
    }

    public String getQuestions_author() {
        return questions_author;
    }

    public void setQuestions_author(String questions_author) {
        this.questions_author = questions_author;
    }

    public int getQuestions_code() {
        return questions_code;
    }

    public void setQuestions_code(int questions_code) {
        this.questions_code = questions_code;
    }

    public int getQuestions_counter() {
        return questions_counter;
    }

    public void setQuestions_counter(int questions_counter) {
        this.questions_counter = questions_counter;
    }

    @Override
    public String toString() {
        return "QuestionsBean{" +
                "questions='" + questions + '\'' +
                ", answer_a='" + answer_a + '\'' +
                ", answer_b='" + answer_b + '\'' +
                ", answer_c='" + answer_c + '\'' +
                ", answer_d='" + answer_d + '\'' +
                ", answer_right='" + answer_right + '\'' +
                ", questions_author='" + questions_author + '\'' +
                ", questions_code=" + questions_code +
                ", questions_counter=" + questions_counter +
                ", questions_score=" + questions_score +
                '}';
    }
}
