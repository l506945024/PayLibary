package com.lq.pay.wx;

import android.app.Activity;

import com.lq.pay.config.PayConfig;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * description:
 * 微信支付回调
 * 需要在主包名下创建WXPayEntryActivity继承该activity
 *
 * @author:mick
 * @time:2018/10/17
 */
public class LqWXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            switch (resp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    WxPay.getInstance().onResult(PayConfig.PAY_SUCCESS, PayConfig.PAY_SUCCESS_STR);
                    break;
                case BaseResp.ErrCode.ERR_COMM:
                    //可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。
                    WxPay.getInstance().onResult(PayConfig.PAY_ERROR, PayConfig.PAY_ERROR_STR);
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    //无需处理。发生场景：用户不支付了，点击取消，返回APP。
                    WxPay.getInstance().onResult(PayConfig.PAY_CANCEL, PayConfig.PAY_CANCEL_STR);
                    break;
                default:
                    break;
            }
        }
    }
}
