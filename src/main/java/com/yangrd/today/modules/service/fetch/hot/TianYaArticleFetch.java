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
public class TianYaArticleFetch extends AbstractArticleFetch {

    String url = "http://bbs.tianya.cn/list.jsp?item=funinfo&grade=3&order=1";

    @Override
    public Collection<Article> fetch() {
        Map<String,String> headers = new HashMap<>(6);
        headers.put("Upgrade-Insecure-Requests","1");
        headers.put("Referer", "http://bbs.tianya.cn/list.jsp?item=funinfo&grade=3&order=1");
        headers.put("Host", "bbs.tianya.cn");
        Document doc = getDocument(url,headers);
        return doc.select("table tr .td-title").stream().map(element -> {
            Element a = element.selectFirst("a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
