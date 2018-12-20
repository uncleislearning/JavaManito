//package com.xiao.JAVAManito.javaeepractice.WebSocket;
//
//import javax.websocket.Session;
//import java.io.IOException;
//import java.util.TimerTask;
//
///**
// * Created by unclexiao on 2018/1/4.
// */
//public class AuctionTimeBroadcasterTask extends TimerTask {
//
//    private Auction owner;
//    private int timeoutCounter;
//
//    public AuctionTimeBroadcasterTask(Auction owner, int timeoutCounter) {
//        this.owner = owner;
//        this.timeoutCounter = timeoutCounter;
//    }
//
//    @Override
//    public void run() {
//        if (timeoutCounter < 0) {
//            owner.switchStateToAuctionFinished();
//        } else {
//            if (!owner.getRemoteClients().isEmpty()) {
//                AuctionMessage.AuctionTimeBroadcastMessage atbm = new AuctionMessage.AuctionTimeBroadcastMessage(owner.getId(), timeoutCounter);
//
//                for (Session arc : owner.getRemoteClients()) {
//                    try {
//                        arc.getBasicRemote().sendText(atbm.toString());
//                    } catch (IOException ex) {
//                        System.out.println(ex.toString());
//                    }
//                }
//            }
//        }
//        timeoutCounter--;
//    }
//}
