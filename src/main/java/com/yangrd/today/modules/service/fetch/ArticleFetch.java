package com.yangrd.today.modules.service.fetch;

import com.yangrd.today.modules.model.Article;

import java.util.Collection;

/**
 * ArticleFeatch
 *
 * @author yangrd
 * @date 2019/10/08
 */
public interface ArticleFetch {

    /**
     * 抓取 内容
     * @return
     */
    Collection<Article> fetch();
}
