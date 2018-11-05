package com.lq.pay;

import android.app.Activity;
import android.content.Context;

import com.lq.pay.ali.AliPay;
import com.lq.pay.wx.WxParam;
import com.lq.pay.wx.WxPay;

/**
 * description:
 *
 * @author:mick
 * @time:2018/11/5
 */
public class PayHelper {
    private static PayHelper sPayHelper;

    private PayHelper() {
    }

    public static PayHelper getInstance() {
        if (sPayHelper == null) {
            synchronized (PayHelper.class) {
                if (sPayHelper != null) {
                    sPayHelper = new PayHelper();
                }
            }
        }
        return sPayHelper;
    }

    /**
     * 微信支付初始化
     *
     * @param context
     * @param appId
     */
    public static void initWxPay(Context context, String appId) {
        WxPay.init(context, appId);
    }

    /**
     * 调起支付宝支付
     *
     * @param orderInfo 服务器拼接好的支付宝支付字符串
     * @param activity
     * @param payResult 支付结果回调
     */
    public void startAliPay(String orderInfo, Activity activity, IPayResultCallBack payResult) {
        AliPay.getInstance().pay(orderInfo, activity, payResult);
    }

    /**
     * 调起微信支付
     *
     * @param param 支付参数
     * @param context
     * @param payResult 支付结果回调
     */
    public void startWxPay(WxParam param, Context context, IPayResultCallBack payResult) {
        WxPay.getInstance().pay(param, context, payResult);
    }
}
