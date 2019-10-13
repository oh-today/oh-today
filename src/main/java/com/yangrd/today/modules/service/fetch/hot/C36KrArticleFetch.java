package com.yangrd.today.modules.service.fetch.hot;

import com.yangrd.today.modules.model.Article;
import com.yangrd.today.modules.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DouBanArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class C36KrArticleFetch extends AbstractArticleFetch {

    String url = "https://36kr.com/";

    @Override
    public Collection<Article> fetch() {
        Map<String,String> headers = new HashMap<>(6);
        headers.put("Upgrade-Insecure-Requests","1");
        headers.put("Referer", "https://36kr.com/");
        headers.put("Host", "36kr.com");
        Document doc = getDocument(url,headers);
        return doc.select(".kr-home-flow-list .kr-home-flow-item .kr-flow-article-item").stream().map(element -> {
            Element a = element.selectFirst(".article-item-info a");
            String href = a.absUrl("href");
            String text = a.text();
            //TODO thumb
//            String thumb = element.selectFirst("a img").attr("src");
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
