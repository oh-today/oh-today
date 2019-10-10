package com.yangrd.today.service.fetch.hot;

import com.yangrd.today.model.Article;
import com.yangrd.today.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ZhiHuArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class ZhiHuDailyArticleFetch extends AbstractArticleFetch {

    String url = "http://daily.zhihu.com/";

    @Override
    public Collection<Article> fetch() {
        Map<String,String> headers = new HashMap<>(6);
        headers.put("Upgrade-Insecure-Requests","1");
        headers.put("Referer", "https://www.zhihu.com/");
        headers.put("Host", "daily.zhihu.com");
        Document doc = getDocument(url,headers);
        return doc.select("row .box").stream().map(element -> {
            Element a = element.selectFirst("a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
