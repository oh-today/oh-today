package com.yangrd.today.service.fetch;

import com.alibaba.fastjson.JSON;
import com.yangrd.today.model.Article;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CompositeArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */

@Value
@Slf4j

@Component
public class CompositeArticleFetch extends AbstractArticleFetch {

    private Collection<ArticleFetch> articleFetches;

    @Override
    public Collection<Article> fetch() {
        List<Article> articleList = articleFetches.stream().map(articleFetch -> {
            String fetchName = articleFetch.getClass().getSimpleName().replace(ArticleFetch.class.getSimpleName(), "");
            log.info("[{}] 开始抓取", fetchName);
            Collection<Article> articles = Collections.emptyList();
            try {
                articles = articleFetch.fetch();
            } catch (Exception e) {
                log.error("[{}] 抓取失败, 失败原因 => {}", fetchName, e.getMessage());
            }
            articles.forEach(article -> log.debug("{}", JSON.toJSONString(article)));
            return articles;
        }).flatMap(Collection::stream).collect(Collectors.toList());
        log.info("全部抓取完成");
        return articleList;
    }
}
