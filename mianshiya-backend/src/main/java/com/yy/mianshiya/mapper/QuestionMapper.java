package com.yy.mianshiya.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.mianshiya.model.dto.question.QuestionQueryRequest;
import com.yy.mianshiya.model.entity.Question;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


/**
 * @author YY
 * @description 针对表【question(题目)】的数据库操作Mapper
 * @createDate 2024-10-07 16:18:00
 * @Entity generator.domain.Question
 */
public interface QuestionMapper extends BaseMapper<Question> {
    /**
     * 查询题目列表（包括已被删除的数据）
     */
    @Select("select * from question where updateTime >= #{minUpdateTime}")
    List<Question> listQuestionWithDelete(Date minUpdateTime);
}




