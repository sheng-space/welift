package com.example.demo.entity;

import java.util.Date;

public class Product {
    private Integer id;

    private Integer status;

    private Integer categoryId;

    private String title;

    private String intro;

    private Double aveGrade;

    private Integer praiseQty;

    private Integer browseQty;

    private Integer collectQty;

    private Integer commentQty;

    private Date auditTime;

    private Integer auditId;

    private Integer creatorId;

    private Date createTime;

    private Date updateTime;

    private Integer updateUserId;

    private Integer deleted;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Double getAveGrade() {
        return aveGrade;
    }

    public void setAveGrade(Double aveGrade) {
        this.aveGrade = aveGrade;
    }

    public Integer getPraiseQty() {
        return praiseQty;
    }

    public void setPraiseQty(Integer praiseQty) {
        this.praiseQty = praiseQty;
    }

    public Integer getBrowseQty() {
        return browseQty;
    }

    public void setBrowseQty(Integer browseQty) {
        this.browseQty = browseQty;
    }

    public Integer getCollectQty() {
        return collectQty;
    }

    public void setCollectQty(Integer collectQty) {
        this.collectQty = collectQty;
    }

    public Integer getCommentQty() {
        return commentQty;
    }

    public void setCommentQty(Integer commentQty) {
        this.commentQty = commentQty;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}