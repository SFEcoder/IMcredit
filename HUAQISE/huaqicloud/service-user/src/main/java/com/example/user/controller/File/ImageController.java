package com.example.user.controller.File;

import com.example.common.aliyunOSS.AliyunOSSUtils;
import com.example.common.vo.ResponseVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
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
public class ImageController {

    @PostMapping("/upload")
    @ApiOperation(value = "图片上传")
    @ApiImplicitParam(name = "file", value = "文件信息", required = true ,dataType = "MultipartFile")
    public ResponseVO upload(@RequestParam("file")MultipartFile file){
        //如果文件为空 返回错误信息
        if(file.isEmpty()){
            return ResponseVO.buildSuccess("empty files");
        }
        //获取原文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        //返回图片的url
        String url=(AliyunOSSUtils.uploadFileInputSteam(originalFilename,file));
        System.out.println((String) url);
        return ResponseVO.buildSuccess(url);
    }

}
