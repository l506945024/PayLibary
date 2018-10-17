package com.lq.pay;

import android.app.Activity;

import com.lq.pay.ali.AliParam;
import com.lq.pay.wx.WxParam;

/**
 * description:
 * 支付方式扩展接口
 *
 * @author:mick
 * @time:2018/10/16
 */
public interface IPayService {

    public static final int PAY_WAY_WX = 0;
    public static final int PAY_WAY_Ali = 1;

    /**
     * 微信支付
     *
     * @param param
     * @param payResult
     */
    public void wxPay(WxParam param, IPayResult payResult);

    /**
     * 支付宝支付
     *
     * @param param
     * @param activity
     * @param payResult
     */
    public void aliPay(AliParam param, Activity activity, IPayResult payResult);
}
