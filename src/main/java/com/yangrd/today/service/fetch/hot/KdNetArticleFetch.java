package com.yangrd.today.service.fetch.hot;

import com.yangrd.today.model.Article;
import com.yangrd.today.service.fetch.AbstractArticleFetch;
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
public class KdNetArticleFetch extends AbstractArticleFetch {

    String url = "http://www.kdnet.net/";

    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url,"Upgrade-Insecure-Requests","1");
        return doc.select(".indexside-box-hot li").stream().map(element -> {
            Element a = element.select("a").last();
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
