package com.luer.comm.enums;

/**
 * 工具类异常枚举
 * 
 * @author 
 *
 */
public enum UtilExceptionEnum {

	/** properties文件读取错误 **/
	PROPERTIES_READ_ERROR("properties文件读取错误"),
	/** properties文件写入错误 **/
	PROPERTIES_WRITE_ERROR("properties文件写入错误"),
	/** MD5初始化错误 **/
	MD5_INIT_ERROR("MD5初始化错误"),
	/** MD5获取错误 **/
	MD5_GET_ERROR("MD5获取错误"),
	/** EXCEL导出错误 **/
	EXCEL_EXPROT_ERROR("EXCEL导出错误"),
	/** EXCEL导入错误 **/
	EXCEL_IMPORT_ERROR("EXCEL导入错误"),
	/** Cookie添加错误 **/
	COOKIE_ADD_ERROR("Cookie添加错误"),
	/** Cookie获取错误 **/
	COOKIE_GET_ERROR("Cookie获取错误"),
	/** IP获取错误 **/
	IP_GET_ERROR("IP获取错误"),
	/** HTTP请求错误 **/
	HTTP_ERROR("HTTP请求错误"),
	/** 日期转换错误 **/
	STRING_TO_DATE_ERROR("日期转换错误");

	private final String code;
	private final String msg;

	private UtilExceptionEnum(String msg) {
		this.code = this.name().toLowerCase();
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
