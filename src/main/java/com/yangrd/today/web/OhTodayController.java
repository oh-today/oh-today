package com.yangrd.today.web;

import com.yangrd.today.model.Article;
import com.yangrd.today.model.ArticleSpec;
import com.yangrd.today.model.Site;
import com.yangrd.today.repository.ArticleRepository;
import com.yangrd.today.repository.SiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @ModelAttribute
    public void initModel(Model model) {
        model.addAttribute("sites", siteRepository.findAll());
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/site/{id}")
    public String site(@PathVariable Integer id, Model model) {
        List<Article> articles = articleRepository.findAll(ArticleSpec.toSpec(id));
        model.addAttribute("articles", articles);
        model.addAttribute("activeId", id);
        model.addAttribute("title", articles.isEmpty()?"":articles.iterator().next().getSiteInfo().getName());
        return "site";
    }

}
