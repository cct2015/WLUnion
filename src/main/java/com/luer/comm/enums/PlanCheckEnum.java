package com.luer.comm.enums;

/**
 * 企业方自己的营销方案状态
 * 
 * @author GFY
 *
 */
public enum PlanCheckEnum {

	NEW(0, "未审核"),
	PASS(1, "审核通过"),
	NOTPASS(2, "审核不通过"),
	EXECUTING(3, "执行中"),
	EXCUTEOVER(4, "执行完毕"),
	TOUCHING(5, "触达中"),
	TOUCHOVER(6, "触达完毕")
    ;
	private final String text;
	private final int value;
	private PlanCheckEnum(int value, String text) {
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
