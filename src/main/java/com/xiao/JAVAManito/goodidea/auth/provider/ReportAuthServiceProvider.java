package com.xiao.JAVAManito.goodidea.auth.provider;

import com.xiao.JAVAManito.goodidea.auth.provider.AuthServiceProvider;

/**
 * Created by unclexiao on 01/06/2018.
 */
public class ReportAuthServiceProvider implements AuthServiceProvider {

    private static final String TYPE="report";

    @Override
    public boolean isSuitable(String type) {
        if(TYPE.equals(type)){
            return true;
        }
        return false;
    }

    @Override
    public boolean check(String identity) {

        if( identity != null && "REPORT".equals(identity) && identity.length() <10){
            return true;
        }
        return false;
    }
}
