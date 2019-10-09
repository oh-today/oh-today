package com.yangrd.today.service.fetch.hot;

import com.yangrd.today.model.Article;
import com.yangrd.today.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * CSDNArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class CSDNArticleFetch extends AbstractArticleFetch {

    String url = "https://www.csdn.net/";

    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url,"Upgrade-Insecure-Requests","1");
        return doc.select("#feedlist_id li").stream().filter(liTag-> Objects.nonNull(liTag.selectFirst("h2 a"))).map(element -> {
            Element a = element.selectFirst("h2 a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
