package com.luer.wx.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class SHA1 {
    public SHA1() {
    }

    public static String gen(String... arr) {
        if (StringUtils.isAnyEmpty(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        } else {
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            String[] var2 = arr;
            int var3 = arr.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                String a = var2[var4];
                sb.append(a);
            }

            return DigestUtils.sha1Hex(sb.toString());
        }
    }

    public static String genWithAmple(String... arr) {
        if (StringUtils.isAnyEmpty(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        } else {
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.length; ++i) {
                String a = arr[i];
                sb.append(a);
                if (i != arr.length - 1) {
                    sb.append('&');
                }
            }

            return DigestUtils.sha1Hex(sb.toString());
        }
    }
}