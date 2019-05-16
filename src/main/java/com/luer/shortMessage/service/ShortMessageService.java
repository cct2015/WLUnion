package com.luer.shortMessage.service;

import com.luer.shortMessage.bean.FileMessage;
import com.luer.shortMessage.bean.ShortMessageSignature;
import com.luer.shortMessage.bean.ShortMessageTask;
import com.luer.shortMessage.bean.ShortMessageTask;
import com.luer.shortMessage.bean.TaskQuery;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ShortMessageService {

    //创建应用
    String appCreate( String name, String desc, Long staffId);

    //创建签名
    String signatureSave(ShortMessageSignature signatures);

    //上传文件
    FileMessage fileUpload(MultipartFile file);

    /*
     * 查询签名*/
    List<ShortMessageSignature> signatureQuery();

    ShortMessageTask messageTaskDetail(String id);
    /*
     * 短信任务-总个数查询*/
    String taskCount();
    /*
     * 短信任务-查询-按任务查*/
    List<ShortMessageTask> taskQueryByTask(TaskQuery taskQuery);
}
