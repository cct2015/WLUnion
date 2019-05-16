package com.luer.comm.utils;


import com.alibaba.fastjson.JSONObject;
import com.luer.comm.constants.Constant;
import com.luer.privilegeManage.bean.SysUser;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 鉴权接口
 *
 * */
public class WlAuthentication {



    /*
     *获取当前时间戳
     * */
    public static String getTime() {
        long timeInt = System.currentTimeMillis() / 1000;
        String timestamp = Long.toString(timeInt);
        return timestamp;
    }

    /*
     *由时间戳，ak,sk拼接成字符串,并排序
     * */
    public static String getStr(String timestamp, String ak, String sk) {

        StringBuffer sb = new StringBuffer();
        sb.append(timestamp);
        sb.append(ak);
        sb.append(sk);
        String str = sb.toString();
        String strEnd = sort(str);
        return strEnd;

    }

    /*
     * 将字符串排序
     * */
    public static String sort(String str) {
        StringBuilder sb = new StringBuilder();
        char[] test = str.toCharArray();
        Arrays.sort(test);
        for (int i = 0; i < test.length; i++) {
            sb.append(test[i]);
        }
        String strEnd = sb.toString().trim();
        return strEnd;

    }

    /*
     *对字符串进行加密
     * */
    public static String encryption(String str) {//MD5加密加盐算法
        //定义一个字节数组
        byte[] secretBytes = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(str.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (Exception e) {
            throw new RuntimeException("没有encryption这个方法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    /*
     * 由时间戳,uuid,ak，sk生成鉴权
     *
     **/
    public static String getAuthentication(String timestamp, String uid, String ak, String sk) {
        String str = getStr(timestamp, ak, sk);
        String strEnd = encryption(str + uid);
        return strEnd;
    }

   public static void main(String[] args) throws UnsupportedEncodingException {
        String timestamp = getTime();
        String uid = UuidUtils.getUUID();
        String ak = "wlunion";
        String sk = "wl163com";
        String authentication = getAuthentication(timestamp, uid, ak, sk);
        Cookie cookie = new Cookie(Constant.COOKIEVALUE, "");
        cookie.setMaxAge(-1);
        String cookieValue = "y0kUU0Qgt%2FsHWIUkxT%2FwPd485bsoEQd96weyroq%2F%2BZeu69Mb0enRfKQm0mvkmEO%2BG029GDXDD%2B%2BM%0ANZel5IAHS0RFJPpMsjpxDr%2Fzu4wRxpk%3D";
        String value= URLDecoder.decode(cookieValue,"UTF-8");
      /* System.out.println("cookieValue================"+cookieValue);
        System.out.println("value================"+value);
        System.out.println("ak=" + ak);
        System.out.println("sk=" + sk);
        System.out.println("timestamp=" + timestamp);
        System.out.println("uid=" + uid);
        System.out.println("authentication=" + authentication);*/
        Map map = new HashMap();
        map.put("timestamp", timestamp);
        map.put("uid", uid);
        map.put("ak", ak);
        map.put("authentication", authentication);
        map.put("cookieValue", cookieValue);
        JSONObject jo=new JSONObject(map);
        String json = JSONObject.toJSONString(map);
        System.out.println(json);


    }

    /*
     * 用户传入账号，密钥，以及时间戳以及密钥验证用户是否有权调用接口
     *
     **/
    public static boolean checkAuthentication(Map<String, String> map) {

        if (map.size() == 0) {
            return false;
        }
        String timestamp = map.get("timestamp");
        String uid = map.get("uid");
        String ak = map.get("ak");
        String authentication = map.get("authentication");
        String sk = "wl163com";
        String cookieValue = map.get("cookieValue");
        if (timestamp.equals(null) || uid.equals(null) || ak.equals(null) || authentication.equals(null) || sk.equals(null) || cookieValue.equals(null)) {
            return false;
        }
        long mowTime = System.currentTimeMillis() / 1000;

   /*     if (mowTime - Long.parseLong(timestamp) >= 100) {
            return false;
        }*/
        String str = getStr(timestamp, ak, sk);

        String strEnd = encryption(str + uid);
        if (strEnd.equals(authentication) ) {
            return true;
        }
        return false;
    }

    //获取cookie值
    public static String getUserCookieValue(SysUser sysUser) {
        //用户名
        String usersId = sysUser.getId();
        //用户商户号
        String merchantId = sysUser.getMerchantId();
        //用户类型
        String userType = sysUser.getUserType();
        String value = encryptionValue(usersId, merchantId, userType);
        return value;
    }

    //加密
    private static String encryptionValue(String usersId, String merchantId, String userType)
    {
        String value = "033ecb23cd1a417b91e08d3bdfdb5cba";
        String encryptionResult = SymmetricEncoder.AESEncode(value,usersId + "," + merchantId + "," + userType );
        return encryptionResult;
    }


}
