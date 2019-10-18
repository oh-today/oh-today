package com.yangrd.today.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CustomErrorController
 *
 * @author yangrd
 * @date 2019/10/18
 */
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(){
        return "forward:/index.html";

    }

    @Override
    public String getErrorPath() {
        return "/";
    }
}
