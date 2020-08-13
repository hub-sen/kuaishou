package com.kuaishou.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/31 16:25
 * </pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {


    private int[] source = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


    @Test
    public void contextLoads() {
        System.out.println("true = " + true);
    }


    @Test
    public void test_1() {


        System.out.println("hello test");
    }
}
