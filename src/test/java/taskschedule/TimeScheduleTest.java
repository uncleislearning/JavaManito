/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package taskschedule;

import com.xiao.JAVAManito.taskScheduling.MyTimer.ScheduleConfig;
import com.xiao.JAVAManito.taskScheduling.MyTimer.TimeSchedule;
import com.xiao.JAVAManito.taskScheduling.MyTimer.XTaskQueue;
import com.xiao.JAVAManito.taskScheduling.MyTimer.XTimerTask;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaomengning
 * @version $Id: TimeScheduleTest.java, v 0.1 2019年04月02日 12:11 xiaomengning Exp $
 */
public class TimeScheduleTest {


    @Rule
    public ExpectedException  expectedThrow = ExpectedException.none();



    /**
     * 测试调度配置类的参数检查
     */
    @Test
    public void testSheduleConfig(){


        //测试构造方法

        ScheduleConfig scheduleConfig;

        scheduleConfig = new ScheduleConfig(new Date(System.currentTimeMillis()+10000L));
        Assert.assertNotNull(scheduleConfig);

        scheduleConfig = new ScheduleConfig(10000L);
        Assert.assertNotNull(scheduleConfig);

        scheduleConfig = new ScheduleConfig(new Date(System.currentTimeMillis()+10000L),1000L);
        Assert.assertNotNull(scheduleConfig);

        scheduleConfig = new ScheduleConfig(10000L,1000L);
        Assert.assertNotNull(scheduleConfig);


        //测试参数异常检测

        expectedThrow.expect(IllegalArgumentException.class);
        expectedThrow.expectMessage("execution time is null");
        scheduleConfig = new ScheduleConfig();


        expectedThrow.expect(IllegalArgumentException.class);
        expectedThrow.expectMessage("next execution date can't be negative");
        scheduleConfig = new ScheduleConfig(new Date(-10000L));



        expectedThrow.expect(IllegalArgumentException.class);
        expectedThrow.expectMessage("delay time can't be negative");
        scheduleConfig = new ScheduleConfig(-10000L);



        expectedThrow.expect(IllegalArgumentException.class);
        expectedThrow.expectMessage("period time of repeat task  can't be zero or negative");
        scheduleConfig = new ScheduleConfig(new Date(),-1L);






        //测试边界条件

        scheduleConfig = new ScheduleConfig(0L);


        scheduleConfig = new ScheduleConfig(new Date(0));


        expectedThrow.expect(IllegalArgumentException.class);
        expectedThrow.expectMessage("period time of repeat task  can't be zero or negative");
        scheduleConfig = new ScheduleConfig(new Date(),0L);


    }

    /**
     * 测试任务
     */
    @Test
    public void testTask(){

        XTimerTask timerTask = XTimerTask.getInstance();
        timerTask.setNextExecutionTime(1L);

        XTimerTask timerTask1 = XTimerTask.getInstance();
        timerTask1.setNextExecutionTime(2L);

        XTimerTask timerTask2 = XTimerTask.getInstance();
        timerTask2.setNextExecutionTime(3L);

        XTimerTask timerTask3 = XTimerTask.getInstance();
        timerTask3.setNextExecutionTime(1L);

        XTaskQueue xTaskQueue = new XTaskQueue();
        xTaskQueue.add(timerTask);
        xTaskQueue.add(timerTask1);
        xTaskQueue.add(timerTask2);
        xTaskQueue.add(timerTask3);


        Assert.assertTrue(!xTaskQueue.isEmpty());


        XTimerTask firstTask = xTaskQueue.getFirst();
        Assert.assertTrue(firstTask == timerTask);

        firstTask = xTaskQueue.removeMin();
        Assert.assertTrue(firstTask == timerTask);


        firstTask = xTaskQueue.removeMin();
        Assert.assertTrue(firstTask == timerTask3);


        firstTask = xTaskQueue.removeMin();
        Assert.assertTrue(firstTask == timerTask1);

        firstTask = xTaskQueue.removeMin();
        Assert.assertTrue(firstTask == timerTask2);


        Assert.assertFalse(!xTaskQueue.isEmpty());


        xTaskQueue = new XTaskQueue();
        xTaskQueue.add(timerTask);
        xTaskQueue.add(timerTask1);
        xTaskQueue.add(timerTask2);
        xTaskQueue.add(timerTask3);


        timerTask.setStatus(3);
        timerTask1.setStatus(1);
        timerTask2.setStatus(3);
        timerTask3.setStatus(3);
        xTaskQueue.purge();

        Assert.assertTrue(xTaskQueue.size() == 1);
        Assert.assertTrue(xTaskQueue.getFirst().getStatus()==1);


        xTaskQueue.clear();

        Assert.assertTrue(xTaskQueue.isEmpty());
    }


    /**
     * 测接口功能
     */
    @Test
    public void testSchedule() throws InterruptedException {
        TimeSchedule timeSchedule = new TimeSchedule();

        AtomicInteger n = new AtomicInteger(1);

        //1.动作
        AlarmTask task = new AlarmTask("t",n);
        AlarmTask task1 = new AlarmTask("t1",n);
        AlarmTask task2 = new AlarmTask("t2",n);
        AlarmTask task3 = new AlarmTask("t3",n);

        System.out.println(new Date());

        //2.策略

        //2.1 执行延迟时间，单次任务
        ScheduleConfig config1 = new ScheduleConfig(1000L);

        //2.2 指定执行时间，单次任务
        ScheduleConfig config2 = new ScheduleConfig(new Date(System.currentTimeMillis()+2000L));

        //2.3 指定执行时间，时间间隔1秒，周期任务
        ScheduleConfig config3 = new ScheduleConfig(new Date(System.currentTimeMillis()+3000L),1000L);

        //2.4 指定延迟时间，时间间隔1秒，周期任务
        ScheduleConfig config4 = new ScheduleConfig(8000L,1000L);


        //3.调度
        timeSchedule.schedule(task,config1);
        timeSchedule.schedule(task1,config2);
        timeSchedule.schedule(task2,config3);
        timeSchedule.schedule(task3,config4);

        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 2);

        //-----task执行结束-------

        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 3);

        //-----task1执行结束-------


        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 4);


        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 5);


        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 6);

        task2.cancel();

        //-----task2执行结束-------

        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 6);



        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 6);



        Thread.sleep(1010L);
        Assert.assertTrue(n.get() == 7);

    }







    @Test
    public void testRepeatTask() throws InterruptedException {
        TimeSchedule timeSchedule = new TimeSchedule();

        AtomicInteger n = new AtomicInteger(1);

        //1.动作
        AlarmTask task = new AlarmTask("t",n);

        //2.4 指定延迟时间，时间间隔1秒，周期任务
        ScheduleConfig config4 = new ScheduleConfig(8000L,1000L);


        timeSchedule.schedule(task,config4);
        Thread.sleep(20000L);

    }





    /**
     * 测试用的任务
     */
    private static class AlarmTask extends XTimerTask {


        private String name;

        private AtomicInteger n;

        public AlarmTask(String name,AtomicInteger n) {
            this.name = name;
            this.n = n;
        }

        @Override
        public void run() {
            n.getAndIncrement();
            System.out.println(this.name+"--"+new Date(System.currentTimeMillis())+"--n:"+n.get());
        }
    }

}