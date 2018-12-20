//package com.xiao.JAVAManito.javaeepractice.WebSocket;
//
//import javax.websocket.EncodeException;
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Created by unclexiao on 2018/1/4.
// */
//@ServerEndpoint(value = "/auction",
//        decoders = {
//                AuctionMessageDecoder.class,
//        },
//        encoders = {
//                AuctionMessageEncoder.class
//        }
//)
//public class AuctionServer {
//    /*
//     * Set of auctions (finished, running, to be started auctions).
//     */
//    private static final Set<Auction> auctions = Collections.unmodifiableSet(new HashSet<Auction>() {{
//        add(new Auction(new AuctionItem("Swatch", "Nice Swatch watches, hand made", 100, 20)));
//        add(new Auction(new AuctionItem("Rolex", "Nice Rolex watches, hand made", 200, 20)));
//        add(new Auction(new AuctionItem("Omega", "Nice Omega watches, hand made", 300, 20)));
//    }});
//
//    @OnClose
//    public void handleClosedConnection(Session session) {
//        for (Auction auction : auctions) {
//            auction.removeArc(session);
//        }
//    }
//
//    @OnMessage
//    public void handleMessage(AuctionMessage message, Session session){
//        String communicationId;
//        switch (message.getType()){
//            //登出请求
//            case AuctionMessage.LOGOUT_REQUEST:
//                handleClosedConnection(session);
//                break;
//                //发送拍卖列表
//            case AuctionMessage.AUCTION_LIST_REQUEST:
//                StringBuilder sb = new StringBuilder("-");
//
//                for (Auction auction : auctions) {
//                    sb.append(auction.getId()).append("-").append(auction.getItem().getName()).append("-");
//                }
//                try {
//                    session.getBasicRemote().sendObject((new AuctionMessage.AuctionListResponseMessage("0", sb.toString())));
//                } catch (IOException | EncodeException e) {
//                    Logger.getLogger(AuctionServer.class.getName()).log(Level.SEVERE, null, e);
//                }
//                break;
//                //登陆请求
//            case AuctionMessage.LOGIN_REQUEST:
//                communicationId = message.getCommunicationId();
//                for (Auction auction : auctions) {
//                    if (communicationId.equals(auction.getId())) {
//                        auction.handleLoginRequest(message, session);
//                    }
//                }
//                break;
//                //请求拍卖
//            case AuctionMessage.BID_REQUEST:
//                communicationId = message.getCommunicationId();
//                for (Auction auction : auctions) {
//                    if (communicationId.equals(auction.getId())) {
//                        auction.handleBidRequest(message, session);
//                        break;
//                    }
//                }
//                break;
//        }
//
//    }
//}
