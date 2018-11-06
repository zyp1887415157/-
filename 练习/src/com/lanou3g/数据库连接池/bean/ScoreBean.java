package com.lanou3g.数据库连接池.bean;

public class ScoreBean {

    private int scoreId;
    private int score;
    private int courseId;
    private int stuId;


    @Override
    public String toString() {
        return "ScoreBean{" +
                "scoreId=" + scoreId +
                ", score=" + score +
                ", courseId=" + courseId +
                ", stuId=" + stuId +
                '}';
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
}
