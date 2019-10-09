package com.yangrd.today.model;

import com.yangrd.today.utils.MD5Utils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Article
 *
 * @author yangrd
 * @date 2019/10/08
 */
@Data
@EqualsAndHashCode(of = "id")

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @Column(length = 32)
    private String id;

    @Column(length = 1000)
    private String thumb;

    @Column(length = 1000)
    private String title;

    @Column(length = 1000)
    private String resourceUrl;

    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "site_id")),
            @AttributeOverride(name = "name", column = @Column(name = "site_name")),
            @AttributeOverride(name = "icon", column = @Column(name = "site_icon"))
    })
    private SiteInfo siteInfo;

    @CreatedDate
    private LocalDateTime createdTime;


    Article() {
    }

    Article(String thumb, String title, String resourceUrl, SiteInfo siteInfo) {
        this.id = MD5Utils.getMd5(resourceUrl);
        this.thumb = thumb;
        this.title = title;
        this.resourceUrl = resourceUrl;
        this.siteInfo = siteInfo;
    }

    public static Article of(String thumb, String title, String resourceUrl, SiteInfo siteInfo) {
        return new Article(thumb, title, resourceUrl, siteInfo);
    }
}
