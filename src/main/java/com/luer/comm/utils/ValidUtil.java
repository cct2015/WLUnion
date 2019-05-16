package com.luer.comm.utils;

import java.util.Collection;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 数据验证工具类
 * 
 * @author 
 * @date 
 *
 */
public class ValidUtil {

	private ValidUtil() {
	}

	/**
	 * 字符串是空?
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isBlank(final CharSequence cs) {
		return StringUtils.isBlank(cs);
	}

	/**
	 * 字符串不是空?
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	/**
	 * 集合是空?
	 * 
	 * @param coll
	 * @return
	 */
	public static boolean isEmpty(final Collection<?> coll) {
		return coll == null || coll.isEmpty();
	}

	/**
	 * 集合不是空?
	 * 
	 * @param coll
	 * @return
	 */
	public static boolean isNotEmpty(final Collection<?> coll) {
		return !isEmpty(coll);
	}

	/**
	 * 是手机?
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(final String mobile) {
		return Pattern.compile("^1[0-9]{10}$").matcher(mobile).matches();
	}

	/**
	 * 是电话?
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean isTel(final String tel) {
		return Pattern.compile("^(0[1-9]{2})-\\d{8}$|^(0[1-9]{3}-(\\d{7,8}))$").matcher(tel).matches();
	}

	/**
	 * 是邮箱?
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(final String email) {
		return Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$")
				.matcher(email).matches();
	}

	/**
	 * 是用户名?
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isUserName(final String userName) {
		return Pattern.compile("^[A-Za-z0-9]{2,22}$").matcher(userName).matches();
	}

	/**
	 * 是密码?
	 * 
	 * @param pwd
	 * @return
	 */
	public static boolean isPwd(final String pwd) {
		return Pattern.compile("^.{6,20}$").matcher(pwd).matches();
	}

	/**
	 * 是中文?
	 * 
	 * @param chinese
	 * @return
	 */
	public static boolean isChinese(final String chinese) {
		return Pattern.compile("^[\u4e00-\u9fa5]+$").matcher(chinese).matches();
	}

	/**
	 * 是数字?
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isNumber(final String str) {
		return NumberUtils.isNumber(str);
	}

}