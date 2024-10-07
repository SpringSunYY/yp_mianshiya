package com.yy.mianshiya.model.dto.questionBankQuestion;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建题库题目关联请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a> 
 */
@Data
public class QuestionBankQuestionAddRequest implements Serializable {

    /**
     * 题库 id
     */
    private Long questionBankId;

    /**
     * 题目 id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;
}