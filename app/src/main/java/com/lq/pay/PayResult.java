package com.lq.pay;

/**
 * description:
 *
 * @author:mick
 * @time:2018/11/5
 */
public class PayResult {
    private int code;
    private String msg;

    public PayResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
