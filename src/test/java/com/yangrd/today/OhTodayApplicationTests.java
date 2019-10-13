package com.yangrd.today;

import com.yangrd.today.modules.utils.MD5Utils;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
/*
@RunWith(SpringRunner.class)
@SpringBootTest*/
public class OhTodayApplicationTests {

    @Test
    public void contextLoads() throws MalformedURLException, URISyntaxException {

        URL url1 = new URL("https://github.com/tophubs/TopList/blob/master/Config/MySql.go");
        System.out.println(url1.getProtocol()+"://"+url1.getHost());
        URI uri1 = new URI("https://github.com/tophubs/TopList/blob/master/Config/MySql.go");
        System.out.println(uri1.getScheme()+uri1.getHost());
        System.out.println(MD5Utils.getMd5("https://github.com/tophubs/TopList/blob/master/Config/MySql.go").length());

    }


}
