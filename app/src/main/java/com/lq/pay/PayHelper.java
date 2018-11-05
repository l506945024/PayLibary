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
    public static void initWx(Context context, String appId) {
        WxPay.init(context, appId);
    }

    /**
     * 调起支付宝支付
     *
     * @param orderInfo
     * @param activity
     * @param payResult
     */
    public void startAliPay(String orderInfo, Activity activity, IPayResultCallBack payResult) {
        AliPay.getInstance().pay(orderInfo, activity, payResult);
    }

    /**
     * 调起微信支付
     *
     * @param param
     * @param context
     * @param payResult
     */
    public void startWxPay(WxParam param, Context context, IPayResultCallBack payResult) {
        WxPay.getInstance().pay(param, context, payResult);
    }
}
