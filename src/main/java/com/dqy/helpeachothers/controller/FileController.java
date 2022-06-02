package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${dqy.address}")
    public String address;
    ReturnVO returnVO;
    @RequestMapping(value = "/upload")
    public ReturnVO upload( @RequestParam(value = "file") MultipartFile file){
        returnVO = new ReturnVO();
        // 测试MultipartFile接口的各个方法
//        System.out.println("文件类型ContentType=" + file.getContentType());
//        System.out.println("文件组件名称Name=" + file.getName());
//        System.out.println("文件原名称OriginalFileName=" + file.getOriginalFilename());
//        System.out.println("文件大小Size=" + file.getSize()/1024 + "KB");
        try {
            if (file.isEmpty()) {
                returnVO.setCode(500);
                returnVO.setMessage("文件为空！");
                return returnVO;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            System.out.println("上传的文件名为：" + fileName);

            String os = System.getProperty("os.name");
            String path="";
            if (os.toLowerCase().startsWith("win")) {
                //windows系统
                String filePath= ClassUtils.getDefaultClassLoader().getResource("").getPath();;
                System.out.println("path = " + filePath);
                path = filePath +"static/"+ fileName;
                System.out.println("构造路径"+path);
            }else{
                //linux系统

                ApplicationHome home = new ApplicationHome(getClass());//获取jar包地址 /dqy
                File jarFile = home.getSource();
                 path = jarFile.getParentFile().getPath()+"/static/"+fileName;
                System.out.println("构造路径"+path);
            }

            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            String returnPath=fileName;
            returnVO.setCode(200);
            returnVO.setMessage("上传成功");
            returnVO.setData(returnPath);
            return returnVO;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnVO.setCode(500);
        returnVO.setMessage("上传失败");
        return returnVO;
    }
}

