package com.yangrd.today.service.fetch.hot;

import com.yangrd.today.model.Article;
import com.yangrd.today.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * SegmentfaultArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class SegmentfaultArticleFetch extends AbstractArticleFetch {

    String url = "https://segmentfault.com/hottest";

    @Override
    public Collection<Article> fetch() {
        Map<String,String> headers = new HashMap<>(6);
        headers.put("Upgrade-Insecure-Requests","1");
        Document doc = getDocument(url,headers);
        return doc.select(".news-list .news-item").stream().map(element -> {
            Elements aList = element.select("a");
            Element a = aList.stream().filter(aTag -> !aTag.attr("class").contains("news-img")).findFirst().get();
            String href = a.absUrl("href");
            String text = a.selectFirst("h4").text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
