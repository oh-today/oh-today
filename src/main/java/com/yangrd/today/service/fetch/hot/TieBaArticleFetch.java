package com.yangrd.today.service.fetch.hot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yangrd.today.model.Article;
import com.yangrd.today.service.fetch.AbstractArticleFetch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TieBaArticleFetch
 *
 * @author yangrd
 * @date 2019/10/09
 */
@Component
public class TieBaArticleFetch extends AbstractArticleFetch {

    String url = "http://tieba.baidu.com/hottopic/browse/topicList";

    @Override
    public Collection<Article> fetch() {
        String body = getResponse(url).body();
        JSONObject jsonObject = JSONObject.parseObject(body);
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONObject("bang_topic").getJSONArray("topic_list");
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject topic = jsonArray.getJSONObject(i);
            articles.add(Article.of(topic.getString("topic_pic"), topic.getString("topic_name"), topic.getString("topic_url"), findSiteInfo(url)));
        }
        return articles;
    }
}
