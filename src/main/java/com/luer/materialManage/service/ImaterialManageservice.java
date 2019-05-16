package com.luer.materialManage.service;

import net.sf.json.JSONObject;

public interface ImaterialManageservice {
    JSONObject queryMaterialList (String appId,String msgtype,int offset);
}
