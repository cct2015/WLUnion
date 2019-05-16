package com.luer.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 第三方平台的配置
 * @author GFY
 */
@Configuration
@EnableCaching
@PropertySource(value = "classpath:/application.properties")
public class WechatOpenProperties {
    /**
     * 设置微信三方平台的appid
     */

    @Value("${wechat.open.componentAppId}")
    private String componentAppId;

    /**
     * 设置微信三方平台的app secret
     */
    @Value("${wechat.open.componentSecret}")
    private String componentSecret;

    /**
     * 设置微信三方平台的token
     */
    @Value("${wechat.open.componentToken}")
    private String componentToken;

//   //引导授权后进入的页面
    @Value("${wechat.open.redirect_uri}")
    private String redirect_uri;

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    /**
     * 设置微信三方平台的EncodingAESKey
     */
    @Value("${wechat.open.componentAesKey}")
    private String componentAesKey;

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    @Value("${wechat.execute.domainUrl}")
    private String domainUrl;

    public String getSMSdomainUrl() {
        return SMSdomainUrl;
    }

    public void setSMSdomainUrl(String SMSdomainUrl) {
        this.SMSdomainUrl = SMSdomainUrl;
    }

    @Value("${wechat.execute.SMSdomainUrl}")
    private String SMSdomainUrl;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    @Value("${SMS.execute.apikey}")
    private String apikey;
    //效果预测地址
    @Value("${plan.execute.forcastdomainUrl}")
    private String forcastdomainUrl;

    public String getJDappkey() {
        return JDappkey;
    }

    public void setJDappkey(String JDappkey) {
        this.JDappkey = JDappkey;
    }

    @Value("${plan.execute.JDappkey}")
    private String JDappkey;

    public String getForcastdomainUrl() {
        return forcastdomainUrl;
    }

    public void setForcastdomainUrl(String forcastdomainUrl) {
        this.forcastdomainUrl = forcastdomainUrl;
    }

    public String getComponentAppId() {
        return componentAppId;
    }

    public void setComponentAppId(String componentAppId) {
        this.componentAppId = componentAppId;
    }

    public String getComponentSecret() {
        return componentSecret;
    }

    public void setComponentSecret(String componentSecret) {
        this.componentSecret = componentSecret;
    }

    public String getComponentToken() {
        return componentToken;
    }

    public void setComponentToken(String componentToken) {
        this.componentToken = componentToken;
    }

    public String getComponentAesKey() {
        return componentAesKey;
    }

    public void setComponentAesKey(String componentAesKey) {
        this.componentAesKey = componentAesKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }
}
