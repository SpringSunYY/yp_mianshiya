package com.yy.mianshiya.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.mianshiya.model.dto.questionBankQuestion.QuestionBankQuestionQueryRequest;
import com.yy.mianshiya.model.entity.QuestionBankQuestion;
import com.yy.mianshiya.model.entity.User;
import com.yy.mianshiya.model.vo.QuestionBankQuestionVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 题目题库服务
 *
 * @author YY
 */
public interface QuestionBankQuestionService extends IService<QuestionBankQuestion> {

    /**
     * 校验数据
     *
     * @param questionBankQuestion
     * @param add                  对创建的数据进行校验
     */
    void validQuestionBankQuestion(QuestionBankQuestion questionBankQuestion, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionBankQuestionQueryRequest
     * @return
     */
    QueryWrapper<QuestionBankQuestion> getQueryWrapper(QuestionBankQuestionQueryRequest questionBankQuestionQueryRequest);

    /**
     * 获取题目题库封装
     *
     * @param questionBankQuestion
     * @param request
     * @return
     */
    QuestionBankQuestionVO getQuestionBankQuestionVO(QuestionBankQuestion questionBankQuestion, HttpServletRequest request);

    /**
     * 分页获取题目题库封装
     *
     * @param questionBankQuestionPage
     * @param request
     * @return
     */
    Page<QuestionBankQuestionVO> getQuestionBankQuestionVOPage(Page<QuestionBankQuestion> questionBankQuestionPage, HttpServletRequest request);

    /**
     * @description: 批量添加题目
     * @author: YY
     * @method: batchAddQuestionsToBank
     * @date: 2024/10/16 16:55
     * @param:
     * @param: questionIdList
     * @param: questionBankId
     * @param: loginUser
     * @return: void
     **/
    public void batchAddQuestionsToBank(List<Long> questionIdList, Long questionBankId, User loginUser);

    /**
     * @description: 批量从题库移除题目
     * @author: YY
     * @method: batchRemoveQuestionsFromBank
     * @date: 2024/10/16 17:03
     * @param:
     * @param: questionIdList
     * @param: questionBankId
     * @return: void
     **/
    void batchRemoveQuestionsFromBank(List<Long> questionIdList, Long questionBankId);
}
