package com.yangrd.today.web;

import com.yangrd.today.model.Article;
import com.yangrd.today.model.ArticleSpec;
import com.yangrd.today.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ArticleRest
 *
 * @author yangrd
 * @date 2019/10/09
 */
@AllArgsConstructor

@RestController
@RequestMapping("/articles")
public class ArticleRest {

    private ArticleRepository repository;

    @GetMapping
    public Page<Article> findBySiteId(Integer siteId, @PageableDefault(size = 50, sort = {"createdTime"}) Pageable pageable) {
        return repository.findAll(ArticleSpec.toSpec(siteId), pageable);
    }
}
