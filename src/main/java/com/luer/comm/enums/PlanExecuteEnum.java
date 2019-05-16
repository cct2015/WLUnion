package com.luer.comm.enums;

/**
 * 数据表状态枚举
 * 
 * @author GFY
 *推荐方案执行状态
 */
public enum PlanExecuteEnum {

	WAIT(0, "待接受"),
	ACCEPTED(1, "已接受"),
	NOTACCEPTED(2, "拒绝接受"),
	EXECUTING(3, "执行中"),
    EXCUTEOVER(4, "执行完毕"),
    TOUCHING(5, "触达中"),
	TOUCHOVER(6, "触达完毕")
	;
	private final String text;
	private final int value;
	private PlanExecuteEnum(int value, String text) {
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
