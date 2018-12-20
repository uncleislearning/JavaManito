package com.xiao.JAVAManito.javaeepractice.jsonp;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by unclexiao on 2018/1/4.
 *
 * 对响应体进行写操作
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class MyWriter implements MessageBodyWriter<MyObject> {


    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return  MyObject.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(MyObject myObject, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(MyObject myObject, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        JsonGenerator gen = Json.createGenerator(entityStream);
        gen.writeStartObject()
                .write("name",myObject.getName())
                .write("age",myObject.getAge())
                .writeEnd();
                gen.flush();
    }
}
