package com.yangrd.today.modules.service.fetch;

import com.alibaba.fastjson.JSON;
import com.yangrd.today.modules.model.Article;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * CompositeArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@AllArgsConstructor
@Slf4j

@Component
public class CompositeArticleFetch extends AbstractArticleFetch {

    private Collection<ArticleFetch> articleFetches;

    @Override
    public Collection<Article> fetch() {
        return articleFetches.stream().map(articleFetch -> {
            String fetchName = articleFetch.getClass().getSimpleName().replace(ArticleFetch.class.getSimpleName(), "");
            Collection<Article> articles = Collections.emptyList();
            try {
                articles = articleFetch.fetch();
                log.info("[{}] 已抓取", fetchName);
            } catch (RuntimeException e) {
                log.error("[{}] 抓取异常 异常类型:{}", fetchName, e.getClass());
            }
            articles.forEach(article -> log.debug("{}", JSON.toJSONString(article)));
            return articles;
        }).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
