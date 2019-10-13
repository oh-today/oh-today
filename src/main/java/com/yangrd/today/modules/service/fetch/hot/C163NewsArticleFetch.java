package com.yangrd.today.modules.service.fetch.hot;

import com.yangrd.today.modules.model.Article;
import com.yangrd.today.modules.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * HacPaiArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class C163NewsArticleFetch extends AbstractArticleFetch {

    String url = "http://news.163.com/special/0001386F/rank_whole.html";

    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url,"Upgrade-Insecure-Requests","1");
        return doc.select("table tbody tr").stream().filter(tr-> Objects.nonNull(tr.selectFirst("td a"))).map(element -> {
            Element a = element.selectFirst("td a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
