package com.atguigu.ggkt.vod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 文件上传 控制器
 * 
 * @author prisoner
 *
 */
@Api(tags="文件上次接口")
@RestController
@RequestMapping("/admin/vod/file")
@CrossOrigin
public class FileUploadController {

	@Autowired
	private FileService fileService;
	
	@ApiOperation("文件上传")
	@PostMapping("upload")
	public Result uploadFile(MultipartFile file) {
		
		String url = fileService.upload(file);
        return Result.ok(url).message("文件上传成功");
	}
}
