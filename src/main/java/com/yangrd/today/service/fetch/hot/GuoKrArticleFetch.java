package com.yangrd.today.service.fetch.hot;

import com.yangrd.today.model.Article;
import com.yangrd.today.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * DouBanArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class GuoKrArticleFetch extends AbstractArticleFetch {

    String url = "https://www.guokr.com/scientific/";

    @Override
    public Collection<Article> fetch() {
        Map<String,String> headers = new HashMap<>(6);
        headers.put("Upgrade-Insecure-Requests","1");
        headers.put("Referer", "https://www.guokr.com/scientific/");
        headers.put("Host", "www.guokr.com");
        Document doc = getDocument(url,headers);
        return doc.select("div .article").stream().filter(element -> Objects.nonNull(element.selectFirst("img"))&&!element.attr("class").contains("article-hot")).map(element -> {
            Element a = element.selectFirst("h3 a");
            String href = a.absUrl("href");
            String text = a.text();
            String thumb = element.selectFirst("img").attr("src");
            return Article.of(thumb, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
