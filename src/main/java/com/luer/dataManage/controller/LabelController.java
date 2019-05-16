package com.luer.dataManage.controller;

import com.luer.dataManage.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cloud on 2018/12/17.
 */

@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @ResponseBody
    @RequestMapping("/getLabels")
    public Object getLabels(){

        return labelService.getLabels();
    }
}
