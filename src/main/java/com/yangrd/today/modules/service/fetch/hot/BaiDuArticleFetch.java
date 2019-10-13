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
 * ITHomeArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class BaiDuArticleFetch extends AbstractArticleFetch {

    String url = "http://top.baidu.com/buzz?b=341&c=513&fr=topbuzz_b1";

    @Override
    public Collection<Article> fetch() {

        Map<String,String> headers = new HashMap<>(6);
        headers.put("Upgrade-Insecure-Requests","1");
        headers.put("Host", "top.baidu.com");
        Document doc = getDocument(url,headers);
        return doc.select("table tbody tr td.keyword").stream().map(element -> {
            Element a = element.selectFirst("a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
