//package com.xiao.JAVAManito.javaeepractice.WebSocket;
//
//import javax.websocket.OnClose;
//import javax.websocket.OnError;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Queue;
//import java.util.concurrent.ConcurrentLinkedDeque;
//
///**
// * Created by unclexiao on 2018/1/4.
// */
//
//@ServerEndpoint("/ws")
//public class ETFEndPoint {
//
//    static Queue<Session> queue = new ConcurrentLinkedDeque<>();
//
//    /* PriceVolumeBean calls this method to send updates */
//    public static void send(double price, int volume) {
//        String msg = String.format("%.2f / %d", price, volume);
//        /* Send updates to all open WebSocket sessions */
//        try {
//            for (Session session : queue) {
//                session.getBasicRemote().sendText(msg);
//            }
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }
//    }
//
//
//    @OnOpen
//    public void openConnection(Session session) {
//    /* Register this connection in the queue */
//        queue.add(session);
//    }
//
//    @OnClose
//    public void closedConnection(Session session){
//        /* Remove this connection from the queue */
//        queue.remove(session);
//    }
//
//    @OnError
//    public void error(Session session,Throwable throwable){
//            /* Remove this connection from the queue */
//            queue.remove(session);
//    }
//}
