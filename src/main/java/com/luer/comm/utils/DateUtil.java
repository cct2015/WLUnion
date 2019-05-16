package com.luer.comm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import  com.luer.comm.bean.UtilException;
import com.luer.comm.enums.UtilExceptionEnum;


/**
 * 时间工具类
 *
 *
 */
public class DateUtil {

	public static final String DATE = "yyyy-MM-dd";
	public static final String TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String MINUTE = "yyyy-MM-dd HH:mm";
	public static final String MINUTECHINA = "yyyy年MM月dd日 HH点mm分";
	public static final String MILLISECOND = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String DATE_NUMBER = "yyyyMMdd";
	public static final String TIME_NUMBER = "yyyyMMddHHmmss";
	public static final String MILLISECOND_NUMBER = "yyyyMMddHHmmssSSS";

	public static final String DATE_MAX = " 23:59:59";

	public static final String[] MINUTE_ARRAY = {
			/*
			 * "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00",
			 * "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30",
			 * "07:00", "07:30",
			 "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00",
			"13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00",
			"19:30", "20:00"
							 * , "20:30", "21:00", "21:30", "22:00", "22:30",
							 * "23:00", "23:30"
							 */
			"08:00", "08:20", "08:40", "09:00", "09:20", "09:40", "10:00", "10:20", "10:40", "11:00", "11:20", "11:40", "12:00", "12:20", "12:40", "13:00",
			"13:20", "13:40", "14:00", "14:20", "14:40", "15:00", "15:20", "15:40", "16:00", "16:20", "16:40", "17:00", "17:20", "17:40", "18:00", "18:20", "18:40", "19:00",
			"19:20","19:40", "20:00" };

	private DateUtil() {
	}

	/**
	 * 获取当前日期 yyyy-MM-dd
	 *
	 * @return
	 */
	public static String getDateString() {
		return dateToString(new Date(), DATE);
	}

	/**
	 * 获取当前时间(精确到秒) yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 */
	public static String getTimeString() {
		return dateToString(new Date(), TIME);
	}

	/**
	 * 获取当前时间毫秒数
	 *
	 * @return
	 */
	public static long getTime() {
		return System.currentTimeMillis();
	}

	/**
	 * 获取当天最小毫秒数
	 *
	 * @return
	 */
	public static long getMinTime() {
		return stringToTime(getDateString(), DATE);
	}

	/**
	 * 获取当天最大毫秒数
	 *
	 * @return
	 */
	public static long getMaxTime() {
		String now = getDateString() + DATE_MAX;
		return stringToTime(now, TIME);
	}

	/**
	 * 获取当前时间(精确到毫秒) yyyy-MM-dd HH:mm:ss.SSS
	 *
	 * @return
	 */
	public static String getMillisecondString() {
		return dateToString(new Date(), MILLISECOND);
	}

	/**
	 * 获取当前日期编码 yyyyMMdd
	 *
	 * @return
	 */
	public static String getDateNumber() {
		return dateToString(new Date(), DATE_NUMBER);
	}

	/**
	 * 获取当前时间编码(精确到秒) yyyyMMddHHmmss yyyyMMddHHmmssSSS
	 *
	 * @return
	 */
	public static String getTimeNumber() {
		return dateToString(new Date(), TIME_NUMBER);
	}

	/**
	 * 获取当前时间编码(精确到毫秒)
	 *
	 * @return
	 */
	public static String getMillisecondNumber() {
		return dateToString(new Date(), MILLISECOND_NUMBER);
	}

	/**
	 * 时间戳转string
	 *
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static String timeToString(final long time, String pattern) {
		return dateToString(new Date(time), pattern);
	}

	/**
	 * 字符串转时间戳
	 *
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static long stringToTime(final String time, String pattern) {
		return stringToDate(time, pattern).getTime();
	}

	/**
	 * 时间转字符串
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(final Date date, final String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 字符串转时间
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(final String date, final String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new UtilException(UtilExceptionEnum.STRING_TO_DATE_ERROR, e);
		}
	}

	/**
	 * 获取年
	 *
	 * @param date
	 * @return
	 */
	public static String getYear(final String date) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.stringToDate(date, DateUtil.TIME));
		return String.valueOf(c.get(Calendar.YEAR));
	}

	public static String getYear(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.YEAR));
	}

	/**
	 * 获取年
	 *
	 * @param date
	 * @return
	 */
	public static String getYear(String date, String formate) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.stringToDate(date, formate));
		return String.valueOf(c.get(Calendar.YEAR));
	}

	/**
	 * 获取月
	 *
	 * @param date
	 * @return
	 */
	public static String getMonth(String date, String formate) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.stringToDate(date, formate));
		return String.valueOf(c.get(Calendar.MONTH));
	}

	public static String getMonth(final String date) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.stringToDate(date, DateUtil.TIME));
		return String.valueOf(c.get(Calendar.MONTH));
	}

	/**
	 * 获取月
	 *
	 * @param date
	 * @return
	 */
	public static String getMonth(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.MONTH));
	}

	/**
	 * 获取日
	 *
	 * @param date
	 * @return
	 */
	public static String getDay(final String date) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.stringToDate(date, DateUtil.TIME));
		return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取日
	 *
	 * @param date
	 * @return
	 */
	public static String getDay(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取月首日
	 *
	 * @param calendar
	 * @return
	 */
	public static Date getFirstDayOfMonth(final Calendar calendar) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = 1;
		calendar.set(year, month, day, 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 * 获取月尾日
	 *
	 * @param calendar
	 * @return
	 */
	public static Date getLastDayOfMonth(final Calendar calendar) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = 1;
		if (month > 11) {
			month = 0;
			year = year + 1;
		}
		calendar.set(year, month, day - 1, 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 * 比较两日期(时间)是否相等
	 *
	 * @param firstDate
	 * @param secondDate
	 * @param pattern
	 * @return
	 */
	public static boolean compareDate(final Date firstDate, final Date secondDate, final String pattern) {
		String strFirstDate = dateToString(firstDate, pattern);
		String strSecondDate = dateToString(secondDate, pattern);
		if (strFirstDate.equals(strSecondDate)) {
			return true;
		}
		return false;
	}

	/**
	 * 获得指定日期的前一天
	 *
	 * @param date
	 *            yyyy-MM-dd
	 * @return
	 * @throws Exception
	 */
	public static Date getBeforeOneDay(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		return c.getTime();
	}

	/**
	 * 获得指定日期的后一天
	 *
	 * @param date
	 *            yyyy-MM-dd
	 * @return
	 */
	public static Date getAfterOneDay(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		return c.getTime();
	}

	/**
	 * 获得指定日期的后?天
	 *
	 * @param date
	 *            yyyy-MM-dd
	 * @return
	 */
	public static Date getAfterDay(final Date date, int num) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);
		return c.getTime();
	}

	/**
	 * 获取下个周?
	 *
	 * @param date
	 * @param week
	 * @return
	 */
	public static Date getNextWeekDate(final Date date, final int week) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int addDay = week - (calendar.get(Calendar.DAY_OF_WEEK) - 1);
		if (addDay <= 0) {
			addDay += 7;
		}
		calendar.add(Calendar.DATE, addDay);
		return calendar.getTime();
	}

	/**
	 * 两时间段间隔天数
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Long getBetweenDayNum(String startDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE);
		Long checkday = 0L;
		// 开始结束相差天数
		try {
			checkday = (formatter.parse(endDate).getTime() - formatter.parse(startDate).getTime())
					/ (1000 * 24 * 60 * 60);
		} catch (ParseException e) {
			e.printStackTrace();
			checkday = null;
		}
		return checkday;
	}

	/**
	 * 获取两时间段中的所有日期
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> getBetweenTimes(String startDate, String endDate) {
		Date dBegin = stringToDate(startDate, DATE);
		Date dEnd = stringToDate(endDate, DATE);
		List<String> dates = new ArrayList<String>();
		dates.add(startDate);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			dates.add(dateToString(calBegin.getTime(), DATE));
		}
		return dates;
	}

	/**
	 * 获取2个分钟时间之间的数据（半小时间隔）
	 *
	 * @param startMin
	 * @param endMin
	 * @return
	 */
	public static List<String> getBetweenMins(String startMin, String endMin) {
		if (startMin.length() != 5 || endMin.length() != 5) {
			throw new UtilException("开始时间或结束时间长度错误");
		}
		Integer startIndex = null;
		Integer endIndex = null;
		for (int i = 0; i < MINUTE_ARRAY.length; i++) {
			if (MINUTE_ARRAY[i].equals(startMin)) {
				startIndex = i;
			}
			if (MINUTE_ARRAY[i].equals(endMin)) {
				endIndex = i + 1;
			}
			if (startIndex != null && endIndex != null) {
				break;
			}
		}
		if (startIndex == null || endIndex == null) {
			throw new UtilException("开始时间或结束时间值错误");
		}
		if (startIndex.intValue() > endIndex) {
			throw new UtilException("开始时间不允许比结束时间大");
		}
		List<String> mins = new ArrayList<String>();
		for (int i = startIndex; i < endIndex; i++) {
			mins.add(MINUTE_ARRAY[i]);
		}
		return mins;
	}

	// 9：00 --> 36000000
	public static String getWholeTime(Long times){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");// 这里想要只保留分秒可以写成"mm:ss"
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		if (times == null){
			return null;}
		return formatter.format(times);
	}

	//时间转毫秒数  date为01：00到24：00
	public static Long getTimesForWhole(String date){
		  SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		  sdf.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		  long millionSeconds;
		try {
			millionSeconds = sdf.parse(date).getTime();//毫秒
			System.out.println(millionSeconds);
			return millionSeconds;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static Long getTimeByDateString(String dateStr,String formatStr){
		Long dateTime=null;
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			Date date = format.parse(dateStr);
			dateTime=date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTime;
	}
	public static void main(String[] args) {
//		getTimesForWhole("09:00");
	System.out.println(getWholeTime(36000000L));

	}
}