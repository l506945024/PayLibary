package com.lq.pay.wx;

import android.content.Context;

import com.lq.pay.IPayResult;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * description:
 *
 * @author:mick
 * @time:2018/10/17
 */
public class WxPay {
    private static IWXAPI msgApi;

    public static void init(Context context, String appId) {
        msgApi = WXAPIFactory.createWXAPI(context, appId);
    }

    /**
     * 支付
     *
     * @param param
     */
    public void pay(WxParam param, IPayResult payResult) {
        if (param == null) {
            return;
        }
        if (msgApi == null) {
            return;
        }
        LqWXPayEntryActivity.payResult = payResult;
        PayReq request = new PayReq();
        request.appId = param.getAppId();
        request.partnerId = param.getPartnerId();
        request.prepayId = param.getPrepayId();
        request.packageValue = param.getPackageValue();
        request.nonceStr = param.getNonceStr();
        request.timeStamp = param.getTimeStamp();
        request.sign = param.getSign();
        msgApi.sendReq(request);

    }
}
