package com.mobin.quartz;

import org.quartz.*;

/**
 * Created by Mobin on 2016/3/13.
 * 使用JobMap存储数据
 */
public class HelloJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("The key is  "+key+"  ,and name is  "+dataMap.getString("name")+" and age is  "+dataMap.getInt("age"));
    }
}
