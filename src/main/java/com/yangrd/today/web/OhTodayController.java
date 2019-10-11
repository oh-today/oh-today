package com.yangrd.today.web;

import com.yangrd.today.repository.ArticleRepository;
import com.yangrd.today.repository.SiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * OhTodayController
 *
 * @author yangrd
 * @date 2019/10/10
 */
@AllArgsConstructor

@Controller
public class OhTodayController {

    private SiteRepository siteRepository;

    private ArticleRepository articleRepository;


}
