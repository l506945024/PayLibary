package com.lq.pay;

/**
 * description:
 * 支付结果回调接口
 *
 * @author:mick
 * @time:2018/10/16
 */
public interface IPayResultCallBack {
    /**
     * 支付结果回调
     *
     * @param result
     */
    void onPayResult(PayResult result);
}

