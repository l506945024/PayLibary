package com.lq.pay.wx;

import android.content.Context;

import com.lq.pay.IPayResultCallBack;
import com.lq.pay.PayResult;
import com.lq.pay.config.PayConfig;
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
    private static WxPay sWxPay = null;
    IPayResultCallBack mIPayResultListener;
    private static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;

    private WxPay() {

    }

    public static WxPay getInstance() {
        if (sWxPay == null) {
            synchronized (WxPay.class) {
                if (sWxPay == null) {
                    sWxPay = new WxPay();
                }
            }
        }
        return sWxPay;
    }

    /**
     * 微信支付需要先初始化进行绑定
     *
     * @param context
     * @param appId
     */
    public static void init(Context context, String appId) {
        msgApi = WXAPIFactory.createWXAPI(context, appId);
        msgApi.registerApp(appId);
    }

    /**
     * 支付
     *
     * @param param
     */
    public void pay(WxParam param, Context context, IPayResultCallBack payResult) {
        mIPayResultListener = payResult;
        if (checkWeChatPay()) {
            if (param == null) {
                return;
            }
            PayReq request = new PayReq();
            request.appId = param.getAppId();
            request.partnerId = param.getPartnerId();
            request.prepayId = param.getPrepayId();
            request.packageValue = param.getPackageValue();
            request.nonceStr = param.getNonceStr();
            request.timeStamp = param.getTimeStamp();
            request.sign = param.getSign();
            msgApi.sendReq(request);
        } else {
            mIPayResultListener.onPayResult(new PayResult(PayConfig.PAY_ERROR_APP,
                    "手机未安装微信或者安装的微信版本过低"));
        }
    }

    /**
     * 检查手机是否支持微信支付
     *
     * @return
     */
    private boolean checkWeChatPay() {
        if (msgApi == null) {
            throw new NullPointerException("使用微信支付必须先在onCreate中调用PayHelper.initWx(context, appId)完成初始化!");
        }
        int wxSdkVersion = msgApi.getWXAppSupportAPI();
        boolean isWeChatAble = true;
        if (!msgApi.isWXAppInstalled()) {
            isWeChatAble = false;
        } else if (wxSdkVersion < TIMELINE_SUPPORTED_VERSION) {
            isWeChatAble = false;
        }
        return isWeChatAble;
    }

    public void onResult(int code, String msg) {
        if (mIPayResultListener != null) {
            mIPayResultListener.onPayResult(new PayResult(code, msg));
        }
    }

}
