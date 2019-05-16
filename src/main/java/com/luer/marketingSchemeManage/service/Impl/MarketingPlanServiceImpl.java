package com.luer.marketingSchemeManage.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jd.open.api.sdk.JdException;
import com.luer.JD.bean.GoodInformation;
import com.luer.JD.service.IJDservice;
import com.luer.comm.enums.PlanCheckEnum;
import com.luer.comm.enums.PlanExecuteEnum;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.UuidUtils;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.bean.MarketingMerchantExample;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.marketingSchemeManage.bean.*;
import com.luer.marketingSchemeManage.dao.*;
import com.luer.marketingSchemeManage.service.MarketingPlanService;
import com.luer.privilegeManage.dao.SysUserMapper;
import jd.union.open.goods.promotiongoodsinfo.query.response.PromotionGoodsResp;
import jd.union.open.goods.promotiongoodsinfo.query.response.UnionOpenGoodsPromotiongoodsinfoQueryResponse;
import jd.union.open.promotion.bysubunionid.get.response.PromotionCodeResp;
import jd.union.open.promotion.bysubunionid.get.response.UnionOpenPromotionBysubunionidGetResponse;
import lombok.ToString;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 87961 on 2018/12/18.
 */
@ToString
@Service
@Transactional
public class MarketingPlanServiceImpl implements MarketingPlanService {
    @Autowired
    private MarketingPlanMapper marketingPlanMapper;
    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;
    @Autowired
    private MarketingPlanLabelMapper marketingPlanLabelMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private IJDservice ijDservice;
    @Autowired
    MarketingPlanRecommendMapper marketingPlanRecommendMapper;

    @Autowired
    private VPlanRecommendMapper vPlanRecommendMapper;

    @Autowired
    private VValueabledPlansMapper vValueabledPlansMapper;

    @Override
    public String getMerchantId() {
        return GetSysUser.getSysUser().getMerchantId();
    }

    @Override
    public String getUserName() {
        return GetSysUser.getSysUser().getUsername();
    }

    @Override
    public List<MarketingPlan> getMarketingPlan() {
        return null;
    }


    @Override
    public String addMarketingPlan(MarketingPlan marketingPlan) {
        marketingPlan.setId(UuidUtils.getUUID());
        String id = marketingPlan.getId();
        marketingPlanMapper.insert(marketingPlan);
        return id;
    }

    @Override
    public String updateMarketingPlan(MarketingPlan marketingPlan) {
        String id = marketingPlan.getId();
        marketingPlan.setLastUpdate(new Date());
        marketingPlan.setLastUpdater(getUserName());
        marketingPlanMapper.updateByPrimaryKeySelective(marketingPlan);
        return id;
    }


    @Override
    public List<String> selectMerchantByParentId(String id) {
        List<String> merchantIdList = null;
        MarketingMerchantExample marketingMerchantExample = new MarketingMerchantExample();
        MarketingMerchantExample.Criteria marketingMerchantExampleCriteria = marketingMerchantExample.createCriteria();
        marketingMerchantExampleCriteria.andParentIdEqualTo(id);
        List<MarketingMerchant> marketingMerchantList = marketingMerchantMapper.selectByExample(marketingMerchantExample);
        merchantIdList = new ArrayList();
        for (MarketingMerchant marketingMerchant : marketingMerchantList) {
            merchantIdList.add(marketingMerchant.getId());
        }
        return merchantIdList;
    }

    ////总部功能
    @Override
    public List<MarketingPlan> getMarketingPlanInHQByPlanStatus(String status) {

        List<MarketingPlan> marketingPlanList = null;

        if (status != null && (!"".equals(status))) {
            marketingPlanList = marketingPlanMapper.selectByStatus(status);
        } else {
            marketingPlanList = marketingPlanMapper.selectAll();
        }


        return marketingPlanList;
    }

    @Override
    public List<MarketingPlan> getHistroyMarketingPlanInHQ(String planStatus) {

        List<MarketingPlan> marketingPlanList = null;
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andEndTimeLessThan(new Date());
        if (planStatus != null && (!"".equals(planStatus))) {
            Integer planStatusInt = Integer.parseInt(planStatus);
            criteria.andPlanStatusEqualTo(planStatusInt);
        }
        marketingPlanList = marketingPlanMapper.selectByExample(example);

        return marketingPlanList;
    }

    ///代理商功能
    @Override
    public List<MarketingPlan> getMarketingPlanInAgentByPlanStatus(String planStatus) {
        List<MarketingPlan> marketingPlanList = null;
        List<String> merchantIdList = selectMerchantByParentId(getMerchantId());
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdIn(merchantIdList);
        if (planStatus != null) {
            Integer planStatusInt = Integer.parseInt(planStatus);
            criteria.andPlanStatusEqualTo(planStatusInt);
        }
        marketingPlanList = marketingPlanMapper.selectByExample(example);
        return marketingPlanList;
    }

    ///企业功能
    @Override
    public List<MarketingPlan> getMarketingPlanInEnterprise(int status) {
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        criteria.andStatusEqualTo(status);
        return marketingPlanMapper.selectByExample(example);
    }

    @Override
    public MarketingPlan getMarketingPlanInEnterpriseById(String id) {
        return marketingPlanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addMarketingPlanInEnterprise(MarketingPlan marketingPlan) {
        marketingPlan.setId(UuidUtils.getUUID());
        marketingPlan.setAddTime(new Date());
        marketingPlan.setAddUser(GetSysUser.getSysUser().getUsername());
        marketingPlan.setStatus(PlanCheckEnum.NEW.getValue());
        marketingPlan.setMerchantId(GetSysUser.getSysUser().getMerchantId());
        int res1 = marketingPlanMapper.insert(marketingPlan);
        //还要插入标签
        List<MarketingPlanLabel> list = new ArrayList<MarketingPlanLabel>();
        String keysStr = marketingPlan.getSelLabelKeys();
        if (keysStr != null && !"".equals(keysStr)) {
            String[] keys = keysStr.split(",");
            MarketingPlanLabel label = null;
            for (int i = 0; i < keys.length; i++) {
                label = new MarketingPlanLabel();
                label.setId(UuidUtils.getUUID());
                label.setPlanId(marketingPlan.getId());
                label.setLabelId(keys[i]);
                list.add(label);
            }
        } else {
            return res1;
        }
        int res2 = marketingPlanLabelMapper.insertBatch(list);
        return (res1 > 0 && res2 > 0) ? 1 : 0;
    }

    @Override
    public int deleteMarketingPlanInEnterprise(String id) {
        return marketingPlanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateMarketingPlanInEnterprise(MarketingPlan marketingPlan) {
        System.out.println(marketingPlan);
        if (marketingPlan.getStatus() != null && marketingPlan.getStatus() == 1) {
            marketingPlan.setPlanStatus(PlanCheckEnum.NEW.getValue());
        }
        marketingPlan.setLastUpdate(new Date());
        marketingPlan.setLastUpdater(GetSysUser.getSysUser().getUsername());
        int res1 = marketingPlanMapper.updateByPrimaryKeySelective(marketingPlan);

        //删除以前的
        marketingPlanLabelMapper.deletePlanLabels(marketingPlan.getId());
        //还要插入标签
        List<MarketingPlanLabel> list = new ArrayList<MarketingPlanLabel>();
        String keysStr = marketingPlan.getSelLabelKeys();
        if (keysStr != null && !"".equals(keysStr)) {
            String[] keys = keysStr.split(",");
            MarketingPlanLabel label = null;
            for (int i = 0; i < keys.length; i++) {
                label = new MarketingPlanLabel();
                label.setId(UuidUtils.getUUID());
                label.setPlanId(marketingPlan.getId());
                label.setLabelId(keys[i]);
                list.add(label);
            }
        } else {
            return res1;
        }
        int res2 = marketingPlanLabelMapper.insertBatch(list);
        return (res1 > 0 && res2 > 0) ? 1 : 0;
    }

    /*设置优惠卷连接*/
    @Override
    @Transactional
    public int couponMarketingPlanInEnterprise(String id, String arrayStr, String couponUrl, String couponsSource, int isDifferent) {
        /*垂直营销*/
        int res1 = marketingPlanMapper.couponMarketingPlan(couponUrl, couponsSource, id);
        System.out.println("id================"+id);
        Integer planStatus=0;
        System.out.println("planStatus============="+planStatus);

        marketingPlanMapper.updatePlanStatusById(id,planStatus);
        if (isDifferent == 1) //异业推送
        {
            List<MarketingPlanRecommend> list = new ArrayList<MarketingPlanRecommend>();
            MarketingPlanRecommend marketingPlanRecommend = null;
            //获得所有企业商户，
            JSONArray jsonArray = JSONArray.fromObject(arrayStr);
            for (int i = 0; i < jsonArray.size(); i++) {
                net.sf.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
                marketingPlanRecommend = new MarketingPlanRecommend();
                marketingPlanRecommend.setId(UuidUtils.getUUID());
                marketingPlanRecommend.setPlanId(id);
                marketingPlanRecommend.setMerchantId(jsonObject.getString("merchantId"));

                marketingPlanRecommend.setStatus(PlanExecuteEnum.WAIT.getValue());
                marketingPlanRecommend.setAddTime(new Date());
                marketingPlanRecommend.setRecommendUser(GetSysUser.getSysUser().getUsername());
                marketingPlanRecommend.setCouponUrl(jsonObject.getString("couponUrl"));
                System.out.println("=================");
                System.out.println(marketingPlanRecommend);
                list.add(marketingPlanRecommend);

            }
            if (list.size() > 0) {
                int res2 = marketingPlanRecommendMapper.insertBatch(list);
                return (res1 > 0 && res2 > 0) ? 1 : 0;
            }
        }




        return res1 > 0 ? 1 : 0;
    }

    @Override
    public int addMarketingPlanDotInEnterprise(String marketingPlanStr, String marketingPlanLabelStr) {
        int num = 0;
        MarketingPlan marketingPlan = JSON.parseObject(marketingPlanStr, new TypeReference<MarketingPlan>() {
        });
        ArrayList<MarketingPlanLabel> depotReceiptDetailList = JSON.parseObject(marketingPlanLabelStr, new TypeReference<ArrayList<MarketingPlanLabel>>() {
        });
        num += addMarketingPlanInEnterprise(marketingPlan);
        for (MarketingPlanLabel marketingPlanLabel : depotReceiptDetailList) {
            marketingPlanLabel.setId(UuidUtils.getUUID());
            marketingPlanLabel.setPlanId(marketingPlan.getId());
            num += marketingPlanLabelMapper.insert(marketingPlanLabel);
        }
        return num;
    }

    @Override
    public int deleteMarketingPlanDotInEnterprise(String id) {
        int num = 0;
        num += deleteMarketingPlanInEnterprise(id);
        MarketingPlanLabelExample example = new MarketingPlanLabelExample();
        MarketingPlanLabelExample.Criteria criteria = example.createCriteria();
        criteria.andPlanIdEqualTo(id);
        num += marketingPlanLabelMapper.deleteByExample(example);
        return num;
    }

    @Override
    public List<MarketingPlan> getExecutingMarketingPlanInEnterprise() {
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        criteria.andStatusEqualTo(1);
        criteria.andEndTimeGreaterThan(new Date());
        criteria.andPlanStatusEqualTo(2);
        return marketingPlanMapper.selectByExample(example);
    }

    @Override
    public List<MarketingPlan> getCheckMarketingPlanInEnterprise() {
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        criteria.andMerchantIdEqualTo(getMerchantId());
        return marketingPlanMapper.selectByExample(example);
    }

    @Override
    public List<VPlanRecommend> getOtherMarketingPlan(int status) {
        VPlanRecommendExample example = new VPlanRecommendExample();
        VPlanRecommendExample.Criteria criteria = example.createCriteria();
//        List<Integer> list=new ArrayList<Integer>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
        criteria.andStatusEqualTo(status);
        criteria.andMerchantIdEqualTo(getMerchantId());
        return vPlanRecommendMapper.selectByExample(example);
    }

    @Override
    public int acceptMarketingPlanInEnterprise(MarketingPlanRecommend marketingPlanRecommend) {
        marketingPlanRecommend.setMerchantId(GetSysUser.getSysUser().getMerchantId());
        return marketingPlanRecommendMapper.accptPlan(marketingPlanRecommend);
    }

    @Override
    public List<MarketingPlan> getMarketingPlanExamine() {
        List<MarketingPlan> marketings = new ArrayList<MarketingPlan>();
        List<MarketingPlan> marketingPlans = marketingPlanMapper.getMarketingPlanExamine(getMerchantId());
        System.out.println("size" + marketingPlans.size());
        for (MarketingPlan marketingPlan : marketingPlans) {
            if (marketingPlan.getPlanStatus() == null) {
                marketings.add(marketingPlan);
            }
        }
        System.out.println("size" + marketings.size());
        return marketings;
    }

    @Override
    public int examineMarketingPlan(MarketingPlan marketingPlan) {
        /*if (marketingPlan.getStatus() == 1) {
            marketingPlan.setPlanStatus(0);
        }*/
        marketingPlan.setChecker(getUserName());
        Integer isDifferent = marketingPlan.getIsDifferent();

        int res1 = marketingPlanMapper.updateByPrimaryKeySelective(marketingPlan);
//        if (isDifferent == 1 && marketingPlan.getStatus() == 1) //异业推送，暂时就是推荐给除了自己外的每一个商户，以后再修正
//        {
//
//            List<MarketingPlanRecommend> list = new ArrayList<MarketingPlanRecommend>();
//            //获得所有企业商户，
//            List<MarketingMerchant> templist = marketingMerchantMapper.selectEnterpriseMerchant();
//            MarketingPlanRecommend marketingPlanRecommend = null;
//            for (MarketingMerchant merchant : templist) {
//                if (!merchant.getId().equals(marketingPlan.getMerchantId())) {
//                    marketingPlanRecommend = new MarketingPlanRecommend();
//                    marketingPlanRecommend.setId(UuidUtils.getUUID());
//                    marketingPlanRecommend.setPlanId(marketingPlan.getId());
//                    marketingPlanRecommend.setMerchantId(merchant.getId());
//                    marketingPlanRecommend.setStatus(PlanExecuteEnum.WAIT.getValue());
//                    marketingPlanRecommend.setAddTime(new Date());
//                    marketingPlanRecommend.setRecommendUser(GetSysUser.getSysUser().getUsername());
//                    list.add(marketingPlanRecommend);
//                }
//            }
//            if (list.size() > 0) {
//                int res2 = marketingPlanRecommendMapper.insertBatch(list);
//                return (res1 > 0 && res2 > 0) ? 1 : 0;
//            }
//        }
        return res1;
    }

    @Override
    public List<MarketingPlanPacking> getExecuteMarketingPlanPacking() {
        List<MarketingPlanPacking> marketingPlanPackings = new ArrayList<MarketingPlanPacking>();
//        String companyName=marketingMerchantMapper.selectByPrimaryKey(getMerchantId()).getCompanyName();
//        //获取本企业营销方案执行状态
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        criteria.andIsDifferentEqualTo(1);
        criteria.andStatusEqualTo(1);
//        List<Integer> list=new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        criteria.andPlanStatusIn(list);
//
        List<MarketingPlan> marketingPlans = marketingPlanMapper.selectByExample(example);
        if (marketingPlans != null) {

            for (MarketingPlan marketingPlan : marketingPlans) {
                MarketingPlanRecommendExample exampleOne = new MarketingPlanRecommendExample();
                MarketingPlanRecommendExample.Criteria criteriaOne = exampleOne.createCriteria();
                criteriaOne.andPlanIdEqualTo(marketingPlan.getId());
                List<MarketingPlanRecommend> marketingPlanRecommends = marketingPlanRecommendMapper.selectByExample(exampleOne);
                for (MarketingPlanRecommend marketingPlanRecommend : marketingPlanRecommends) {
                    MarketingPlanPacking marketingPlanPacking = new MarketingPlanPacking();
                    MarketingMerchant marketingMerchant = marketingMerchantMapper.selectById(marketingPlanRecommend.getMerchantId());
                    marketingPlanPacking.setId(marketingPlanRecommend.getId());
                    if (marketingPlan.getTitle() != null) {
                        marketingPlanPacking.setMarketingPlanTitle(marketingPlan.getTitle());
                    }
                    if (marketingPlan.getContent() != null) {
                        marketingPlanPacking.setMarketingPlanContent(marketingPlan.getContent());
                    }
                    if (marketingMerchant.getCompanyName() != null) {
                        marketingPlanPacking.setCompanyName(marketingMerchant.getCompanyName());
                    }

                    marketingPlanPacking.setStatus(marketingPlanRecommend.getStatus());
                    marketingPlanPackings.add(marketingPlanPacking);
                }
            }
        }

        return marketingPlanPackings;
    }

    @Override
    public List<MarketingPlan> getSelfExecuteMarketingPlanPacking() {
        //List<MarketingPlanPacking> marketingPlanPackings=new ArrayList<MarketingPlanPacking>();
        String companyName = marketingMerchantMapper.selectByPrimaryKey(getMerchantId()).getCompanyName();
        //获取本企业营销方案执行状态
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        List<Integer> list = new ArrayList<Integer>();
        list.add(PlanCheckEnum.PASS.getValue());//审核通过的
        list.add(PlanCheckEnum.NOTPASS.getValue());//没通过的
        criteria.andStatusIn(list);

        List<MarketingPlan> marketingPlanslist = marketingPlanMapper.selectByExample(example);
        for (MarketingPlan marketingPlan : marketingPlanslist) {
            marketingPlan.setMerchant(companyName);
        }

//        if(marketingPlans!=null){
//            for (MarketingPlan marketingPlan:marketingPlans){
//                MarketingPlanPacking marketingPlanPacking=new MarketingPlanPacking();
//                marketingPlanPacking.setId(marketingPlan.getId());
//                marketingPlanPacking.setCompanyName(companyName);
//                marketingPlanPacking.setMarketingPlanTitle(marketingPlan.getTitle());
//                Integer planStatus=marketingPlan.getPlanStatus();
//                if(planStatus==null)
//                    marketingPlanPacking.setCompanySelfExecuteStatus("0");
//                else
//                marketingPlanPacking.setCompanySelfExecuteStatus(marketingPlan.getPlanStatus().toString());
//                //marketingPlanMerchantMapper.getExecuteStstus(marketingPlan.getId())
//               // marketingPlanPacking.setPartnersSelfExecuteStatus().getExecuteStatus());
//                marketingPlanPackings.add(marketingPlanPacking);
//            }
//        }
        return marketingPlanslist;
    }

    @Override
    public List<MarketingPlan> getCanAcceptMarketingPlanInEnterprise() {
        MarketingPlanExample example = new MarketingPlanExample();
        MarketingPlanExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        criteria.andEndTimeGreaterThan(new Date());
        criteria.andPlanStatusEqualTo(0);
        return marketingPlanMapper.selectByExample(example);
    }

    //获得要执行的营销方案列表,分页，包括异业推荐已经接受的和自己的
    @Override
    public List<VValueabledPlans> getExecutePlanList() {
        VValueabledPlansExample example = new VValueabledPlansExample();
        VValueabledPlansExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        criteria.andStatusEqualTo(PlanExecuteEnum.ACCEPTED.getValue());

        return vValueabledPlansMapper.selectByExample(example);

    }

    //获得要触达的营销方案列表,分页
    @Override
    public List<VValueabledPlans> getTouchPlanList() {
        VValueabledPlansExample example = new VValueabledPlansExample();
        VValueabledPlansExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        criteria.andStatusEqualTo(PlanExecuteEnum.EXCUTEOVER.getValue());
        return vValueabledPlansMapper.selectByExample(example);

    }

    @Override
    public List<MarketingPlan> getMarketingPlanlower() {
        MarketingMerchantExample example = new MarketingMerchantExample();
        MarketingMerchantExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(getMerchantId());
        List<MarketingMerchant> marketingMerchants = marketingMerchantMapper.selectByExample(example);
        List<String> merchantids = new ArrayList<String>();
        for (MarketingMerchant marketingMerchant : marketingMerchants) {
            merchantids.add(marketingMerchant.getId());
        }


        return marketingPlanMapper.getMarketingPlanlower(merchantids);
    }

    @Override
    public void addMarketingPlanByJD(String merchants, String good) throws IOException {
        ObjectMapper oMapper = new ObjectMapper();
        GoodInformation goodInformation = oMapper.readValue(good, GoodInformation.class);
        MarketingPlan marketingPlan = new MarketingPlan();
        /*System.out.println("goodInformation.getGoodsId()=="+goodInformation.getGoodsId());
        System.out.println("goodInformation.getMaterialId()=="+goodInformation.getMaterialId());
        System.out.println("goodInformation.getCouponUrl()=="+goodInformation.getCouponUrl());*/
        if (goodInformation.getGoodsId() != null) {
            try {
                UnionOpenGoodsPromotiongoodsinfoQueryResponse response = ijDservice.goodsinfoQuery(goodInformation.getGoodsId());
                PromotionGoodsResp[] data = response.getData();
                if (data.length != 0) {

                    PromotionGoodsResp promotionGoodsResp = data[0];
                    //商品ID
                    Long skuId = promotionGoodsResp.getSkuId();
                    //单价
                    Double unitPrice = promotionGoodsResp.getUnitPrice();
                    //商品落地页
                    String materialUrl = promotionGoodsResp.getMaterialUrl();
                    //结束时间
                    Long endDate = promotionGoodsResp.getEndDate();
                    //是否免运险费
                    Integer isFreeFreightRisk = promotionGoodsResp.getIsFreeFreightRisk();
                    //是否包邮
                    Integer isFreeShipping = promotionGoodsResp.getIsFreeShipping();
                    //佣金比例
                    Double commisionRatioWl = promotionGoodsResp.getCommisionRatioWl();
                    //佣金比例原则
                    Double commisionRatioPc = promotionGoodsResp.getCommisionRatioPc();
                    //商品图片链接
                    String imgUrl = promotionGoodsResp.getImgUrl();
                    Long vid = promotionGoodsResp.getVid();
                    //一级类目名称
                    String cidName = promotionGoodsResp.getCidName();
                    Double wlUnitPrice = promotionGoodsResp.getWlUnitPrice();
                    //二级类目名称
                    String cid2Name = promotionGoodsResp.getCid2Name();
                    //是否是秒杀商品
                    Integer isSeckill = promotionGoodsResp.getIsSeckill();
                    //二级类目id
                    Long cid2 = promotionGoodsResp.getCid2();
                    //三级类目名称
                    String cid3Name = promotionGoodsResp.getCid3Name();
                    //引单数量
                    Long inOrderCount = promotionGoodsResp.getInOrderCount();
                    //3级类目id
                    Long cid3 = promotionGoodsResp.getCid3();
                    //店铺id
                    Long shopId = promotionGoodsResp.getShopId();
                    //是否自营 (1 : 是, 0 : 否)，后续会废弃，请用owner
                    Integer isJdSale = promotionGoodsResp.getIsJdSale();
                    //商品名称
                    String goodsName = promotionGoodsResp.getGoodsName();
                    //开始时间
                    Long startDate = promotionGoodsResp.getStartDate();
                    //一级类目id
                    Long cid = promotionGoodsResp.getCid();

                    marketingPlan.setId(UuidUtils.getUUID());
                    marketingPlan.setTitle(goodsName);
                    marketingPlan.setContent("京东商品优惠大放送，"+goodsName+"领取优惠劵，享优惠！");
                    marketingPlan.setUsageRule("京东线上使用");
                    marketingPlan.setIsDifferent(0);
                    marketingPlan.setStatus(1);
                    marketingPlan.setMerchantId(getMerchantId());
                    marketingPlan.setBeginTime(new Date(startDate));
                    marketingPlan.setEndTime(new Date(endDate));
                    marketingPlan.setAddTime(new Date());
                    marketingPlan.setAddUser(getUserName());
                    marketingPlan.setIsDifferent(1);
                    marketingPlan.setCommissionTypeOne(commisionRatioWl.toString());
                    marketingPlan.setOtherDescripe("佣金比例" + commisionRatioWl + "%");
                    marketingPlanMapper.insert(marketingPlan);
                }

            } catch (JdException e) {
                e.printStackTrace();
            }
        }
        JSONArray merchantArray = JSONArray.fromObject(merchants);
        List list = (List) JSONArray.toCollection(merchantArray, MarketingMerchant.class);
        Iterator it = list.iterator();
        if (goodInformation.getGoodsId() != null && goodInformation.getCouponUrl() != null && goodInformation.getMaterialId() != null) {
            while (it.hasNext()) {
                MarketingMerchant p = (MarketingMerchant) it.next();
                MarketingPlanRecommend marketingPlanRecommend = new MarketingPlanRecommend();
                try {
                    UnionOpenPromotionBysubunionidGetResponse response = ijDservice.getURLBysubunionid(goodInformation.getMaterialId(), p.getId(), goodInformation.getCouponUrl());
                    PromotionCodeResp promotionCodeResp = response.getData();
                    marketingPlanRecommend.setAddTime(new Date());
                    marketingPlanRecommend.setId(UuidUtils.getUUID());
                    marketingPlanRecommend.setMerchantId(p.getId());
                    marketingPlanRecommend.setPlanId(marketingPlan.getId());
                    marketingPlanRecommend.setStatus(0);
                    marketingPlanRecommend.setRecommendUser(getUserName());
                    marketingPlanRecommend.setCouponUrl(promotionCodeResp.getShortURL());
                    /*System.out.println(marketingPlanRecommend.toString());*/
                    marketingPlanRecommendMapper.insert(marketingPlanRecommend);
                } catch (JdException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
