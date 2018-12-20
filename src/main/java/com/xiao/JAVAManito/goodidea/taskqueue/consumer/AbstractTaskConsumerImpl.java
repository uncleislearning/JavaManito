package com.xiao.JAVAManito.goodidea.taskqueue.consumer;

import com.xiao.JAVAManito.goodidea.taskqueue.enums.TaskStatusEnum;
import com.xiao.JAVAManito.goodidea.taskqueue.model.Result;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskConsumeResponse;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskInfo;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskinfoDo;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by unclexiao on 22/07/2018.
 */
public abstract class AbstractTaskConsumerImpl implements TaskConsumer {


    private static final  int MAX_RESTRY = 10;

    private BlockingQueue<TaskinfoDo> taskpool = new PriorityBlockingQueue<>();


    @Override
    public Boolean consumeByPriority(List<String> statusList) {

        if(statusList == null || StringUtils.isEmpty(statusList)){
            throw new RuntimeException("consumeByPriority Error: consumeStatusList is null or empty");
        }

        try {
            TaskinfoDo task = taskpool.take();

            if(task == null){
                return false;
            }

            Set<TaskStatusEnum> statusEnums = new HashSet<>();
            for(String status: statusList){
                statusEnums.add(TaskStatusEnum.getTaskStatusEnum(status));
            }

            TaskStatusEnum oldStatus =  TaskStatusEnum.getTaskStatusEnum(task.getStatus());

            if(oldStatus == null || !statusEnums.contains(oldStatus)){
                return false;
            }


            task.setExecuteTimes(task.getExecuteTimes()+1);
            task.setScheduleTime(new Date());
            task.setStatus(TaskStatusEnum.RUNNING.name());

            boolean res = taskpool.add(task);
            if(!res) {
                return false;
            }
            Long start = System.currentTimeMillis();
            Result<TaskConsumeResponse> result = consume(convert(task));
            Long end = System.currentTimeMillis();
            Long cost = end - start;
            if(result == null){
                // 一种标识，用来放慢线程消费
                return null;
            }

            if(result.isSuccess()){
                task.setExecuteCost(cost.intValue());
                task.setStatus(TaskStatusEnum.SUCCESSED.name());
            }else {
                task.setExecuteCost(cost.intValue());
                if(task.getExecuteTimes() < MAX_RESTRY){
                    task.setStatus(TaskStatusEnum.FAIL_WITH_RESTRY.name());
                }else {
                    task.setStatus(TaskStatusEnum.FAIL.name());
                }

            }
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private TaskInfo convert(TaskinfoDo task) {
        TaskInfo taskInfo = new TaskInfo();


        return taskInfo;
    }




}
