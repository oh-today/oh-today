package com.yangrd.today.service;

import com.yangrd.today.model.Article;
import com.yangrd.today.repository.ArticleRepository;
import com.yangrd.today.service.fetch.ArticleFetch;
import com.yangrd.today.service.fetch.CompositeArticleFetch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * ArticleService
 *
 * @author yangrd
 * @date 2019/10/09
 */
@AllArgsConstructor

@Transactional(rollbackFor = Exception.class)
@Service
public class ArticleService {

    private ArticleFetch articleFetch;

    private ArticleRepository repository;

    public void fetch2Save(){
        Collection<Article> articles = articleFetch.fetch();
        repository.saveAll(articles);
    }

}
