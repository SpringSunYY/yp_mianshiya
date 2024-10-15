package com.yy.mianshiya.esdao;

import com.yy.mianshiya.model.dto.question.QuestionEsDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Project: mianshiya-backend
 * @Package: com.yy.mianshiya.esdao
 * @Author: YY
 * @CreateTime: 2024-10-15  21:50
 * @Description: QuestionEsDao
 * 题目 ES 操作
 * @Version: 1.0
 */
public interface QuestionEsDao extends ElasticsearchRepository<QuestionEsDTO, Long> {
    List<QuestionEsDTO> findByUserId(Long userId);
}
