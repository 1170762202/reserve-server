package com.zlx.reverce.controller;

import com.alibaba.fastjson.JSON;
import com.zlx.reverce.config.FileServerConfig;
import com.zlx.reverce.util.FileUploadUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author 1170762202@qq.com
 * @2019-09-24 13:27
 * 说明：
 */
@RestController
@RequestMapping("/file")
public class FileController {


    /**
     * 保存文件
     *
     * @param file 文件
     * @return 结果
     */
    @PostMapping("/updateFile")
    @ResponseBody
    public Object updateFile(@RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = FileUploadUtils.uploadText(FileServerConfig.getUploadPath(), file);
                System.out.println("fileName:" + fileName);
            }
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * 保存头像
     *
     * @param file 头像文件
     * @return 结果
     */
    @PostMapping("/updateAvatar")
    @ResponseBody
    public Object updateAvatar(@RequestParam("avatarfile") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String avatar = FileUploadUtils.uploadPicture(FileServerConfig.getAvatarPath(), file);
                System.out.println("avatar:" + FileServerConfig.getAvatarPath() + avatar);
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    /**
     * 查看文件
     *
     * @param url      图片url
     * @param response 请求响应
     */
    @RequestMapping(value = "/noLogin/readImageFile", method = RequestMethod.GET)
    @ResponseBody
    public void getUrlFile(String url, HttpServletResponse response) {
        // 这里的url，我为了测试，直接就写静态的。
//        url = "D:/profile/avatar/2019/09/24/aa8ece857b2c344f095bc32be88e2716.jpg";
        File file = new File(url);
        // 后缀名
        String suffixName = url.substring(url.lastIndexOf(".") + 1);
        //判断文件是否存在如果不存在就返回默认图片或者进行异常处理
        if (!(file.exists() && file.canRead())) {
//            file = new File("xxx/xxx.jpg");
            System.out.println("文件不存在");
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            inputStream.close();
            response.setContentType("image/png;charset=utf-8");
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     *
     * @param url      文件url
     * @param response 请求响应
     */
    @RequestMapping(value = "/noLogin/downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public void getUrlDownload(String url, HttpServletResponse response) {
//        url = "D:/profile/avatar/2019/09/24/aa8ece857b2c344f095bc32be88e2716.jpg";
        File file = new File(url);
        // 后缀名
        String suffixName = url.substring(url.lastIndexOf("."));
        //判断文件是否存在如果不存在就进行异常处理
        if (!(file.exists() && file.canRead())) {
            System.out.println("文件不存在");
        }
        FileInputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            int length = inputStream.read(data);
            inputStream.close();
//            response.setContentType("application/force-download");
            response.setContentType("application/octet-stream");

            //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
            response.addHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
