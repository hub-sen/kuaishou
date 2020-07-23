package com.kuaishou.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/23 16:19
 * </pre>
 */
@Controller
public class CountdownController {
    @GetMapping("countdown")
    @ResponseBody
    public ModelAndView countdown() {
        return new ModelAndView("countdown");
    }

}
