package com.mobin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Mobin on 2016/3/13.
 */
public class QuartzTest {
      public static  void main(String[] args){
          try {
              Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
              scheduler.start();

              JobDetail job = newJob(HelloJob.class)
                      .withIdentity("job1","group1")
                      .usingJobData("age",11)
                      .usingJobData("name","mobin")
                      .build();

              Trigger trigger = newTrigger()
                      .withIdentity("trigger1","group1")
                      .startNow()
                      .withSchedule(simpleSchedule()
                      .withIntervalInSeconds(40)
                      .repeatForever()).build();





         scheduler.scheduleJob(job,trigger);
          } catch (SchedulerException e) {
              e.printStackTrace();
          }
      }


}
