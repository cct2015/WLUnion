package com.luer.marketingSchemeManage.service.Impl;

import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.FileUtil;
import com.luer.marketingSchemeManage.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    private static final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);
    @Autowired
    private FileUtil fileUtil;


    @Override
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
        try {
            String filePath = fileUtil.getDefaultBaseDir() + "download/" + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + setFileDownloadHeader(request, realFileName));
            FileUtil.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtil.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    @Override
    public ResultSet uploadFile(MultipartFile file) {

        try {
            // 上传文件路径
            String filePath = fileUtil.getDefaultBaseDir();
            // 上传并返回新文件名称
            String fileName = FileUtil.upload(filePath, file);
            String url = fileUtil.getDefaultBaseDir() + "upload/" + fileName;
            ResultSet ajax = ResultSet.getSuccess();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return ResultSet.getFail(e.getMessage());
        }
    }

    @Override
    public ResultSet uploadFiles(MultipartFile[] files, String type, String id) {
        if ((files == null) || (files.length == 0)) {
            return ResultSet.getFail("文件为空");
        }
        try {
            // 上传文件路径
            String filePath = fileUtil.getDefaultBaseDir() + "/" + id + "/" + type + "/";
            List<String> urlList = new ArrayList<>();
            // 上传并返回新文件名称
            for (MultipartFile file : files) {
                String fileName = FileUtil.upload(filePath, file);
                urlList.add(filePath + "/" + fileName);
            }
            return ResultSet.getSuccess(urlList);
        } catch (Exception e) {
            return ResultSet.getFail(e.getMessage());
        }
    }

    @Override
    public List<String> getAllPathFile(String type, String id) {
        /*文件夹路径*/
        List<String> filePathList = new ArrayList<>();
        String filePath = fileUtil.getDefaultBaseDir() + "/" + id + "/" + type;
        File file = new File(filePath);
        //如果是目录
        if (file.isDirectory()) {
            //获取当前目录下所以文件
            File[] files = file.listFiles();
            for (File file1 : files) {
                String fileName = file1.getName();
                String path = getUrl() + "/profile/" + id + "/" + type + "/" + fileName;
                filePathList.add(path);
            }
            return filePathList;
        }
        return null;
    }

    /*根据路径删除文件*/
    @Override
    public ResultSet deleteFileByPath(String path) {
        String[] str = path.split("profile");
        if (str.length > 1) {
            String url = fileUtil.getDefaultBaseDir() + str[1];
            if (FileUtil.deleteFile(url)) {
                return ResultSet.getSuccess();
            } else {
                return ResultSet.getFail();
            }
        }
        return ResultSet.getFail();
    }

    /*获取ip和端口*/
    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
           System.out.println("-----------UnknownHostException------------");
            //return "http://59.111.94.125" + ":" + fileUtil.getServerPort();
            return "http://www.wanglu163.com"+ ":" + fileUtil.getServerPort();

        }

        return "http://" + address.getHostAddress() + ":" + fileUtil.getServerPort();
    }

    public String setFileDownloadHeader(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        } else if (agent.contains("Chrome")) {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
