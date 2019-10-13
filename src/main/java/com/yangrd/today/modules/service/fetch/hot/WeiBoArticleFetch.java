package com.yangrd.today.modules.service.fetch.hot;

import com.yangrd.today.modules.model.Article;
import com.yangrd.today.modules.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * WeiBoArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class WeiBoArticleFetch extends AbstractArticleFetch {

    String url = "https://s.weibo.com/top/summary";

    // TODO 测试
    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url);
        return doc.select("table tbody tr").stream().map(element -> {
            Element a = element.selectFirst("td a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
