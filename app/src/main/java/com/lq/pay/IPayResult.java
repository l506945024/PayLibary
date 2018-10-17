package com.lq.pay;

/**
 * description:
 * 支付结果回调接口
 *
 * @author:mick
 * @time:2018/10/16
 */
public interface IPayResult {

    /**
     * 支付失败
     *
     * @param
     * @param isCancel 是否是用户取消
     */
    public void onPayFail(boolean isCancel);

    /**
     * 支付成功本地回调
     * <p>
     * 向服务器查询支付结果
     */
    public void onCheckServicePayState();
}

