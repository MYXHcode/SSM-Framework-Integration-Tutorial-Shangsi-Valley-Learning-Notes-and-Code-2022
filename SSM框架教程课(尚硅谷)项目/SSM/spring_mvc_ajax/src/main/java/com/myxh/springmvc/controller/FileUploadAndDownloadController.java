package com.myxh.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author MYXH
 * @date 2023/9/6
 * @description
 * ResponseEntity：可以作为控制器方法的返回值，表示响应到浏览器的完整的响应报文
 * <p>
 * 文件上传的要求：
 * 1、form 表单的请求方式必须为 post
 * 2、form 表单必须设置属性 enctype="multipart/form-data"
 */
@Controller
public class FileUploadAndDownloadController
{
    @RequestMapping("/test/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException
    {
        // 获取 ServletContext 对象
        ServletContext servletContext = session.getServletContext();

        // 获取服务器中文件的真实路径
        // String realPath = servletContext.getRealPath("/static/img/大户爱.png");
        String realPath = servletContext.getRealPath(File.separator + "static" + File.separator + "img" + File.separator + "大户爱.png");

        // 创建输入流
        InputStream inputStream = new FileInputStream(realPath);

        // 创建字节数组，is.available() 获取输入流所对应文件的字节数
        byte[] bytes = new byte[inputStream.available()];

        // 将流读到字节数组中
        inputStream.read(bytes);

        // 创建 HttpHeaders 对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();

        // 对文件名进行 URL 编码
        String filename = "大户爱.png";
        String encodedFileName = URLEncoder.encode(filename, StandardCharsets.UTF_8);

        // 设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);

        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;

        // 创建 ResponseEntity 对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

        // 关闭输入流
        inputStream.close();

        return responseEntity;
    }

    @RequestMapping("/test/upload")
    public String testUpload(@RequestParam("picture") MultipartFile picture, HttpSession session) throws IOException
    {

        // 获取上传的文件的文件名
        String filename = picture.getOriginalFilename();

        // 获取上传的文件的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));

        // 获取 UUID
        String uuid = UUID.randomUUID().toString();

        // 拼接一个新的文件名
        filename = uuid + suffixName;

        // 获取 ServLetContext 对象
        ServletContext servletContext = session.getServletContext();

        // 获取当前工程下 img 目录的真实路径
        String imgPath = servletContext.getRealPath(File.separator + "static" + File.separator + "img");

        // 创建 imgPath 所对应的 FiLe 对象
        File file = new File(imgPath);

        // 判断 fiLe 所对应目录是否存在
        if (!file.exists())
        {
            file.mkdir();
        }

        String finalPath = imgPath + File.separator + filename;

        // 上传文件
        picture.transferTo(new File(finalPath));

        return "success";
    }
}
