package com.example.user.controller.File;

import com.example.common.aliyunOSS.AliyunOSSUtils;
import com.example.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/file")
@Api(value="/",tags ="文件接口")
public class FileController {

    @PostMapping("/upload")
    @ApiOperation(value = "图片上传")
    @ApiImplicitParam(name = "file", value = "文件信息", required = true ,dataType = "MultipartFile")
    public ResponseVO upload(@RequestParam("file")MultipartFile file){
        //如果文件为空 返回错误信息
        if(file.isEmpty()){
            return ResponseVO.buildFailure("empty files");
        }
        //获取原文件名
        String originalFilename = file.getOriginalFilename();

        String url = AliyunOSSUtils.uploadFileInputSteam(originalFilename,file);

        //返回图片的url
        return ResponseVO.buildSuccess(url);
    }

}
