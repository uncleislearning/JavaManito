package com.xiao.JAVAManito.RPC.demo1;

import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by unclexiao on 19/12/2018.
 * <p>
 * 一些公共的配置
 */
public class ServerConfig {
    private static final String serverAddress = "localhost;10.12.12.32";

    private static final Integer serverPort = 7777;


    public static Integer getServerPort() {
        return serverPort;
    }

    public static List<String> getServerAddress() {
        if (StringUtils.isEmpty(serverAddress)) {
            return null;
        }
        return Lists.newArrayList(serverAddress.split(";"));
    }
}
