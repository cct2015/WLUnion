package com.luer.comm.constants;

public interface Constant {


	String COOKIEVALUE="a0ab2c85f72143c88c112a7dff79faaf";
	/**
	 * 当前登陆用户
	 */
	String CURRENT_USER = "current_user";
	
	//验证码
	String CURRENT_CODE="code";
	/**
	 * 管理员角色名称
	 */
	String ADMIN = "admin";
	/**
	 * 资源树root
	 */
	long ROOT = 1L;

	/**
	 * 提交Token
	 */
	String SUBMIT_TOKEN = "SUBMIT_TOKEN";

	/**
	 * 访问Token
	 */
	String ACCESS_TOKEN = "ACCESS_TOKEN";

	/**
	 * 刷新Token
	 */
	String REFRESH_TOKEN = "REFRESH_TOKEN";

	/**
	 * 提交Token错误状态码
	 */
	int TOKEN_ERROR_STATUS = 999;

	/**
	 * 认证授权错误
	 */
	int AUTH_ERROR_STATUS = 403;

	/**
	 * session过期
	 */
	int SESSION_ERROR_STATUS = 401;
	/**
	 * 验证码记录前缀
	 */
	String VALIDCODE = "valid_code:";
	/**
	 * 密码错误次数记录前缀
	 */
	String PWD_ERROR_NUM = "pwd_error_num:";

	/**
	 * 微信原生扫码支付类型
	 */
	String WECHAT_ORDER_NATIVE = "NATIVE";
	/**
	 * 微信手机APP支付类型
	 */
	String WECHAT_ORDER_APP = "APP";
	/**
	 * 支付宝充值
	 */
	String ALIPAY="Alipay";
}
