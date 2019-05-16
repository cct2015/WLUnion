package com.luer.comm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luer.wx.bean.UserAccessToken;
import com.luer.wx.bean.WechatUser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.luer.config.MyX509TrustManager;
import net.sf.json.JSONObject;

public class WechatUtil {
    private static Logger log = LoggerFactory.getLogger(WechatUtil.class);

    /**
     * 获取UserAccessToken实体类
     *
     * @param code
     * @return
     */
    public static UserAccessToken getUserAccessToken(String code) {
        // 测试号信息里的appId
        String appId = "wxaxxxxxxxxxxxxxxxxx";
        log.debug("appId:" + appId);
        // 测试号信息里的appsecret
        String appsecret = "6dxxxxxxxxxxxxxxxxxxxxxxxxxx";
        log.debug("appsecret:" + appsecret);
        // 根据传入的code，拼接出访问微信定义好的接口的URL
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + appsecret
                + "&code=" + code + "&grant_type=authorization_code";
        // 向相应URL发送请求获取token json字符串
        String tokenStr = httpsRequest(url, "GET", null).toString();
        log.debug("userAccessToken:" + tokenStr);
        UserAccessToken token = new UserAccessToken();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 将json字符串转换成相应对象
            token = objectMapper.readValue(tokenStr, UserAccessToken.class);
        } catch (JsonParseException e) {
            log.error("获取用户accessToken失败:" + e.getMessage());
            e.printStackTrace();
        } catch (JsonMappingException e) {
            log.error("获取用户accessToken失败:" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            log.error("获取用户accessToken失败:" + e.getMessage());
            e.printStackTrace();
        }
        if (token == null) {
            log.error("获取用户accessToken失败.");
            return null;
        }
        return token;
    }

    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl
     *            请求地址
     * @param requestMethod
     *            请求方式（GET、post）
     * @param outputStr
     *            提交的数据
     * @return json字符串
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们制定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            log.debug("https buffer:" + buffer.toString());
        } catch (ConnectException ce) {
            log.error("Wechat server connection timed out");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        jsonObject = JSONObject.fromObject(buffer.toString());
        return jsonObject;
    }

    public static WechatUser getUserInfo(String accessToken, String openId) {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId
                + "&lang=zh_CN";
        JSONObject jsonObject = WechatUtil.httpsRequest(url, "GET", null);
        WechatUser user = new WechatUser();
        String openid = jsonObject.getString("openid");
        if (openid == null) {
            log.debug("获取用户信息失败。");
            return null;
        }
        user.setOpenId(openid);
        user.setNickName(jsonObject.getString("nickname"));
        user.setSex(jsonObject.getInt("sex"));
        user.setProvince(jsonObject.getString("province"));
        user.setCity(jsonObject.getString("city"));
        user.setCountry(jsonObject.getString("country"));
        user.setHeadimgurl(jsonObject.getString("headimgurl"));
        user.setPrivilege(null);
        // user.setUnionid(jsonObject.getString("unionid"));
        return user;
    }
}
