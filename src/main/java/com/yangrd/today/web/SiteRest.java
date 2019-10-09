package com.yangrd.today.web;

import com.yangrd.today.model.Site;
import com.yangrd.today.repository.SiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SiteRest
 *
 * @author yangrd
 * @date 2019/10/09
 */
@AllArgsConstructor

@RestController
@RequestMapping("/sites")
public class SiteRest {

    private SiteRepository repository;

    @GetMapping
    public Page<Site> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }
}
