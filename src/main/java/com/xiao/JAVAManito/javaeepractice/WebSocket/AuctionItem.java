//package com.xiao.JAVAManito.javaeepractice.WebSocket;
//
///**
// * Created by unclexiao on 2018/1/4.
// */
//public class AuctionItem {
//
//    /*
//     * Name of the item.
//     */
//    private final String name;
//
//    /*
//     * Description of the item.
//     */
//    private final String description;
//
//    /*
//     * Current price of the item.
//     */
//    private double price;
//
//    /*
//     * Timeout which is applied for one bid.
//     */
//    private final int bidTimeoutS;
//
//
//    public AuctionItem(String name, String description, double price, int bidTimeoutS) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.bidTimeoutS = bidTimeoutS;
//    }
//
//    @Override
//    public String toString() {
//        return name + Auction.SEPARATOR + description + Auction.SEPARATOR + price + Auction.SEPARATOR + "0" + Auction.SEPARATOR + bidTimeoutS + " seconds";
//    }
//
//    public int getBidTimeoutS() {
//        return bidTimeoutS;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price){
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//}