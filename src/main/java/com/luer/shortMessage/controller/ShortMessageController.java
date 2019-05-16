package com.luer.shortMessage.controller;


import com.luer.comm.bean.ResultSet;
import com.luer.shortMessage.bean.FileMessage;
import com.luer.shortMessage.bean.ShortMessageSignature;
import com.luer.shortMessage.bean.ShortMessageTask;
import com.luer.shortMessage.bean.TaskQuery;
import com.luer.shortMessage.service.ShortMessageService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/shortMessage")
@Controller
public class ShortMessageController {

    @Autowired
    private ShortMessageService shortMessageService;


    /*
     * 创建应用*/
    @ResponseBody
    @RequestMapping("/appCreate")
    public String appCreate(String name,String desc,Long staffId) {
        /*postParams2();*/
        String result = shortMessageService.appCreate( name, desc, staffId);
        return result;
    }

    /*
     * 签名-查询*/
    @ResponseBody
    @RequestMapping("/signatureQuery")
    public  List<ShortMessageSignature> signatureQuery() {
        List<ShortMessageSignature> shortMessageSignatureList = shortMessageService.signatureQuery();
        return shortMessageSignatureList;
    }
    /*
     * 签名-创建|更新*/
    @ResponseBody
    @RequestMapping("/signatureSave")
    public ResultSet signatureSave(ShortMessageSignature shortMessageSignature) {
        String result = shortMessageService.signatureSave(shortMessageSignature);
        JSONObject rj = JSONObject.fromObject(result);
        String res=null;
        if (rj.getString("code").equals("200")) {
            res="短信模板创建成功";
            return ResultSet.getSuccess(result);
        }else{
            res=rj.getString("message");
            return ResultSet.getFail(result);
        }
       // return result;
    }
    /*
     * 上传文件*/
    @ResponseBody
    @RequestMapping(value="/fileUpload",method = RequestMethod.POST)
    public FileMessage fileUpload(@RequestParam(value="file",required=false) MultipartFile file) {

        FileMessage fileMessage = shortMessageService.fileUpload(file);
        return fileMessage;
    }
    /*
     * 短信任务-详情*/
    @ResponseBody
    @RequestMapping(value="/messageTaskDetail",method = RequestMethod.POST)
    public ShortMessageTask messageTaskDetail(String id) {

        ShortMessageTask shortMessageTask = shortMessageService.messageTaskDetail(id);
        return null;
    }

    /*
    * 短信任务-查询-按任务查*/
    @ResponseBody
    @RequestMapping("/taskQueryByTask")
    public  List<ShortMessageTask> taskQueryByTask(TaskQuery taskQuery) {
        List<ShortMessageTask> shortMessageSignatureList = shortMessageService.taskQueryByTask(taskQuery);
        return shortMessageSignatureList;
    }

    /*
     * 短信任务-总个数查询*/
    @ResponseBody
    @RequestMapping("/taskCount")
    public String taskCount() {
        String count = shortMessageService.taskCount();
        return count;
    }
}
