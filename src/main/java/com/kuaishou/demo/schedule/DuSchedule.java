package com.kuaishou.demo.schedule;

import com.kuaishou.demo.common.TextMessage;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static com.kuaishou.demo.common.HtmlCommon.getDuMSG;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/29 13:15
 * </pre>
 */
@Component
public class DuSchedule {

    @Value("${webhook}")
    private String webhook;

    private Boolean isRunning = false;

    @Scheduled(cron = "${scheduleCron}", zone = "GMT+8:00")
    public void scheduleDu() {
        if (isRunning) {
            return;
        }

        isRunning = true;

        try {

            TextMessage message = new TextMessage(getDuMSG());

            HttpPost httpPost = new HttpPost(webhook);

            httpPost.addHeader("Content-Type", "application/json; charset=utf-8");

            httpPost.setEntity(new StringEntity(message.toJsonString(), StandardCharsets.UTF_8));

            HttpClients.createDefault().execute(httpPost);

        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            isRunning = false;
        }
    }
}
