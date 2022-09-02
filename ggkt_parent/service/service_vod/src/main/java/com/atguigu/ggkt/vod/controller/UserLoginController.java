package com.atguigu.ggkt.vod.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.ggkt.result.Result;

@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin  //跨域实现方式
public class UserLoginController {

	/**
	 * 登录
	 * @return
	 */
	@PostMapping("login")
	public Result login() {
		
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
		return Result.ok(map);
	}
	
	/**
	 * 获取用户信息
	 * @return
	 */
	@GetMapping("info")
	public Result info() {
		
        Map<String, Object> map = new HashMap<>();
        map.put("roles","admin");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return Result.ok(map);
	}
	
    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    public Result logout(){
        return Result.ok(null);
    }
}
