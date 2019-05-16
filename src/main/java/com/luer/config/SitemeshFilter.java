package com.luer.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.stereotype.Component;

/**
 *
 * @author max
 * @date 2018/8/16
 */
@Component
public class SitemeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        super.applyCustomConfiguration(builder);
        builder.addDecoratorPath("/dataManage/**", "/layout/decorator.jsp")
                 .addDecoratorPath("/common/**", "/layout/decorator.jsp")
                .addDecoratorPath("/membershipManage/**", "/layout/decorator.jsp")
                .addDecoratorPath("/plan/**", "/layout/decorator.jsp")
                .addDecoratorPath("/report/**", "/layout/decorator.jsp")
                .addDecoratorPath("/auth/**", "/layout/decorator.jsp")
                .addDecoratorPath("/wx/**", "/layout/decorator.jsp")
                .addDecoratorPath("/materialManage/**", "/layout/decorator.jsp")
                .addDecoratorPath("/test/**", "/layout/decorator.jsp")
                .addDecoratorPath("/shortMessage/**", "/layout/decorator.jsp")
                .addDecoratorPath("/test/**", "/layout/decorator.jsp")
                .addDecoratorPath("/sys/**", "/layout/decorator.jsp")
                .addDecoratorPath("/problem/**", "/layout/decorator.jsp")
                .addDecoratorPath("/Updata/**", "/layout/decorator.jsp")
                .addDecoratorPath("/JD/**", "/layout/decorator.jsp")
                .addDecoratorPath("/OrderResult/**", "/layout/decorator.jsp")

        ;



    }
}
