package org.jiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BookServiceController {
	@RequestMapping("/hello")
	public String hello(){        
        return "hello";
    }

}
