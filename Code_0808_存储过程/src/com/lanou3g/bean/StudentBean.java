package com.lanou3g.bean;

import java.sql.Date;
import java.util.List;

public class StudentBean {
    private int stuId;
    private String stuName;
    private Date birthday;
    private String stuGender;
    private List<ScoreBean> scoreBeans;


    @Override
    public String toString() {
        return "StudentBean{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", birthday=" + birthday +
                ", stuGender='" + stuGender + '\'' +
                ", scoreBeans=" + scoreBeans +
                '}' + "\n";
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public List<ScoreBean> getScoreBeans() {
        return scoreBeans;
    }

    public void setScoreBeans(List<ScoreBean> scoreBeans) {
        this.scoreBeans = scoreBeans;
    }
}
