package com.yangrd.today.modules.service.fetch.hot;

import com.yangrd.today.modules.model.Article;
import com.yangrd.today.modules.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NewsMthArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class NewsMthArticleFetch extends AbstractArticleFetch {

    String url = "https://www.newsmth.net/nForum/mainpage?ajax";

    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url,"Upgrade-Insecure-Requests","1");
        List<Article> top10 = doc.select("#top10 li").stream().map(element -> {
            Element a = element.select("a").last();
            String href = a.absUrl("href");
            String text = element.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
        List<Article> hots = doc.select("#hotspot .topics ul li").stream().map(element -> {
            Element a = element.select("a").last();
            String href = a.absUrl("href");
            String text = element.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
        top10.addAll(hots);
        return top10;
    }
}
