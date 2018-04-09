package com.coppco.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 图片上传控制器
 */

@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    /**
     * 图片上传
     * @param uploadFile 上传文件
     * @param request 请求request
     * @return
     */
    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map uploadImage(MultipartFile uploadFile, HttpServletRequest request) {
        System.out.println("图片上传");
        try {
            //原始文件名称
            String pictureFile_name =  uploadFile.getOriginalFilename();
            //新文件名称
            String newFileName = UUID.randomUUID().toString()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

            //上传图片
            File uploadPic = new File("image/" + newFileName);

            if(!uploadPic.exists()){
                uploadPic.mkdirs();
            }
            //向磁盘写文件
            uploadFile.transferTo(uploadPic);

            String path = request.getContextPath();//获取项目动态绝对路径
            Map result = new HashMap();
            result.put("error", 0);
            result.put("url", uploadPic.getAbsolutePath());
            System.out.println(result.toString());
            return result;
        } catch (Exception e) {
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            System.out.println(result.toString());
            return result;
        }

    }

}
