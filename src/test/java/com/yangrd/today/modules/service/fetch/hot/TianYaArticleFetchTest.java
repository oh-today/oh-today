package com.yangrd.today.modules.service.fetch.hot;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
* TianYaArticleFetch Tester.
*
* @author yangrd
* @since 十月 9, 2019
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class TianYaArticleFetchTest {

    @Autowired
    private TianYaArticleFetch tianYaArticleFetch;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: fetch()
    *
    */
    @Test
    public void testFetch() throws Exception {
        tianYaArticleFetch.fetch().forEach(art-> System.out.println(JSON.toJSONString(art)));
    }


    }
