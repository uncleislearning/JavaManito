package com.xiao.JAVAManito.effective.classandinterface;

/**
 * Created by unclexiao on 02/06/2018.
 *
 *
 *
 */
public final class ImmutableObject {

    private final char[] chars;

    private final int age;

    private static final ImmutableObject io = new ImmutableObject(10,"".toCharArray());

    public ImmutableObject(int age,char[] chars){
        this.chars = chars;
        this.age = age;
    }


    @Override
    public String toString() {
        return chars[0]+"";
    }
}
