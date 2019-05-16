package com.luer.membershipManage.service.Impl;

import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.MD5Utils;
import com.luer.marketingSchemeManage.bean.MarketingPlanLabelExample;
import com.luer.membershipManage.bean.MarketingMember;
import com.luer.membershipManage.bean.MarketingMemberExample;
import com.luer.membershipManage.dao.MarketingMemberMapper;
import com.luer.membershipManage.service.MarketingMemberService;
import com.luer.comm.utils.UuidUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class MarketingMemberServiceImpl implements MarketingMemberService {
    @Autowired
    private MarketingMemberMapper marketingMemberMapper;


    public String getMerchantId() {
        return GetSysUser.getSysUser().getMerchantId();
    }

    @Override
    public void insert(MarketingMember marketingMember) {
        marketingMember.setId(UuidUtils.getUUID());
        marketingMemberMapper.insert(marketingMember);
    }

    @Override
    public void delete(String id) {
        marketingMemberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(MarketingMember marketingMember) {
        marketingMemberMapper.updateByPrimaryKeySelective(marketingMember);
    }

    @Override
    public List<MarketingMember> selectAll() {
        MarketingMemberExample example = new MarketingMemberExample();
        MarketingMemberExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(getMerchantId());
        List<MarketingMember> marketingMemberList = marketingMemberMapper.selectByExample(example);
        return marketingMemberList;
    }

    @Override
    public void importExcelMember(MultipartFile file) {
        List<MarketingMember> marketingMembers = new ArrayList<MarketingMember>();
        InputStream i = null;

        try {
            i = file.getInputStream();
            XSSFWorkbook book = new XSSFWorkbook(i);   //后缀xlsx       xls  HSSFWorkbook
            XSSFSheet sheet = book.getSheetAt(0); //每一个sheet
            for (int ii = 3; ii < sheet.getLastRowNum(); ii++) {
                MarketingMember member = new MarketingMember();
                XSSFRow row = sheet.getRow(ii);
                member.setId(UuidUtils.getUUID());
                if (row.getCell(0) != null) {
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    member.setPhone(MD5Utils.encryption(row.getCell(0).getStringCellValue()));
                }
                if (row.getCell(1) != null) {
                    member.setName(row.getCell(1).getStringCellValue());
                }
                if (row.getCell(2) != null) {
                    member.setEmail(row.getCell(2).getStringCellValue());
                }
                member.setMerchantId(getMerchantId());
                member.setSource(1);
                member.setStatus(0);
                member.setAddUser(GetSysUser.getSysUser().getUsername());
                member.setAddTime(new Date());
                marketingMembers.add(member);
            }
            i.close();
            marketingMemberMapper.importExcelMember(marketingMembers);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
