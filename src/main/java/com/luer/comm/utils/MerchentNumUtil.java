package com.luer.comm.utils;

import com.luer.dataManage.dao.MarketingMerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 87961 on 2019/4/10.
 */
public class MerchentNumUtil {

    public  String  getNumber(Integer type,String shortName,int count) throws Exception{
        System.out.println("type=="+type+"shortName"+shortName);
        String merchantType=null;
        if(type==1){
           merchantType="S";
        }else if(type==0){
            merchantType="F";
        }else if(type==3){
            merchantType="H";
        }
        /*String str=PinyinUtil.pinYinTransformate(address);*/
        Date d=new Date();
        DateFormat f=new SimpleDateFormat("yyyyMMdd");
        int num=count++;
        String id="";
        if(num<10){
             id=merchantType+shortName+f.format(d)+'0'+num;
        }else {
             id=merchantType+shortName+f.format(d)+num;
        }
                return id;
    }
}
