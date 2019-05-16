package com.luer.comm.utils;

import com.luer.privilegeManage.bean.SysUser;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by 87961 on 2019/3/22.
 */
public class EmailSendUtil {

    public static String sendEmail(String emailNum) {
        String code=String.valueOf((int)((Math.random()*9+1)*100000));
        try {
            HtmlEmail email=new HtmlEmail();
            email.setHostName("smtp.163.com");
            email.setCharset("utf-8");
            email.addTo(emailNum);
            email.setFrom("wlmarketing163@163.com","网陆验证");
            email.setAuthentication("wlmarketing163@163.com","Luer88888888");
            /*登录密码Luer123456*/
            email.setSubject("亲爱的用户：" +
                    "您好！本次请求验证码为：");
            email.setMsg(code);
            email.send();
        } catch (Exception e){

        }
        return code;
    }
}
