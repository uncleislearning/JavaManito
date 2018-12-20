package com.xiao.JAVAManito.javaeepractice.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by unclexiao on 2018/1/4.
 */
@ApplicationPath("/chat")
public class ChatClient extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ChatResource.class);
        return classes;
    }
}
