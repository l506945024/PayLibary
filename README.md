# PayLibary
## 微信支付/支付宝支付封装<br>

#### 1.支付宝支付<br>
      PayHelper.startAliPay(String orderInfo, Activity activity, IPayResultCallBack payResult)调起支付宝支付
#### 2.微信支付<br>
      PayHelper.initWxPay(context, appId)初始化
      PayHelper.startWxPay(WxParam param, Context context, IPayResultCallBack payResult)调起微信支付
