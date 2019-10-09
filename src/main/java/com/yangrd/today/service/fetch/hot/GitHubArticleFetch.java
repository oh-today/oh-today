package com.yangrd.today.service.fetch.hot;

import com.yangrd.today.model.Article;
import com.yangrd.today.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * ITHomeArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
//@Component
public class GitHubArticleFetch extends AbstractArticleFetch {

    String url = "https://github.com/trending";


    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url);
        return doc.select(".Box article").stream().map(element -> {
            Element a = element.selectFirst(".lh-condensed a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
