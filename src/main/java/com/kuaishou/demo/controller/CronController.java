package com.kuaishou.demo.controller;

import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/23 17:08
 * </pre>
 */
@Controller
public class CronController {

    @GetMapping("toCron")
    @ResponseBody
    public ModelAndView toCron() {

        return new ModelAndView("cron");
    }

    @GetMapping("cron")
    @ResponseBody
    public List<String> cron(@RequestParam("cron") String cron, @RequestParam("numTimes") Integer numTimes) {
        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        try {
            // 秒 分钟 小时 日 月 星期 年
            cronTrigger.setCronExpression(cron);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Date> dates = TriggerUtils.computeFireTimes(cronTrigger, null, numTimes);

        List<String> cronStr = dates.stream()
                .map(date -> String.format("%tF %tT", date, date))
                .collect(Collectors.toList());

        return cronStr;
    }


}
