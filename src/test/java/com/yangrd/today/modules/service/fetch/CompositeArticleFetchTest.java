package com.yangrd.today.modules.service.fetch;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* CompositeArticleFetch Tester.
*
* @author yangrd
* @since 十月 9, 2019
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompositeArticleFetchTest {

    @Autowired
    private CompositeArticleFetch compositeArticleFetch;

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
        compositeArticleFetch.fetch().forEach(art-> System.out.println(JSON.toJSONString(art)));
    }


    }
