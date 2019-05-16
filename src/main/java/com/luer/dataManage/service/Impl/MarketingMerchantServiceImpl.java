package com.luer.dataManage.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.MerchentNumUtil;
import com.luer.dataManage.bean.MarketingBrand;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.bean.MerchantType;
import com.luer.dataManage.dao.MarketingBrandMapper;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.dataManage.service.MarketingMerchantService;
import com.luer.comm.utils.UuidUtils;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.bean.SysUsers;
import com.luer.privilegeManage.dao.SysUserMapper;
import com.luer.privilegeManage.bean.SysUserRole;
import com.luer.privilegeManage.dao.SysUserRoleMapper;
import com.luer.shortMessage.bean.SMSApp;
import com.luer.shortMessage.service.ShortMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class MarketingMerchantServiceImpl implements MarketingMerchantService {
    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MarketingBrandMapper marketingBrandMapper;
    @Autowired
    private ShortMessageService shortMessageService;

    public String getMerchantId() {
        return GetSysUser.getSysUser().getMerchantId();
    }

    @Override
    public void insert(MarketingMerchant marketingMerchant) {
        marketingMerchant.setId(UuidUtils.getUUID());
        marketingMerchant.setAddTime(new Date());

        //添加品牌
        List<MarketingBrand> marketingBrandList = new ArrayList<MarketingBrand>();
        String mainBrands = marketingMerchant.getMainBrand();
        if (mainBrands != null) {
            String[] mainBrandList = mainBrands.split(",");
            for (String brandName : mainBrandList) {
                MarketingBrand marketingBrand = new MarketingBrand();
                marketingBrand.setId(UuidUtils.getUUID());
                marketingBrand.setBrandName(brandName);
                marketingBrand.setMarketingId(marketingMerchant.getId());
                marketingBrandList.add(marketingBrand);
            }
            marketingBrandMapper.insertByMarketingBrandList(marketingBrandList);
        }


        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        String userName = user.getName();
        if (userName != null) {
            marketingMerchant.setAddUser(userName);
            marketingMerchant.setLastUpdater(userName);
        }
        if (marketingMerchant.getMarketingNo().equals(null)) {
            String marketingNo = String.valueOf(System.currentTimeMillis());
            marketingMerchant.setMarketingNo(marketingNo);
        }

        marketingMerchant.setLastUpdate(new Date());
        marketingMerchantMapper.insert(marketingMerchant);
    }

    @Override
    public void delete(String id) {
        marketingMerchantMapper.deleteByPrimaryKey(id);
        String userId = sysUserMapper.getMerchantIdUsers(id);
        marketingBrandMapper.deleteByMarketingId(id);
        sysUserMapper.deleteMerchantIdUsers(id);
        sysUserRoleMapper.deleteUserIdRole(userId);
    }

    @Override
    public void updateById(MarketingMerchant marketingMerchant) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        String userName = user.getName();
        if (userName != null) {
            marketingMerchant.setLastUpdater(userName);
        }
        marketingMerchant.setLastUpdate(new Date());
        //删除原有品牌
        marketingBrandMapper.deleteByMarketingId(marketingMerchant.getId());
        //添加新品牌
        List<MarketingBrand> marketingBrandList = new ArrayList<MarketingBrand>();
        String mainBrands = marketingMerchant.getMainBrand();
        if (mainBrands != null) {
            String[] mainBrandList = mainBrands.split(",");
            for (String brandName : mainBrandList) {
                MarketingBrand marketingBrand = new MarketingBrand();
                marketingBrand.setId(UuidUtils.getUUID());
                marketingBrand.setBrandName(brandName);
                marketingBrand.setMarketingId(marketingMerchant.getId());
                marketingBrandList.add(marketingBrand);
            }
            marketingBrandMapper.insertByMarketingBrandList(marketingBrandList);
        }
        marketingMerchantMapper.updateByPrimaryKeySelective(marketingMerchant);
    }

    @Override
    public List<MarketingMerchant> selectAll() {
        List<MarketingMerchant> marketingMerchantList = marketingMerchantMapper.selectAll();

        return marketingMerchantList;
    }

    @Override
    public void merchantAndUserInsert(String jsonStr, SysUser sysUser) throws Exception {
         MerchentNumUtil merchentNumUtil=new MerchentNumUtil();
        ObjectMapper oMapper = new ObjectMapper();
        MarketingMerchant marketingMerchant = null;
        Date d=new Date();
        DateFormat f=new SimpleDateFormat("yyyyMMdd");
        int count=marketingMerchantMapper.getMerchantCountToday(f.format(d));
        try {
            marketingMerchant = oMapper.readValue(jsonStr, MarketingMerchant.class);
            /*marketingMerchant.setId(UuidUtils.getUUID());*/

            marketingMerchant.setId(merchentNumUtil.getNumber(marketingMerchant.getMerchantType(),marketingMerchant.getMarketingNo(),count));

            marketingMerchant.setAddTime(new Date());
            marketingMerchant.setStatus(0);
            if (marketingMerchant.getParentId().length() < 10) {

                marketingMerchant.setParentId(getMerchantId());

            }
            SysUserRole sysUserRole = new SysUserRole();
            if (marketingMerchant.getMerchantType() == 0) {
                sysUser.setUserType("2");
                sysUserRole.setRoleId("angentid");
            } else if (marketingMerchant.getMerchantType() == 1) {
                sysUser.setUserType("4");
                sysUserRole.setRoleId("companyid");

               String result= shortMessageService.appCreate(marketingMerchant.getCompanyShort(),marketingMerchant.getCompanyName(),1001L);
               System.out.println("创建应用返回值==========="+result);
            }
            sysUser.setId(UUID.randomUUID().toString().replace("-", ""));
            sysUser.setMerchantId(marketingMerchant.getId());
            sysUser.setAddTime(new Date());
            sysUser.setActivateTime(new Date());
            sysUser.setStatus(0);
            sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
            sysUserRole.setId(UUID.randomUUID().toString().replace("-", ""));
            sysUserRole.setUserId(sysUser.getId());


            //添加品牌
            List<MarketingBrand> marketingBrandList = new ArrayList<MarketingBrand>();
            String mainBrands = marketingMerchant.getMainBrand();
            if (mainBrands != null) {
                String[] mainBrandList = mainBrands.split(",");
                for (String brandName : mainBrandList) {
                    MarketingBrand marketingBrand = new MarketingBrand();
                    marketingBrand.setId(UuidUtils.getUUID());
                    marketingBrand.setBrandName(brandName);
                    marketingBrand.setMarketingId(marketingMerchant.getId());
                    marketingBrandList.add(marketingBrand);
                }
                marketingBrandMapper.insertByMarketingBrandList(marketingBrandList);
            }
            marketingMerchantMapper.insert(marketingMerchant);
            sysUserMapper.insert(sysUser);
            sysUserRoleMapper.insert(sysUserRole);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过商户类别和商户级别查询商户
    @Override
    public List<MarketingMerchant> selectByTypeAndStep(int type, int step) {
        //如果是总部
        if (type == 3) {

            List<MarketingMerchant> marketingMerchantList = new ArrayList<MarketingMerchant>();
            MarketingMerchant marketingMerchant = marketingMerchantMapper.selectHead(getMerchantId());
            marketingMerchantList.add(marketingMerchant);
            return marketingMerchantList;
        }
        return marketingMerchantMapper.selectByTypeAndStep(type, step);
    }

    @Override
    public List<MarketingMerchant> selectByTypeAndParentId(int type, String parentId) {

        if (parentId == null | parentId == "") {
            parentId = GetSysUser.getSysUser().getMerchantId();
        }
        return marketingMerchantMapper.selectByTypeAndParentId(type, parentId);
    }

    //通过id查询商户
    @Override
    public List<MarketingMerchant> selectById(String id) {
        if (id == null | id == "") {
            id = GetSysUser.getSysUser().getMerchantId();
        }
        List<MarketingMerchant> marketingMerchantList = new ArrayList<MarketingMerchant>();
        MarketingMerchant marketingMerchant = marketingMerchantMapper.selectById(id);
        marketingMerchantList.add(marketingMerchant);
        return marketingMerchantList;
    }

    @Override
    public List<MarketingMerchant> getParentMerchant() {
        return marketingMerchantMapper.getParentMerchant(getMerchantId());
    }

    //条件查询
    @Override
    public List<MarketingMerchant> selectByType(String selectType, String selectValue, Integer merchantType) {

        SysUsers sysUsers = GetSysUser.getSysUser();
        String parentId = sysUsers.getMerchantId();
        if ("1".equals(selectType)) {//如果是企业名称
            return marketingMerchantMapper.selectByCompanyName(selectValue, merchantType, parentId);
        } else if ("2".equals(selectType)) {//如果是行业名称
            return marketingMerchantMapper.selectByIndustryName(selectValue, merchantType, parentId);
        } else if ("3".equals(selectType)) {//如果是地址
            return marketingMerchantMapper.selectByAddress(selectValue, merchantType, parentId);
        } else if ("4".equals(selectType)) {//如果是主营产品
            return marketingMerchantMapper.selectByMainProducts(selectValue, merchantType, parentId);
        } else if ("5".equals(selectType)) {//如果是主营品牌
            return marketingMerchantMapper.selectByMainBrand(selectValue, merchantType, parentId);
        }
        return null;
    }

    @Override
    public MerchantType getMerchantById() {
        MerchantType merchantType = new MerchantType();
        MarketingMerchant marketingMerchant = marketingMerchantMapper.selectByPrimaryKey(getMerchantId());
        int type = marketingMerchant.getMerchantType();
        if (type == 0) {
            merchantType.setMerchantType("0");
            merchantType.setName(marketingMerchant.getSystemName());

        } else if (type == 1) {
            MarketingMerchant merchant = marketingMerchantMapper.selectByPrimaryKey(marketingMerchant.getParentId());
            if (merchant.getMerchantType() == 3) {
                merchantType.setName("网陆数据联盟");
                merchantType.setMerchantType("1");
            } else {
                merchantType.setMerchantType("1");
                merchantType.setName(merchant.getSystemName());
            }


        } else if (type == 3) {
            merchantType.setMerchantType("3");
        }

        return merchantType;
    }

    @Override
    public List<SMSApp> selectByNow() {
        List<SMSApp> smsAppList = new ArrayList<>();
        SMSApp smsApp = marketingMerchantMapper.getSMSApp(GetSysUser.getSysUser().getMerchantId());
        smsAppList.add(smsApp);
        return smsAppList;
    }

    @Override
    public List<MarketingMerchant> selectMerchantByType() {
        return marketingMerchantMapper.selectMerchantByType();
    }
}
