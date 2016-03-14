package com.mobin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.quartz.DateBuilder.*;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

/**
 * Created by Mobin on 2016/3/14.
 */
public class MySimpleTrigger {


    public static void main(String[] args) {

        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();

            Date sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").parse("2016-03-14:09:47:03");

            JobDetail jobDetail = newJob(MyJobSetter.class)
                    .withIdentity("job2", "group2")
                    .usingJobData("name", "mobin")
                    .usingJobData("age", 11)
                    .build();


      /*  SimpleTrigger trigger = (SimpleTrigger)newTrigger()
                .withIdentity("trigger1", "group2")
                .startAt(sdf) // 设定触发器的触发时间
                .forJob("job2", "group2") // identify job with name, group strings
                .build();*/

            /*SimpleTrigger trigger = (SimpleTrigger)newTrigger()
                    .withIdentity("trigger1", "group2")
                   .startNow()
                    .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(2)  //每2秒触发一次
                    .withRepeatCount(10))//共执行10次
                    .forJob("job2") // identify job with name, group strings
                    .build();*/

          /*SimpleTrigger trigger = (SimpleTrigger)newTrigger()
                    .withIdentity("trigger1", "group2")
                    .startAt(futureDate(1, IntervalUnit.MINUTE))//一分钟后将会触发一次
                    .forJob("job2", "group2") // identify job with name, group strings
                    .build();*/


            //印刷品立即触发，之后每隔5秒触发一次，直到10：06：03结束触发
           /* SimpleTrigger trigger = (SimpleTrigger)newTrigger()
                    .withIdentity("trigger1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(5)
                    .repeatForever())
                    .endAt(dateOf(10,06,03))
                    .build();*/

            SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                    .withIdentity("trigger1", "group2")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever())
                    .endAt(dateOf(10, 10, 03))   //可以不带forJob
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
