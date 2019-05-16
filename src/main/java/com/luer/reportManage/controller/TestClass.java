package com.luer.reportManage.controller;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 87961 on 2019/4/24.
 */
public class TestClass{
    public static void main(String[] args) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse("2019-04-25");
            Long time=date.getTime();
            System.out.println(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
