package com.xiao.JAVAManito.goodidea.taskqueue.consumer;

import com.xiao.JAVAManito.goodidea.taskqueue.model.Result;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskConsumeResponse;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskInfo;

import java.util.List;

/**
 * Created by unclexiao on 22/07/2018.
 */
public interface TaskConsumer {



    Boolean consumeByPriority(List<String> statusList);


    Result<TaskConsumeResponse> consume(TaskInfo taskInfo);
}
