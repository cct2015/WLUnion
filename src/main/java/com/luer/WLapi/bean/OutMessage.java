package com.luer.WLapi.bean;

public class OutMessage {
   String  msg;
    Object result;
    int   code;
    public OutMessage (int code,String msg)
    {
        this. result="";
        this.msg=msg;
        this.code=code;
    }
    public OutMessage (Object res,int code,String msg)
    {
        this.result=res;
        this.msg=msg;
        this.code=code;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public static OutMessage getOutMessage(int code,String msg)
    {
         return new OutMessage(code, msg);
    }

    public static OutMessage getOutMessage(Object res,int code,String msg)
    {
        return new OutMessage(res,code, msg);
    }
}
