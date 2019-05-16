package com.luer.comm.bean;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.LinkedHashMap;

@SuppressWarnings("all")
public class ResultSet extends LinkedHashMap implements Serializable {
    // 状态码
    private int code = 406;
    // 消息
    private String msg = "内部错误";
    // 数据
    private Object data = "";
    // 时间戳
    private Long time = System.currentTimeMillis();

    public ResultSet() {
        this.put("code", code);
        this.put("msg", msg);
        this.put("data", data);
        this.put("time", time);
    }

    public ResultSet addStair(Object k, Object v) {
        this.put(k, v);
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultSet setCode(int code) {
        this.code = code;
        this.put("code", code);
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultSet setMsg(String msg) {
        this.msg = msg;
        this.put("msg", msg);
        return this;
    }
    public static ResultSet setResult(int code,String msg,Object data) {

        return new ResultSet().setData(data).setCode(code).setMsg(msg);
    }

    public Object getData() {
        return data;
    }

    public ResultSet setData(Object data) {
        this.data = data;
        this.put("data", data);
        return this;
    }

    public Long getTime() {
        return time;
    }

    public ResultSet setTime(Long time) {
        this.time = time;
        this.put("time", time);
        return this;
    }

    public static ResultSet getSuccess() {

        return new ResultSet().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setCode(200).setMsg("success");
    }

    public static ResultSet getSuccess(Object data) {

        return new ResultSet().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setData(data).setCode(200).setMsg("success");
    }

    public static ResultSet getFail() {

        return new ResultSet().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setMsg("fail");
    }

    public static ResultSet getFail(String message) {

        return new ResultSet().setCode(HttpStatus.NOT_ACCEPTABLE.value()).setMsg(message);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
