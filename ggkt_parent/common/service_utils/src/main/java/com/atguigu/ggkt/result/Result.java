package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//统一返回结果类
@Data
@ApiModel(value = "全局统一返回结果")
public class Result<T> {

    @ApiModelProperty(value = "返回码")
	private Integer code; 
	
    @ApiModelProperty(value = "返回消息")
	private String message; 
	
    @ApiModelProperty(value = "返回数据")
	private T data;
	
	public Result() {}
	
	//成功的方法,有data的数据
	public static<T> Result<T> ok(T data){
		
		Result<T> result = new Result<T>();
		if(data != null) {
			result.setData(data);
		}
		result.setCode(200);
		result.setMessage("成功");
		return result;
	}
	//失败的方法,有data的数据
	public static<T> Result<T> fail(T data){
		
		Result<T> result = new Result<T>();
		if(data != null) {
			result.setData(data);
		}
		result.setCode(201);
		result.setMessage("失败");
		return result;
	}
	
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
