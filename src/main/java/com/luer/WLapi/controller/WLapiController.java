package com.luer.WLapi.controller;

import com.luer.WLapi.bean.DataEn;
import com.luer.WLapi.bean.OutMessage;
import com.luer.WLapi.service.IWLapiService;
import com.luer.comm.bean.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/WLapi")
public class WLapiController {

    private static Logger log = LoggerFactory.getLogger(WLapiController.class);



    @Autowired
    private IWLapiService wLapiService;
    @RequestMapping(value = "/importData", method = {RequestMethod.POST})
    public OutMessage importData(DataEn en)  {
        return  wLapiService.importData(en);
    }

    @RequestMapping(value = "/queryOrder", method = {RequestMethod.POST})
    public ResultSet queryOrder(DataEn en)throws Exception{

        return wLapiService.queryOrder(en);
    }
}
