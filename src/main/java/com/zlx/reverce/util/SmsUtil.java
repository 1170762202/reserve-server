package com.zlx.reverce.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

public class SmsUtil {

    private static final String accessKeyId = "LTAI4FjNUYYgWjyuRQ4tkYQx";
    private static final String accessSecret = "0uA5KNTx3sF9yuQiJVUt8PH3JQpjDn";

    private static final String TEMP_CODE_CODE = "SMS_174279434";
    private static final String TEMP_CODE_NOTIFY = "SMS_174580612";

    public static void main(String[] args) {
//        sendSms("17689201170", "phone17689201170");
        sendNotify("17689201170","17859731098");
    }

    public static String sendSms(String mobile) {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        sendSms(mobile, sb.toString());
        return sb.toString();
    }

    /**
     * 短信通知
     *
     * @param mobile        接收者手机号
     * @param purposeMobile 短信内容手机号
     */
    public static void sendNotify(String mobile, String purposeMobile) {
        CommonRequest request = initSmsNotify(mobile, TEMP_CODE_NOTIFY);
        request.putQueryParameter("TemplateParam", "{\"number\":\"" + purposeMobile + "\"}");
        send(request);
    }

    /**
     * 发送短信验证码
     *
     * @param mobile 接收者手机号
     * @param code   短信验证码
     */
    private static void sendSms(String mobile, String code) {
        CommonRequest request = initSmsCode(mobile, TEMP_CODE_CODE);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        send(request);
    }

    private static void send(CommonRequest request) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    private static CommonRequest initSmsNotify(String mobile,String templateCode){
        CommonRequest commonRequest = initSms(mobile, templateCode);
        commonRequest.putQueryParameter("SignName", "携艇会");
        return commonRequest;
    }

    private static CommonRequest initSmsCode(String mobile, String templateCode) {
        CommonRequest commonRequest = initSms(mobile, templateCode);
        commonRequest.putQueryParameter("SignName", "second2man");
        return commonRequest;
    }

    private static CommonRequest initSms(String mobile, String templateCode) {
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("TemplateCode", templateCode);
        return request;
    }
}
