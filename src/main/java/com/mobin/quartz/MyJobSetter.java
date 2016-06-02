package com.mobin.quartz;

import org.quartz.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mobin on 2016/3/14.
 * 使用setter方法为Job中的字段添加值，这样可以不用通过JobDataMap来取值
 */
public class MyJobSetter implements Job{

    private String name;
    private int age;

    public  MyJobSetter(){}

    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getMergedJobDataMap();

        System.out.println("Instance  " + key + "  of name   "  + name + "  of age " + age );
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
