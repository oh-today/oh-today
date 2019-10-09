package com.yangrd.today.repository;

import com.yangrd.today.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * ArticleRepository
 *
 * @author yangrd
 * @date 2019/10/09
 */
public interface ArticleRepository extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {
}
