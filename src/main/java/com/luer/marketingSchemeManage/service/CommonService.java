package com.luer.marketingSchemeManage.service;

import com.luer.comm.bean.ResultSet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CommonService {
    void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request);

    ResultSet uploadFile(MultipartFile file);

    ResultSet uploadFiles(MultipartFile[] files, String type, String id);

    List<String> getAllPathFile(String type, String id);

    ResultSet deleteFileByPath(String path);
}
