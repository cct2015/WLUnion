package com.luer.membershipManage.service;

import com.luer.membershipManage.bean.MarketingMember;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface MarketingMemberService {

    void insert(MarketingMember marketingMember);

    void delete(String id);

    void updateById(MarketingMember marketingMember);

    List<MarketingMember> selectAll();

    void importExcelMember(MultipartFile file);
}
