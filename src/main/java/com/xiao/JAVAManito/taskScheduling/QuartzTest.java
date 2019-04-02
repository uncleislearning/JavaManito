/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.taskScheduling;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.DailyTimeIntervalTriggerImpl;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 *
 * @author xiaomengning
 * @version $Id: QuartzTest.java, v 0.1 2019年03月19日 17:33 xiaomengning Exp $
 */
public class QuartzTest {



    private static class  MuJob implements Job{
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("job");
        }
    }




    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            //启动scheduler
            scheduler.start();
            Job job = new MuJob();

            //build 模式
            JobDetail jobDetail = JobBuilder.newJob(MuJob.class)
                                 .withIdentity("myJob").build();

            Trigger trigger =TriggerBuilder.newTrigger().withIdentity("myTrigger", "myTriggerGroup").build();


            scheduler.scheduleJob(jobDetail,trigger);




        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}