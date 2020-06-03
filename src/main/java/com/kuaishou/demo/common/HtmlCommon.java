package com.kuaishou.demo.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/29 13:16
 * </pre>
 */
public class HtmlCommon {

    /**
     * 地址
     */
    private static final String URL = "http://www.nows.fun/";

    /**
     * 正则
     */
    private static final String DU_REG = ">(.*?)</span>";

    public static String getDuMSG() throws Exception {
        // 获取html
        String html = getHtml(URL);
        // 获取文案
        Matcher matcher = Pattern.compile(DU_REG).matcher(html);
        String du = "刷新后重试";

        if (matcher.find()) {
            du = matcher.group();
            du = du.substring(1, du.indexOf("</span>"));
        }

        return du;
    }

    /**
     * 获取HTML内容
     *
     * @param urlStr
     * @return
     * @throws Exception
     */
    public static String getHtml(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        StringBuilder sb = new StringBuilder();
        while (null != (line = br.readLine())) {
            sb.append(line, 0, line.length()).append('\n');
        }
        br.close();
        in.close();
        return sb.toString();
    }
}
