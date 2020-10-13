package com.example.common.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * 封装返回数据
 *
 * @author tangyi
 * @date 2019/3/17 12:08
 */
@Data
public class ResponseVO implements Serializable{

	/**
	 * 调用是否成功
	 */
	private Boolean success;

	/**
	 * 返回的提示信息
	 */
	private String message;

	/**
	 * 返回所携带的对象信息
	 */
	private Object content;

	public static ResponseVO buildSuccess(){
		ResponseVO response=new ResponseVO();
		response.setSuccess(true);
		return response;
	}


	public static ResponseVO buildSuccess(Object content){
		ResponseVO response=new ResponseVO();
		response.setContent(content);
		response.setSuccess(true);
		return response;
	}

	public static ResponseVO buildFailure(String message){
		ResponseVO response=new ResponseVO();
		response.setSuccess(false);
		response.setMessage(message);
		return response;
	}

	public static ResponseVO buildFailure(Object content){
		ResponseVO response=new ResponseVO();
		response.setContent(content);
		response.setSuccess(false);
		return response;
	}
}
