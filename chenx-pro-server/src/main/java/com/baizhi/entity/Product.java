package com.baizhi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private String courseImg;  //课程图片
    private Integer courseType;  //课程收费
    private String brief;  //课程详情
    private String level;//课程难度等级
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;   //课程发布日期
    private Integer period;     // 课程建议的学习周期
    private Integer status;     // 课程的状态  上架  下架 售罄
    private Integer students;   // 课程报名学习的人数
    private Integer lessons;    // 课程总课时
    private Integer pubLessons;    // 课程已更新课时
    private Double price;       // 课程价格
    private Integer courseCategoryId;   // 课程所属的类别
    private Integer teacherId;      // 课程的讲师id

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseImg='" + courseImg + '\'' +
                ", courseType=" + courseType +
                ", brief='" + brief + '\'' +
                ", level='" + level + '\'' +
                ", pubDate=" + pubDate +
                ", period=" + period +
                ", status=" + status +
                ", students=" + students +
                ", lessons=" + lessons +
                ", pubLessons=" + pubLessons +
                ", price=" + price +
                ", courseCategoryId=" + courseCategoryId +
                ", teacherId=" + teacherId +
                '}';
    }

    public Product(Integer id, String name, String courseImg, Integer courseType, String brief, String level, Date pubDate, Integer period, Integer status, Integer students, Integer lessons, Integer pubLessons, Double price, Integer courseCategoryId, Integer teacherId) {
        this.id = id;
        this.name = name;
        this.courseImg = courseImg;
        this.courseType = courseType;
        this.brief = brief;
        this.level = level;
        this.pubDate = pubDate;
        this.period = period;
        this.status = status;
        this.students = students;
        this.lessons = lessons;
        this.pubLessons = pubLessons;
        this.price = price;
        this.courseCategoryId = courseCategoryId;
        this.teacherId = teacherId;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStudents() {
        return students;
    }

    public void setStudents(Integer students) {
        this.students = students;
    }

    public Integer getLessons() {
        return lessons;
    }

    public void setLessons(Integer lessons) {
        this.lessons = lessons;
    }

    public Integer getPubLessons() {
        return pubLessons;
    }

    public void setPubLessons(Integer pubLessons) {
        this.pubLessons = pubLessons;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Integer courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}

