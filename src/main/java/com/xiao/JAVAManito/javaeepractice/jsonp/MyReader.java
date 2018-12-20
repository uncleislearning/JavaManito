package com.xiao.JAVAManito.javaeepractice.jsonp;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by unclexiao on 2018/1/4.
 *
 * 对响应体的读取操作类
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class MyReader implements MessageBodyReader<MyObject> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return MyObject.class.isAssignableFrom(type);
    }


    @Override
    public MyObject readFrom(Class<MyObject> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        MyObject o = new MyObject();
        JsonParser parser = Json.createParser(entityStream);
        while (parser.hasNext()) {
            switch (parser.next()) {
                case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch (key) {
                        case "name":
                            o.setName(parser.getString());
                            break;
                        case "age":
                            o.setAge(parser.getInt());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }

        return o;
    }
}
