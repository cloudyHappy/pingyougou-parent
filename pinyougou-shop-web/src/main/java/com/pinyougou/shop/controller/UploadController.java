package com.pinyougou.shop.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;

@RestController
public class UploadController {
    @Value("${FILE_SERVER_URL}")
    private String file_server_url;

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){

        try {
            FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
            //获取文件名
            String filename = file.getOriginalFilename();
            String extName = filename.substring(filename.lastIndexOf(".")+1);
            String fileId = client.uploadFile(file.getBytes(), extName);
            String url = file_server_url+fileId;
            return new Result(true,url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,e.getMessage());

        }

    }

}
