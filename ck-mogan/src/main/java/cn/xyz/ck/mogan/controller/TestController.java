package cn.xyz.ck.mogan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lvchenggang.
 * @date 2019/4/3 11:59
 * @see
 * @since
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello","Hello World");
        return "hello";
    }
}
