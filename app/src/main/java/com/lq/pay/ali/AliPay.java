package com.lq.pay.ali;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.lq.pay.IPayResult;

import java.util.Map;

/**
 * description:
 *
 * @author:mick
 * @time:2018/10/17
 */
public class AliPay {
    private static final int SDK_PAY_FLAG = 1;
    private IPayResult payResultListener;

    public static void init() {
    }



    public void pay(final String orderInfo, final Activity activity, IPayResult payResult) {
        payResultListener = payResult;
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                handler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    // 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。

                    // 同步返回需要验证的信息
                    String resultInfo = payResult.getResult();
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        if (payResultListener != null) {
                            payResultListener.onCheckServicePayState();
                        }
                    } else if (TextUtils.equals(resultStatus, "6001")) {
                        if (payResultListener != null) {
                            payResultListener.onPayFail(true);

                        }
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        if (payResultListener != null) {
                            payResultListener.onPayFail(false);

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };
}
