package com.xiao.JAVAManito.effective.creation;

import java.util.regex.Pattern;

/**
 * Created by unclexiao on 18/05/2018.
 */
public class ReuseObject {


    private static final Pattern p = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})");




    //match方法的底层会生成一个Pattern对象，这个对象每次调用都会产生，只会用一次，而其实pattern对象是可以重用的，而且生成pattern对象的代表比较高
//    public static boolean isMatch(String str){
//        return str.matches("^(?=.)M*(C[MD]|D?C{0,3})");
//    }


    //better way
    public static boolean isMatch(String str){
        return p.matcher(str).matches();
    }
}
