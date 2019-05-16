package com.luer.privilegeManage.service;


import java.util.Map;

public interface WlauthenticationService {


    Map checkUserCookie(String str);

    Map getMap();

    boolean decryptValue(String str);
}
