package com.kuaishou.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static com.kuaishou.demo.common.HtmlCommon.getDuMSG;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/15 17:52
 * </pre>
 */
@Controller
public class DuController {

    @GetMapping("du")
    @ResponseBody
    public ModelAndView du() throws Exception {
        return new ModelAndView("du", "_du", getDuMSG());
    }


}
