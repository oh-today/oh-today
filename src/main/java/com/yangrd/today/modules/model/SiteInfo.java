package com.yangrd.today.modules.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * SiteInfo
 *
 * @author yangrd
 * @date 2019/10/08
 */
@Embeddable

@AllArgsConstructor
@Getter
public class SiteInfo {

    private Integer id;

    private String name;

    private String icon;

    SiteInfo() {
    }
}
