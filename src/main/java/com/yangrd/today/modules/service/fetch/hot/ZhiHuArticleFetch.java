package com.yangrd.today.modules.service.fetch.hot;

import com.yangrd.today.modules.model.Article;
import com.yangrd.today.modules.service.fetch.AbstractArticleFetch;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * ZhiHuArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class ZhiHuArticleFetch extends AbstractArticleFetch {

    String url = "https://www.zhihu.com/hot";

    @Override
    public Collection<Article> fetch() {
        Document doc = getDocument(url,"Cookie","_zap=09ee8132-fd2b-43d3-9562-9d53a41a4ef5; d_c0=\"AGDv-acVoQ-PTvS01pG8OiR9v_9niR11ukg=|1561288241\"; capsion_ticket=\"2|1:0|10:1561288248|14:capsion_ticket|44:NjE1ZTMxMjcxYjlhNGJkMjk5OGU4NTRlNDdkZTJhNzk=|7aefc35b3dfd27b74a087dd1d15e7a6bb9bf5c6cdbe8471bc20008feb67e7a9f\"; z_c0=\"2|1:0|10:1561288250|4:z_c0|92:Mi4xeGZsekFBQUFBQUFBWU9fNXB4V2hEeVlBQUFCZ0FsVk5PcXo4WFFBNWFFRnhYX2h0ZFZpWTQ5T3dDMGh5ZTV1bjB3|0cee5ae41ff7053a1e39d96df2450077d37cc9924b337584cf006028b0a02f30\"; q_c1=ae65e92b2bbf49e58dee5b2b29e1ffb3|1561288383000|1561288383000; tgw_l7_route=f2979fdd289e2265b2f12e4f4a478330; _xsrf=f8139fd6-b026-4f01-b860-fe219aa63543; tst=h; tshl=");
        return doc.select(".HotList-list .HotItem-content").stream().map(element -> {
            Element a = element.selectFirst("a");
            String href = a.absUrl("href");
            String text = a.text();
            return Article.of(null, text, href, findSiteInfo(url));
        }).collect(Collectors.toList());
    }
}
