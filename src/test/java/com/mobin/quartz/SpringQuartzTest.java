package com.mobin.quartz;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mobin on 2016/3/14.
 */
public class SpringQuartzTest {
    public static void main(String[] args) {
        //初始化AppplicationContext，调度器被启动
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }




}
