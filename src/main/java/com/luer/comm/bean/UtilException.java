package com.luer.comm.bean;

import com.luer.comm.enums.UtilExceptionEnum;

/**
 * 自定义异常
 * 
 * @author 
 *
 */
public class UtilException extends RuntimeException {

	private static final long serialVersionUID = 4487836596341477781L;

	private static final String UTIL_EXCEPTION_DEFAULT = "util_extption_default";

	public String code;
	public String msg;

	public UtilException(UtilExceptionEnum utilExceptionEnum, Exception e) {
		super(utilExceptionEnum.getMsg(), e);
		this.code = utilExceptionEnum.getCode();
		this.msg = utilExceptionEnum.getMsg();
	}

	public UtilException(String msg) {
		super(msg);
		this.code = UTIL_EXCEPTION_DEFAULT;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
