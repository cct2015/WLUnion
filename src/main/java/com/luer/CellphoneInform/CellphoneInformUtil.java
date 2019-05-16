package com.luer.CellphoneInform;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.luer.CellphoneInform.CheckSumBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * 发送模板短信请求
 * @author GFY
 *
 */
public class CellphoneInformUtil {

        //发送短信的请求路径URL
        private static final String
                SERVER_URL="https://api.netease.im/sms/sendtemplate.action";
        //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
        private static final String
                APP_KEY="08ca6ad68429f4b383d969e286669a29";
        //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
        private static final String APP_SECRET="08f013c5d980";
        //随机数
        private static final String NONCE="123456";
        //短信模板ID
        private static final String TEMPLATEID="9574382";
        //手机号，接收者号码列表，JSONArray格式，限制接收者号码个数最多为100个
        private static final String MOBILES="['15556939308','18539591215']";//,'17721374032',18600163949
        //短信参数列表，用于依次填充模板，JSONArray格式，每个变量长度不能超过30字,对于不包含变量的模板，不填此参数表示模板即短信全文内容
        private static final String PARAMS="['某某','5']";

    public static void main(String[] args) throws Exception
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(SERVER_URL);
            String curTime = String.valueOf((new Date()).getTime() / 1000L);
            /*
             * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
             */
            String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

            // 设置请求的header
            httpPost.addHeader("AppKey", APP_KEY);
            httpPost.addHeader("Nonce", NONCE);
            httpPost.addHeader("CurTime", curTime);
            httpPost.addHeader("CheckSum", checkSum);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // 设置请求的的参数，requestBody参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            /*
             * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
             * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
             * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
             */
            nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
            nvps.add(new BasicNameValuePair("mobiles", MOBILES));
            nvps.add(new BasicNameValuePair("params", PARAMS));

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);
            /*
             * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
             * 2.具体的code有问题的可以参考官网的Code状态表
             */
           System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
          //  return EntityUtils.toString(response.getEntity(), "utf-8");
        }
}