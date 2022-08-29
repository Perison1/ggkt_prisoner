package com.atguigu.ggkt.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.atguigu.ggkt.result.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//全局异常处理
	@ExceptionHandler(Exception.class)
	public Result error(Exception e) {
		System.out.println("全局异常");
		e.printStackTrace();
		return Result.fail(null).message("执行全局异常处理");
	}
	
	//特定异常处理 ArithmeticException
	@ExceptionHandler(ArithmeticException.class)
	public Result error(ArithmeticException e) {
		System.out.println("特定异常");
		e.printStackTrace();
		return Result.fail(null).message("执行特定异常处理");
	}
	
	@ExceptionHandler(GgktException.class)
	public Result error(GgktException e) {
		System.out.println("自定义异常");
		e.printStackTrace();
		return Result.fail(null).code(e.getCode()).message(e.getMsg());
	}
}
