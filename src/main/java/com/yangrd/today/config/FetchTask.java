package com.yangrd.today.config;

import com.yangrd.today.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Task
 *
 * @author yangrd
 * @date 2019/10/09
 */
@AllArgsConstructor

@Configuration
public class FetchTask {

    private ArticleService articleService;

    /**
     * 十分钟执行一次
     */
    @Scheduled(fixedDelay = 600000)
    public void fetchJob() {
        articleService.pushArticles();
    }
}
