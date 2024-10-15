package com.yy.mianshiya.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mianshiya.model.dto.question.QuestionQueryRequest;
import com.yy.mianshiya.model.entity.Question;
import com.yy.mianshiya.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 题目信息服务
 *
 * @author YY
 */
public interface QuestionService extends IService<Question> {

    /**
     * 校验数据
     *
     * @param question
     * @param add      对创建的数据进行校验
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取题目信息封装
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 分页获取题目信息封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);

    /**
     * @description: 分页获取题目列表
     * @author: YY
     * @method: listQuestionByPage
     * @date: 2024/10/8 20:31
     * @param:
     * @param: questionQueryRequest
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.yy.mianshiya.model.entity.Question>
     **/
    Page<Question> listQuestionByPage(QuestionQueryRequest questionQueryRequest);

    /**
     * @description: 从 ES 查询题目
     * @author: YY
     * @method: searchFromEs
     * @date: 2024/10/15 22:09
     * @param:
     * @param: questionQueryRequest
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.yy.mianshiya.model.entity.Question>
     **/
    Page<Question> searchFromEs(QuestionQueryRequest questionQueryRequest);
}
