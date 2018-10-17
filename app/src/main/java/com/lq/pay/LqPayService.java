package com.lq.pay;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.lq.pay.ali.AliParam;
import com.lq.pay.ali.AliPay;
import com.lq.pay.ali.PayResult;
import com.lq.pay.wx.WxParam;
import com.lq.pay.wx.WxPay;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;

/**
 * description:
 * 外部调用的支付类
 *
 * @author:mick
 * @time:2018/10/16
 */
public class LqPayService implements IPayService {
    private static LqPayService instance;
    WxPay wxPay;
    AliPay aliPay;

    private LqPayService() {
    }

    public static LqPayService getInstance() {
        if (instance == null) {
            synchronized (LqPayService.class) {
                if (instance == null) {
                    instance = new LqPayService();
                }
            }
        }
        return instance;
    }

    public static void initWxPay(Context context, String wxAppId) {
        WxPay.init(context, wxAppId);
    }

    public static void initAliPay() {
        AliPay.init();
    }

    @Override
    public void wxPay(WxParam param, IPayResult payResult) {
        if (wxPay == null) {
            wxPay = new WxPay();
        }
        wxPay.pay(param, payResult);
    }


    @Override
    public void aliPay(AliParam param, Activity activity, IPayResult payResult) {
        if (aliPay == null) {
            aliPay = new AliPay();
        }
        aliPay.pay(param.getOrderInfo(), activity, payResult);
    }
}
