package com.bysj.controller;

import com.bysj.dto.ResDTO;
import com.bysj.util.FileUploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/com")
@Api(tags = "公共模块（图片上传等）")
public class AComController {

    @ApiOperation(value="上传图片")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResDTO uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String url = FileUploadUtil.fileUpload("/images/", file, request);
        return ResDTO.Data(url);
    }
}
