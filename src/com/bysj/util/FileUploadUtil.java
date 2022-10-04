package com.bysj.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtil {
    /**
     * 上传文件
     * @param path 文件的相对路径
     * @param file 文件数据
     * @param request 请求
     * @return 文件的绝对路径
     */
    public static String fileUpload(String path, MultipartFile file, HttpServletRequest request) throws IOException {
        // 先获取到文件要保存的路径
        String realPath = request.getSession().getServletContext().getRealPath("/" + path);
        System.out.println("【绝对路径】" + realPath);

        // 获取文件后缀名，然后为文件起一个新名字（使用 UUID 避免重名）
        System.out.println("【原文件名】" + file.getOriginalFilename());
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + suffix;
        System.out.println("【新文件名】" + newFileName);

        // 新建一个文件对象
        File target = new File(realPath, newFileName);

        // 如果存放路径不存在，就新建一个
        if (!target.getParentFile().exists()) {
            // 新建文件夹
            if (!target.getParentFile().mkdirs()) {
                System.out.println("【目录为空】新建文件夹失败！");
                return null;
            }
        }

        // 成功的话将文件保存
        file.transferTo(target);

        // 最后返回文件的地址
        return path+newFileName;
    }
}
