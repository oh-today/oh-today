package com.yangrd.today.modules.service.fetch;

import com.yangrd.today.modules.model.Site;
import com.yangrd.today.modules.model.SiteInfo;
import com.yangrd.today.modules.repository.SiteRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AbstractArticleFetch
 *
 * @author yangrd
 * @date 2019/10/08
 */
public abstract class AbstractArticleFetch implements ArticleFetch {

    @Autowired
    private SiteRepository siteRepository;

    private static Map<String, SiteInfo> siteInfoCache = new ConcurrentHashMap<>();

    protected Connection.Response getResponse(String url){
        try {
            return Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(5000).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Document getDocument(String url) {
        try {
            return Jsoup.connect(url).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36").timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Document getDocument(String url, Map<String, String> headers) {
        try {
            return Jsoup.connect(url).headers(headers).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36").timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected Document getDocument(String url, String header, String headerVal) {
        try {
            return Jsoup.connect(url).header(header, headerVal).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36").timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected SiteInfo findSiteInfo(String url) {
        URI uri = uri(url);
        String host = uri.getHost();
        if (siteInfoCache.containsKey(host)) {
            return siteInfoCache.get(host);
        }
        Site site = siteRepository.findByHost(host).orElseGet(() -> initSite(getSchemeHost(uri)));
        SiteInfo siteInfo = new SiteInfo(site.getId(), site.getName(), site.getIcon());
        siteInfoCache.put(host, siteInfo);
        return siteInfo;
    }

    private Site initSite(String url) {
        return siteRepository.save(fetchSite(url));
    }

    private Site fetchSite(String url) {
        Document document = getDocument(url);
        URI uri = uri(url);
        return Site.of(getSchemeHost(uri) + "/favicon.ico", document.title(), uri.getScheme(), uri.getHost(), document.title(), "");
    }

    private String getSchemeHost(URI uri) {
        return String.format("%s://%s", uri.getScheme(), uri.getHost());
    }

    private URI uri(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
