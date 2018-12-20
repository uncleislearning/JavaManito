package com.xiao.JAVAManito.goodidea.auth.enums;

/**
 * Created by unclexiao on 18/07/2018.
 */
public enum BizTypeEnum {

    WORKBOOK("001","workbook"),
    REPORT("002","report"),
    CHART("003","chart"),
    DEFAULT("004","default");

    String code;
    String desc;

    BizTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
