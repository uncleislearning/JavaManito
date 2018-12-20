package com.xiao.JAVAManito.javaeepractice.jsonp;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.ObjectInputStream;

/**
 * Created by unclexiao on 2018/1/4.
 */
@Path("endpoint")
public class MyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getObject() {
        return Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 25)
                .add("address", Json.createObjectBuilder()
                        .add("streetAddress", "21 2nd Street")
                        .add("city", "New York")
                        .add("state", "NY")
                        .add("postalCode", "10021"))
                .add("phoneNumber", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "212 555-1234"))
                        .add(Json.createObjectBuilder()
                                .add("type", "fax")
                                .add("number", "646 555-4567")))
                .build();
    }


    /**
     * 资源方法，用于操作资源实体
     *
     * @param mo
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MyObject echoObject(MyObject mo) {
        return mo;
    }


}
