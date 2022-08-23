package com.atguigu.vod.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.vod.service.TeacherService;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author prisoner
 * @since 2022-08-23
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	public List<Teacher> findAll(){
		
		return teacherService.list();
	}
}

