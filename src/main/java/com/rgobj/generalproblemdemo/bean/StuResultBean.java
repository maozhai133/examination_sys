package com.rgobj.generalproblemdemo.bean;

/**
 * @author nekotaku
 * @create 2021-05-23 15:34
 */
public class StuResultBean {
    private int stu_score;
    private String stu_username;
    private String stu_finishtime;
    private int stu_questioncode;
    private String stu_questiontitle;

    public StuResultBean() {
    }



    public StuResultBean(int stu_score, String stu_username, String stu_finishtime, int stu_questioncode, String stu_questiontitle) {
        this.stu_score = stu_score;
        this.stu_username = stu_username;
        this.stu_finishtime = stu_finishtime;
        this.stu_questioncode = stu_questioncode;
        this.stu_questiontitle = stu_questiontitle;
    }

    public int getStu_score() {
        return stu_score;
    }

    public void setStu_score(int stu_score) {
        this.stu_score = stu_score;
    }

    public String getStu_username() {
        return stu_username;
    }

    public void setStu_username(String stu_username) {
        this.stu_username = stu_username;
    }

    public String getStu_finishtime() {
        return stu_finishtime;
    }

    public void setStu_finishtime(String stu_finishtime) {
        this.stu_finishtime = stu_finishtime;
    }

    public int getStu_questioncode() {
        return stu_questioncode;
    }

    public void setStu_questioncode(int stu_questioncode) {
        this.stu_questioncode = stu_questioncode;
    }

    public String getStu_questiontitle() {
        return stu_questiontitle;
    }

    public void setStu_questiontitle(String stu_questiontitle) {
        this.stu_questiontitle = stu_questiontitle;
    }

    @Override
    public String toString() {
        return "StuResultBean{" +
                "stu_score=" + stu_score +
                ", stu_username='" + stu_username + '\'' +
                ", stu_finishtime='" + stu_finishtime + '\'' +
                ", stu_questioncode=" + stu_questioncode +
                ", stu_questiontitle='" + stu_questiontitle + '\'' +
                '}';
    }
}
