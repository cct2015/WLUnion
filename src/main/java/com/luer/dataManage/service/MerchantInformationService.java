package com.luer.dataManage.service;

import com.luer.comm.bean.ResultSet;
import com.luer.dataManage.bean.MerchantDefineData;
import com.luer.dataManage.bean.MerchantInformation;

import java.util.List;

/**
 * Created by 87961 on 2019/3/15.
 */
public interface MerchantInformationService {
    MerchantInformation getMerchantInformation();

    MerchantDefineData getMerchantDefineInformation(String url);

    List<MerchantDefineData> getMerchantDefineDataList();

    void addMerchantDefineData(MerchantDefineData merchantDefineData);

    void updateMerchantDefineData(MerchantDefineData merchantDefineData);

    void deleteById(String id);
}
