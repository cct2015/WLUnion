package com.luer.comm.enums;

/**
 * 微信会员来源
 * 
 * @author GFY
 *
 */
public enum SourceEnum {
	weixin(0, "微信公众号"),
	other(1, "其他");
	private final String text;
	private final int value;

	private SourceEnum(int value, String text) {
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
