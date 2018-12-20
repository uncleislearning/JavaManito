package com.xiao.JAVAManito.javaeepractice.jaxrs;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by unclexiao on 2018/1/4.
 */
@Path("/source")
@Singleton
public class ChatResource {

    /**
     * This queue synchronizes produces/consumes operations. It contains {@link AsyncResponse async responses} into
     * which post message should be written.
     */
    private final BlockingQueue<AsyncResponseWrapper> suspended = new ArrayBlockingQueue<AsyncResponseWrapper>(10);

    /**
     * Internal response wrapper which bundles response with id.
     */
    private static class AsyncResponseWrapper {
        private final AsyncResponse asyncResponse;
        private final String id;

        private AsyncResponseWrapper(AsyncResponse asyncResponse, String id) {
            this.asyncResponse = asyncResponse;
            this.id = id;
        }

        public AsyncResponse getAsyncResponse() {
            return asyncResponse;
        }

        public String getId() {
            return id;
        }
    }

    /**
     * Handle a HTTP get message asynchronously (suspend response in order to release the container thread instead of
     * blocking it on the blocking queue).
     *
     * @param asyncResponse Suspended asynchronous response (injected).
     * @param requestId Header identifying the header.
     */
    @GET
    public void getMessage(@Suspended final AsyncResponse asyncResponse, final @HeaderParam("request-id") String requestId) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // Put actual response to the queue. This response will be later taken and resumed with
                    // the message.
                    suspended.put(new AsyncResponseWrapper(asyncResponse, requestId));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Handle a HTTP POST method asynchronously (suspend response in order to release the container thread instead of
     * blocking it on the blocking queue).
     *
     * @param postAsyncResponse Suspended asynchronous response (injected).
     * @param message Message to be sent.
     */
    @POST
    public void postMessage(@Suspended final AsyncResponse postAsyncResponse,final String message) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Take one response from the queue and resume it with the message. If no message is in the queue now
                    // then this method will block the thread until the response is put into queue (by GET http method).
                    final AsyncResponseWrapper responseWrapper = suspended.take();
                    responseWrapper.getAsyncResponse().resume(Response.ok()
                            .entity(message).header("request-id", responseWrapper.getId()).build());

                    // Now resume response connected with the request invoking this post method just reply that the message
                    // was delivered.
                    postAsyncResponse.resume("Sent!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Get the string representation of internal async response queue <code>suspended<code/>.
     * <p/>
     * This resource is requested in regular intervals by clients.
     *
     * @return Plain text with list of request-id of async responses.
     */
    @GET
    @Path("queue")
    @Produces("text/html")
    public String getResponseQueue() {
        StringBuffer sb = new StringBuffer();
        boolean addSeparator = false;
        for (AsyncResponseWrapper asyncResponseWrapper : suspended) {
            if (addSeparator) {
                sb.append(", ");
            } else {
                addSeparator = true;
            }
            sb.append(asyncResponseWrapper.getId());
        }
        return sb.toString();
    }
}
