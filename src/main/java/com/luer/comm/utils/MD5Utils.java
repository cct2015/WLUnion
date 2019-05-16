package com.luer.comm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;


public class MD5Utils {

    private static final Logger log = LoggerFactory.getLogger(MD5Utils.class);
//    //加密
    public static String encryption(String ss) {//MD5加密算法
        //定义一个字节数组
        byte[] secretBytes = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(ss.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (Exception e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

//    //解密
//    public static String decryption(String inStr) {
//        char[] a = inStr.toCharArray();
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (char) (a[i] ^ 't');
//        }
//        String s = new String(a);
//        return s;
//    }
//
//    /**
//     * 加密解密算法 执行一次加密，两次解密
//     */
//    public static String convertMD5(String inStr){
//
//        char[] a = inStr.toCharArray();
//        for (int i = 0; i < a.length; i++){
//            a[i] = (char) (a[i] ^ 't');
//        }
//        String s = new String(a);
//        return s;
//
//    }
//    public static String string2MD5(String inStr){
//        MessageDigest md5 = null;
//        try{
//            md5 = MessageDigest.getInstance("MD5");
//        }catch (Exception e){
//            System.out.println(e.toString());
//            e.printStackTrace();
//            return "";
//        }
//        char[] charArray = inStr.toCharArray();
//        byte[] byteArray = new byte[charArray.length];
//
//        for (int i = 0; i < charArray.length; i++)
//            byteArray[i] = (byte) charArray[i];
//        byte[] md5Bytes = md5.digest(byteArray);
//        StringBuffer hexValue = new StringBuffer();
//        for (int i = 0; i < md5Bytes.length; i++){
//            int val = ((int) md5Bytes[i]) & 0xff;
//            if (val < 16)
//                hexValue.append("0");
//            hexValue.append(Integer.toHexString(val));
//        }
//        return hexValue.toString();
//
//    }
//
//    public static void main(String[] args) {
//       String s1 = new String("13761504612");
//       System.out.println("原始：" + s1);
//        String s2=encryption(s1);
//        System.out.println("加密的：" +s2);
//
//        s2=encryption(s2);
//        String s3=string2MD5(s2);
//        System.out.println("解密的：" +s3);
//
//    }

    // MD5加码。32位
        public static String MD5(String inStr) {
            MessageDigest md5 = null;
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
                return "";
            }
            char[] charArray = inStr.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                byteArray[i] = (byte) charArray[i];
            }
            byte[] md5Bytes = md5.digest(byteArray);

            StringBuffer hexValue = new StringBuffer();

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16){
                    hexValue.append("0");}
                hexValue.append(Integer.toHexString(val));
            }

            return hexValue.toString();
        }

        // 可逆的加密算法
        public static String KL(String inStr) {
            // String s = new String(inStr);
            char[] a = inStr.toCharArray();
            for (int i = 0; i < a.length; i++) {
                a[i] = (char) (a[i] ^ 't');
            }
            String s = new String(a);
            return s;
        }

        // 加密后解密
        public static String JM(String inStr) {
            char[] a = inStr.toCharArray();
            for (int i = 0; i < a.length; i++) {
                a[i] = (char) (a[i] ^ 't');
            }
            String k = new String(a);
            return k;
        }

        // 测试主函数
        public static void main(String args[]) {
            String s = new String("18321933143");
            String s1= encryption(s);
            System.out.println("MD5后：" + s1);

        }

    public static String hash(String s)
    {
        try
        {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        }
        catch (Exception e)
        {

            log.error("not supported charset...{}", e);
            return s;
        }
    }

    private static final String toHex(byte hash[])
    {
        if (hash == null)
        {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++)
        {
            if ((hash[i] & 0xff) < 0x10)
            {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }
    private static byte[] md5(String s)
    {
        MessageDigest algorithm;
        try
        {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        }
        catch (Exception e)
        {
            log.error("MD5 Error...", e);
        }
        return null;
    }
}