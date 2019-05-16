package com.luer.marketingSchemeManage.controller;


import com.luer.comm.bean.ResultSet;
import com.luer.marketingSchemeManage.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通用请求处理
 *
 * @author wlmall
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;


    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {

         commonService.fileDownload(fileName,delete,response,request);

    }

    /**
     * 通用上传请求
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResultSet uploadFile(MultipartFile file) throws Exception {
        return commonService.uploadFile(file);

    }

    /**
     * 通用批量上传请求
     */
    @ResponseBody
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public ResultSet uploadFiles(@RequestParam(value = "files", required = false) MultipartFile[] files, @RequestParam("type") String type, @RequestParam("id") String id) {
        return commonService.uploadFiles(files,type,id);

    }

    /**
     * 通用批量获取文件夹所有图片请求
     */
    @ResponseBody
    @RequestMapping(value = "/getAllPathFile", method = RequestMethod.POST)
    public List<String> getAllPathFile(@RequestParam("type") String type, @RequestParam("id") String id) {

        return commonService.getAllPathFile(type,id);

    }

    @ResponseBody
    @RequestMapping(value = "/deleteFileByPath")
    public ResultSet deleteFileByPath(@RequestParam("path") String path) {
        return commonService.deleteFileByPath(path);



    }

}
