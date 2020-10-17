package com.example.user.controller;

import com.example.common.aliyunOSS.AliyunOSSUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
/**
 * @Author: Owen
 * @Date: 2020/10/16 11:29
 * @Description:
 */
@RestController
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        //如果文件为空 返回错误信息
        if(file.isEmpty()){
            return "empty files";
        }
        //获取原文件名
        String originalFilename = file.getOriginalFilename();

        //返回图片的url
        return AliyunOSSUtils.uploadFileInputSteam(originalFilename,file);
    }

}
