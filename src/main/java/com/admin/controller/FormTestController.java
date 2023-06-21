package com.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Frailty
 * @date 2023年03月07日 22:10
 */
/**
 * 文件上传测试
 */
@Controller
@Slf4j
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
    
    /*
     * @Description:MultipartFile 自动封装上传过来的文件
     * @author Frailty
     * @date 2023/3/7 22:23
     * @param email
     * @param username
     * @param headerImg
     * @param photos 
     * @return java.lang.String
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",
                email,username,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            //保存到文件服务器，如OSS服务器，这里选择保存在本地某个文件夹
            //可以在配置文件中更改单次传输文件大小
            final String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\springbootTest\\"+filename));
        }
        
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()) {
                    final String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\springbootTest\\" + filename));
                }
            }
        }
        return "main";
    }
}
