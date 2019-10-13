package com.yangrd.today.modules.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

/**
 * Site
 *
 * @author yangrd
 * @date 2019/10/08
 */
@Data
@EqualsAndHashCode(callSuper = true)


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Site extends AbstractPersistable<Integer> {

    private String icon;

    private String name;

    private String scheme;

    private String host;

    private String description;

    private String bgImg;

    @CreatedDate
    private LocalDateTime createdTime;

    private Site(String icon, String name, String scheme, String host, String description, String bgImg) {
        this.icon = icon;
        this.name = name;
        this.scheme= scheme;
        this.host = host;
        this.description = description;
        this.bgImg = bgImg;
    }

    Site() {

    }

    public static Site of(String icon, String name,  String scheme, String host, String description, String bgImg) {
        return new Site(icon, name, scheme, host, description, bgImg);
    }
}
