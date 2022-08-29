package com.atguigu.ggkt.vod.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author prisoner
 * @since 2022-08-23
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	//1. 查询讲师列表
	@ApiOperation("查询所有讲师")
	@GetMapping("/findAll")
	public Result findAll(){
		//模拟异常
		
		try {
			int i = 10/0;
		} catch (Exception e) {
			throw new GgktException(201,"出现自定义异常");
		}
		List<Teacher> list = teacherService.list();
		return Result.ok(list).message("查询数据成功");
	}
	
	//2. 逻辑删除讲师
	@ApiOperation("逻辑删除讲师")
	@DeleteMapping("/delete/{id}")
	public Result removeTeacher(@PathVariable Long id) {
		
		boolean isSuccess = teacherService.removeById(id);
		if(isSuccess) {
			
			return Result.ok(null);
		}else {
			
			return Result.fail(null);
		}
	}
	
	@ApiOperation("条件查询分页")
	@PostMapping("findQueryPage/{current}/{limit}")
	public Result findPage(@PathVariable long current
						 , @PathVariable long limit
						 , @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
		//创建page对象
		Page<Teacher> pageParam = new Page<>(current,limit);
		//判断teacherQueryVo对象是否为空
		if(teacherQueryVo == null) {
			
			IPage<Teacher> pageModel = teacherService.page(pageParam,null);
			return Result.ok(pageModel);
		}else {
			//获取条件之
			String name = teacherQueryVo.getName();
			Integer level = teacherQueryVo.getLevel();
			String joinDateBegin = teacherQueryVo.getJoinDateBegin();
			String joinDateEnd = teacherQueryVo.getJoinDateEnd();
			//进行非空判断，条件封装
			QueryWrapper<Teacher> wrapper = new QueryWrapper<Teacher>();
			if(!StringUtils.isEmpty(name)) {
				wrapper.like("name", name);
			}
			if(!StringUtils.isEmpty(level)) {
				wrapper.like("level", level);
			}
			if(!StringUtils.isEmpty(joinDateBegin)) {
				wrapper.ge("join_date", joinDateBegin);
			}
			if(!StringUtils.isEmpty(joinDateEnd)) {
				wrapper.le("join_date", joinDateEnd);
			}
			
			//调用方法分页查询
			IPage<Teacher> pageModel = teacherService.page(pageParam,wrapper);
			return Result.ok(pageModel);
		}
	}
	
	@ApiOperation(value = "新增")
	@PostMapping("save")
	public Result save(@RequestBody Teacher teacher) {
		teacherService.save(teacher);
		return Result.ok(null);
	}
	
	@ApiOperation(value = "获取")
	@GetMapping("get/{id}")
	public Result get(@PathVariable Long id) {
	    Teacher teacher = teacherService.getById(id);
	    return Result.ok(teacher);
	}
	
	@ApiOperation(value = "修改")
	@PutMapping("update")
	public Result updateById(@RequestBody Teacher teacher) {
	    teacherService.updateById(teacher);
	    return Result.ok(null);
	}
	
	@ApiOperation(value = "根据id列表删除")
	@DeleteMapping("batchRemove")
	public Result batchRemove(@RequestBody List<Long> idList) {
		teacherService.removeByIds(idList);
		return Result.ok(null);
	}
}

