package com.yangrd.today.repository;

import com.yangrd.today.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * SiteRepository
 *
 * @author yangrd
 * @date 2019/10/08
 */
public interface SiteRepository extends JpaRepository<Site,Integer> {

    /**
     * 根据host查找
     * @param host
     * @return
     */
    Optional<Site> findByHost(String host);
}
