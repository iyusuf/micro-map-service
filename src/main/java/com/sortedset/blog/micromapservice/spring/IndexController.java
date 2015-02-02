package com.sortedset.blog.micromapservice.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class IndexController {

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/", method = RequestMethod.GET)	
    @ResponseBody
    public String showIndex() {
        return "Hello world from Spring! Index controller!";
    }

}