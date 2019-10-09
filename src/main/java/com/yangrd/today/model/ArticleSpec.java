package com.yangrd.today.model;

import com.github.wenhao.jpa.Specifications;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

/**
 * ArticleSpec
 *
 * @author yangrd
 * @date 2019/10/09
 */
public class ArticleSpec {

    public static Specification<Article> toSpec(Integer siteId) {
        return Specifications.<Article>and().eq(Objects.nonNull(siteId), "siteInfo.id", siteId).build();
    }
}
