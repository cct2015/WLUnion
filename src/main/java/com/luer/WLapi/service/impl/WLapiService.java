package com.luer.WLapi.service.impl;

import com.luer.JD.bean.JdOrder;
import com.luer.JD.service.IJDservice;
import com.luer.WLapi.bean.DataEn;
import com.luer.WLapi.bean.OutMessage;
import com.luer.WLapi.dao.WLapiMapper;
import com.luer.WLapi.service.IWLapiService;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.MD5Utils;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.membershipManage.bean.MarketingMember;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WLapiService implements IWLapiService {

    private static Logger log = LoggerFactory.getLogger(WLapiService.class);
    @Autowired
    private WLapiMapper wLapiMapper;
    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;
    @Autowired
    private IJDservice ijDservice;

    @Override
    public OutMessage insertPhones(String[] phones,String merchantId,String code) {
        List<MarketingMember> list = new ArrayList<>();

        MarketingMember marketingMember = null;
        Date date = new Date();
        String regx="^(1)\\d{10}$";
        for (String phone : phones) {
            marketingMember = new MarketingMember();
            marketingMember.setAddTime(date);
            marketingMember.setMerchantId(merchantId);
            marketingMember.setPhone(phone);
            marketingMember.setSource(1);
            marketingMember.setStatus(0);
            marketingMember.setCode(code);
            list.add(marketingMember);
        }
        int res = wLapiMapper.importData(list);
        if (res > 0) {
            return OutMessage.getOutMessage(res, 200, "操作成功");
        } else {
            return OutMessage.getOutMessage(300, "没有数据上传");
        }
    }

    @Override
    public OutMessage importData(DataEn en) {

        //        200:操作成功
        //        300:没有数据上传
        //        500:商户ID不能为空
        //        400:上传数据库失败
        //        600:手机号码不能为空
        //        700:商户ID不存在
        //        800:手机号码太多(需分批导入，暂定上限20000)
        //        900:token不能为空
        //        1000:时间戳不能为空
        //        1100:权限验证失败
        //        1200:手机号码加密方式错
        //        1300:手机号码拼接有错


        if (StringUtils.isEmpty(en.getPhones())) {
            return OutMessage.getOutMessage(600, "手机号码不能为空");
        }

        String phonesStr=null;
        try{
            phonesStr = Base64.decodeBase64(en.getPhones()).toString();
        }catch (Exception e){
            return OutMessage.getOutMessage(1200, "手机号码加密方式错");
        }
        String[] phones = phonesStr.split(",");
        if (phones.length > 0) {
            if (phones[0].length() > 11) {
                return OutMessage.getOutMessage(1300, "手机号码拼接有错");
            }
        }
        if(phones.length>2000){
            return OutMessage.getOutMessage(800, "手机号码太多(需分批导入，暂定上限20000)");
        }

        if (en.getTimestamp() < 100000) {
            return OutMessage.getOutMessage(1000, "时间戳不能为空");
        }
        if (StringUtils.isEmpty(en.getMerchantId())) {
            return OutMessage.getOutMessage(500, "商户ID不能为空");
        } else {
            //商户ID不存在
            MarketingMerchant marketingMerchant = marketingMerchantMapper.selectByPrimaryKey(en.getMerchantId());
            if (marketingMerchant == null || marketingMerchant.equals("")) {
                return OutMessage.getOutMessage(700, "商户ID不存在");
            }
        }
        if (StringUtils.isEmpty(en.getToken())) {
            return OutMessage.getOutMessage(900, "token不能为空");
        } else {
            String token = DigestUtils.md5Hex(String.format("%s%s%s",en.getMerchantId(),en.getTimestamp(),phones.length));
            //检查token
            if (!token.equals(en.getToken())) {
                return OutMessage.getOutMessage(1100, "权限验证失败");
            }
        }

       return insertPhones(phones,en.getMerchantId(),en.getCode());

    }

    @Override
    public ResultSet queryOrder(DataEn en) {
        if (StringUtils.isEmpty(en.getToken())) {
            return ResultSet.setResult(900, "token不能为空", "");
        }
        if (StringUtils.isEmpty(en.getMerchantId())) {
            return ResultSet.setResult(901, "商户id不能为空", "");
        }
        if (StringUtils.isEmpty(en.getPersonId())) {
            return ResultSet.setResult(902, "用户id不能为空", "");
        }
        if (en.getTimestamp() < 100000) {
            return ResultSet.setResult(903, "时间戳不能为空", "");
        } else {
            String token = MD5Utils.encryption(en.getMerchantId() + en.getPersonId() + en.getTimestamp());
            if (!token.equals(en.getToken())) {
                return ResultSet.setResult(600, "token错误", "");
            } else {
                MarketingMerchant marketingMerchant = marketingMerchantMapper.selectByPrimaryKey(en.getMerchantId());
                if (marketingMerchant == null || marketingMerchant.equals("")) {
                    return ResultSet.setResult(800, "商户Id错误", "");
                } else {
                    List<JdOrder> jdOrders = ijDservice.selectOrder(en.getMerchantId(), "", "", "");
                    return ResultSet.setResult(200, "success", jdOrders);
                }
            }


        }
    }
}


