//package com.xiao.JAVAManito.javaeepractice.WebSocket;
//
//import javax.websocket.Decoder;
//import javax.websocket.EndpointConfig;
//
///**
// * Created by unclexiao on 2018/1/4.
// */
//public class AuctionMessageDecoder implements Decoder.Text<AuctionMessage> {
//
//    @Override
//    public AuctionMessage decode(String s) {
//        String[] tokens = s.split(":");
//
//        return new AuctionMessage(tokens[0], tokens[1], tokens[2]);
//    }
//
//    @Override
//    public boolean willDecode(String s) {
//        return s.startsWith(AuctionMessage.BID_REQUEST) ||
//                s.startsWith(AuctionMessage.AUCTION_LIST_REQUEST) ||
//                s.startsWith(AuctionMessage.LOGIN_REQUEST) ||
//                s.startsWith(AuctionMessage.LOGOUT_REQUEST);
//    }
//
//    @Override
//    public void init(EndpointConfig endpointConfig) {
//        // do nothing.
//    }
//
//    @Override
//    public void destroy() {
//        // do nothing.
//    }
//}