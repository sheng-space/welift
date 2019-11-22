package com.example.demo.dao;

import com.example.demo.entity.MessageTemplateExt;

public interface MessageTemplateExtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageTemplateExt record);

    int insertSelective(MessageTemplateExt record);

    MessageTemplateExt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageTemplateExt record);

    int updateByPrimaryKey(MessageTemplateExt record);
}