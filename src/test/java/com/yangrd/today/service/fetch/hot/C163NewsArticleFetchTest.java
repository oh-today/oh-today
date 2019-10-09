package com.yangrd.today.service.fetch.hot;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
* C163NewsArticleFetch Tester.
*
* @author yangrd
* @since 十月 9, 2019
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class C163NewsArticleFetchTest {

    @Autowired
    private C163NewsArticleFetch c163NewsArticleFetch;

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
        c163NewsArticleFetch.fetch().forEach(art-> System.out.println(JSON.toJSONString(art)));
    }


    }
