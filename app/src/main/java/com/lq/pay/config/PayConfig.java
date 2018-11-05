package com.lq.pay.config;

/**
 * description:
 *
 * @author:mick
 * @time:2018/10/17
 */
public class PayConfig {
    public static final String TAG = "lqPay";

    public static final int PAY_SUCCESS = 0;
    public static final int PAY_ERROR = -1;
    public static final int PAY_CANCEL = -2;
    /**
     * 没有安装微信或者安装的微信版本过低
     */
    public static final int PAY_ERROR_APP = -3;

    public static final String PAY_SUCCESS_STR = "支付成功";
    public static final String PAY_ERROR_STR = "支付失败";
    public static final String PAY_CANCEL_STR = "支付取消";
    public static final String PAY_ERROR_APP_STR = "没有安装微信或者安装的微信版本过低";
}
