package com.lq.pay.wx;

/**
 * description:
 *  调起微信支付需要传入的参数
 * @author:mick
 * @time:2018/10/16
 */
public class WxParam {
//    IWXAPI api;
//    PayReq request = new PayReq();
//    request.appId = "wxd930ea5d5a258f4f";
//    request.partnerId = "1900000109";
//    request.prepayId= "1101000000140415649af9fc314aa427",;
//    request.packageValue = "Sign=WXPay";
//    request.nonceStr= "1101000000140429eb40476f8896f4c9";
//    request.timeStamp= "1398746574";
//    request.sign= "7FFECB600D7157C5AA49810D2D8F28BC2811827B";
//api.sendReq(request);

    private String AppId;
    private String partnerId;
    private String prepayId;
    private String packageValue;
    private String nonceStr;
    private String timeStamp;
    private String sign;

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
