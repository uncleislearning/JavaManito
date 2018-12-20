package com.xiao.JAVAManito.goodidea.taskqueue.producer;

import com.xiao.JAVAManito.goodidea.taskqueue.model.Result;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskInfo;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskProducerRequest;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskinfoDo;
import org.springframework.util.StringUtils;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by unclexiao on 22/07/2018.
 */
public class TaskProducerImpl implements TaskProducer {


    private BlockingQueue<TaskinfoDo> taskpool = new PriorityBlockingQueue<>();



    @Override
    public Result<TaskInfo> produce(TaskProducerRequest taskProducerRequest) {

        if(taskProducerRequest == null || StringUtils.isEmpty(taskProducerRequest.getMessage())){
            return new Result<>(false,"参数错误",null);
        }


        TaskinfoDo taskinfoDo = buildTaskInfo(taskProducerRequest);


        // TODO 做限流

        // TODO  任务重复



        boolean result =  taskpool.add(taskinfoDo);

        if(!result){
            return new Result<>(false,"任务插入失败",null);
        }

        return new Result<>(true,null,convert(taskinfoDo));
    }

    private TaskInfo convert(TaskinfoDo taskinfoDo) {
        TaskInfo taskInfo = new TaskInfo();

        return taskInfo;
    }

    private TaskinfoDo buildTaskInfo(TaskProducerRequest taskProducerRequest) {
        TaskinfoDo taskinfoDo = new TaskinfoDo();


        return taskinfoDo;
    }
}
