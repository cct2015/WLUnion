package com.luer.dataManage.service.Impl;

import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.UuidUtils;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.bean.MerchantDefineData;
import com.luer.dataManage.bean.MerchantInformation;
import com.luer.dataManage.dao.MarketingBrandMapper;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.dataManage.dao.MerchantDefineDataMapper;
import com.luer.dataManage.service.MerchantInformationService;
import com.luer.membershipManage.dao.MarketingMemberMapper;
import com.luer.wx.dao.MarketingMerchantWxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 87961 on 2019/3/15.
 */
@Transactional
@Service
public class MerchantInformationServiceImpl implements MerchantInformationService {
    @Autowired
    private MarketingMerchantWxMapper marketingMerchantWxMapper;
    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;
    @Autowired
    private MarketingMemberMapper marketingMemberMapper;
    @Autowired
    private MarketingBrandMapper marketingBrandMapper;
    @Autowired
    private MerchantDefineDataMapper merchantDefineDataMapper;

    public String getMerchantId() {
        return GetSysUser.getSysUser().getMerchantId();
    }


    public String getUserName() {
        return GetSysUser.getSysUser().getUsername();
    }


    //获取所有首页显示内容
    @Override
    public MerchantInformation getMerchantInformation() {
        //获取商户id
        String merchantId = GetSysUser.getSysUser().getMerchantId();

        MerchantInformation merchantInformation = new MerchantInformation();
        //微信公众号数量
        int wxNumber = marketingMerchantWxMapper.countNumber();
        int wxFansNumber =marketingMerchantMapper.getFunsSum();
       /* //微信公众号粉丝数量
        if (!("".equals(marketingMerchantMapper.selectByPrimaryKey(merchantId).getFans()) ) && (marketingMerchantMapper.selectByPrimaryKey(merchantId).getFans() != null)) {
            wxFansNumber = marketingMerchantMapper.selectByPrimaryKey(merchantId).getFans();
        }*/
        //品牌数量
        int merchantBrandNumber = marketingBrandMapper.getBrandNumber();
        //会员数量
        int memberNumber = marketingMemberMapper.getAllWXMemberCount();
        merchantInformation.setMemberNumber(memberNumber);
        merchantInformation.setMerchantBrandNumber(merchantBrandNumber);
        merchantInformation.setWxFansNumber(wxFansNumber);
        merchantInformation.setWxNumber(wxNumber);
        return merchantInformation;
    }

    @Override
    public MerchantDefineData getMerchantDefineInformation(String url) {
        String urlName="";
        if(url.indexOf("www")!=-1){
            urlName=url.substring(url.indexOf("www.")+4, url.indexOf(".",url.indexOf("www.")+4));

        }else {
            urlName=url;
        }
        return merchantDefineDataMapper.selectByUrl(urlName);
    }

    @Override
    public List<MerchantDefineData> getMerchantDefineDataList() {
        return merchantDefineDataMapper.getMerchantDefineDataList();
    }

    @Override
    public void addMerchantDefineData(MerchantDefineData merchantDefineData) {
         merchantDefineData.setId(UuidUtils.getUUID());
         merchantDefineDataMapper.insert(merchantDefineData);
    }

    @Override
    public void updateMerchantDefineData(MerchantDefineData merchantDefineData) {
        merchantDefineDataMapper.updateByPrimaryKeySelective(merchantDefineData);
    }

    @Override
    public void deleteById(String id) {
        merchantDefineDataMapper.deleteByPrimaryKey(id);
    }
}
