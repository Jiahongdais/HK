package com.hk.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @create 2020/8/20 23:39
 */
@Component
public class SmsUtil {

    //@Autowired
    //private Environment env;
    //此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)

    /**
     * 发送短信
     * @param mobile        手机号
     * @param SignName     签名
     * @param TemplateCode 模板号
     * @param param         参数
     * @return
     * @throws ClientException
     */
    /*public CommonResponse sendSms(String mobile, String SignName, String TemplateCode, String param) throws ClientException {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", env.getProperty("aliyun.sms.accessKeyId"), env.getProperty("aliyun.sms.accessKeySecret"));
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", TemplateCode);
        request.putQueryParameter("TemplateParam", param);
        CommonResponse response = client.getCommonResponse(request);
        System.out.println(response.getData());
        return response;
    }*/
}