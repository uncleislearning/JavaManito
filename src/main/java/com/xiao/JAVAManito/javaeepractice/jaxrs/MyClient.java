package com.xiao.JAVAManito.javaeepractice.jaxrs;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

/**
 * Created by unclexiao on 2018/1/4.
 */

@Named
@Stateless
public class MyClient{
    protected Client client;

    @PostConstruct
    private void init(){
        client = ClientBuilder.newClient();
    }


    @PreDestroy
    private void clean(){
        client.close();
    }


//    public String createChatSource(){
//
//
//
////        String resp = client.target("http://localhost:8080/ee/chat/source/").request().post();
//
//    }

}

