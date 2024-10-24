package com.yy.mianshiya.job.cycle;

import cn.hutool.core.collection.CollUtil;
import com.yy.mianshiya.esdao.PostEsDao;
import com.yy.mianshiya.esdao.QuestionEsDao;
import com.yy.mianshiya.mapper.PostMapper;
import com.yy.mianshiya.mapper.QuestionMapper;
import com.yy.mianshiya.model.dto.post.PostEsDTO;
import com.yy.mianshiya.model.dto.question.QuestionEsDTO;
import com.yy.mianshiya.model.entity.Post;
import com.yy.mianshiya.model.entity.Question;
import com.yy.mianshiya.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 增量同步问题到 es
 *
 * @author YY
 */
//  取消注释开启任务
@Component
@Slf4j
public class IncSyncQuestionToEs {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private QuestionEsDao questionEsDao;

    /**
     * 每分钟执行一次
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void run() {
        // 查询近 5 分钟内的数据
        Date fiveMinutesAgoDate = new Date(new Date().getTime() - 5 * 60 * 1000L);
        List<Question> questionList = questionMapper.listQuestionWithDelete(fiveMinutesAgoDate);
        if (CollUtil.isEmpty(questionList)) {
            log.info("no inc question");
            return;
        }
        List<QuestionEsDTO> postEsDTOList = questionList.stream()
                .map(QuestionEsDTO::objToDto)
                .collect(Collectors.toList());
        final int pageSize = 500;
        int total = postEsDTOList.size();
        log.info("IncSyncPostToEs start, total {}", total);
        for (int i = 0; i < total; i += pageSize) {
            int end = Math.min(i + pageSize, total);
            log.info("sync from {} to {}", i, end);
            questionEsDao.saveAll(postEsDTOList.subList(i, end));
        }
        log.info("IncSyncPostToEs end, total {}", total);
    }
}
