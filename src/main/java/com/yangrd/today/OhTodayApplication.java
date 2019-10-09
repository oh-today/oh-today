package com.yangrd.today;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * @author yangrd
 * @date 2019/10/08
 */
@EnableJpaAuditing
@SpringBootApplication
public class OhTodayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OhTodayApplication.class, args);
    }

}
