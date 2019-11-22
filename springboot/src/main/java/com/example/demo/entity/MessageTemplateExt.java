package com.example.demo.entity;

public class MessageTemplateExt {
    private Integer id;

    private Integer messageId;

    private String color;

    private String keyword;

    private String keywordData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeywordData() {
        return keywordData;
    }

    public void setKeywordData(String keywordData) {
        this.keywordData = keywordData;
    }
}