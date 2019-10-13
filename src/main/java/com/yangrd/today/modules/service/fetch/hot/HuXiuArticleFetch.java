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
public class HuXiuArticleFetch extends AbstractArticleFetch {

    String url = "https://www.huxiu.com/article";

    @Override
    public Collection<Article> fetch() {
        Map<String,String> headers = new HashMap<>(6);
        headers.put("Upgrade-Insecure-Requests","1");
        headers.put("Referer", "https://www.huxiu.com/");
        headers.put("Host", "www.guokr.com");
        Document doc = getDocument(url,headers);
        return doc.select(".article-items .article-item").stream().map(element -> {
            Element a = element.selectFirst("a");
            String href = a.absUrl("href");
            String text = element.selectFirst("h5").text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
