package com.yangrd.today.modules.service.fetch.hot;

import com.yangrd.today.modules.model.Article;
import com.yangrd.today.modules.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * V2EXArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class V2exArticleFetch extends AbstractArticleFetch {

    String url = "https://www.v2ex.com/?tab=hot";

    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url);
        return doc.select(".item_title").stream().map(element -> {
            Element a = element.selectFirst("a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
