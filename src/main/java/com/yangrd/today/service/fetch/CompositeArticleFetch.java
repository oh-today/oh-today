package com.yangrd.today.service.fetch;

import com.alibaba.fastjson.JSON;
import com.yangrd.today.model.Article;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
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
        return articleFetches.stream().map(articleFetch -> {
            log.info("[{}] 开始抓取", articleFetch.getClass().getSimpleName().replace(ArticleFetch.class.getSimpleName(),""));
            Collection<Article> articles = articleFetch.fetch();
            articles.forEach(article -> log.debug("{}", JSON.toJSONString(article)));
            return articles;
        }).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
