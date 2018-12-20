package com.xiao.JAVAManito.goodidea.taskqueue.producer;

import com.xiao.JAVAManito.goodidea.taskqueue.model.Result;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskInfo;
import com.xiao.JAVAManito.goodidea.taskqueue.model.TaskProducerRequest;

/**
 * Created by unclexiao on 22/07/2018.
 */
public interface TaskProducer {


    /**
     * 产生一个任务
     * @param taskProducerRequest
     * @return
     */
    Result<TaskInfo> produce(TaskProducerRequest taskProducerRequest);
}
