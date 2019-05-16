package com.luer.comm.enums;

/**
 * 数据表状态枚举
 * 
 * @author GFY
 *
 */
public enum StatusEnum {

	/** 正常 0 **/
	NORMAL(0, "正常"),
	/** 冻结 1 **/
	FREEZE(1, "冻结"),
	/** 删除 2 **/
	DELETE(2, "删除");

	
	private final String text;
	private final int value;

	private StatusEnum(int value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public int getValue() {
		return value;
	}

}
