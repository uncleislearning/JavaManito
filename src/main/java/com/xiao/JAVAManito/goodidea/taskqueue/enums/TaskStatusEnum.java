package com.xiao.JAVAManito.goodidea.taskqueue.enums;

import org.springframework.util.StringUtils;

/**
 * Created by unclexiao on 22/07/2018.
 *
 * 任务状态定义
 */
public enum TaskStatusEnum {

    /**已经创建**/
    CREATED,

    /**正在执行**/
    RUNNING,

    /**成功执行**/
    SUCCESSED,

    /**执行失败**/
    FAIL,

    /**失败重试**/
    FAIL_WITH_RESTRY;



    public static TaskStatusEnum getTaskStatusEnum(String statusName){
        TaskStatusEnum result =null;

        for( TaskStatusEnum taskStatus:  TaskStatusEnum.values()){
            if(taskStatus.name().equals(statusName)){
                 result = taskStatus;
                 break;
            }
        }
        return result;
    }
}
