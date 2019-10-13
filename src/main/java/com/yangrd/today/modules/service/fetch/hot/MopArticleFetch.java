package com.yangrd.today.modules.service.fetch.hot;

import com.yangrd.today.modules.model.Article;
import com.yangrd.today.modules.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * WeiXinArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class MopArticleFetch extends AbstractArticleFetch {

    String url = "http://www.mop.com/";

    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url,"Upgrade-Insecure-Requests","1");
        return doc.select(".swiper-slide").stream().map(element -> {
            Element a = element.select("a").last();
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
