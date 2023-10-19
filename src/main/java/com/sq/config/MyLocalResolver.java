package com.sq.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * @author sq ♥ovo♥
 * @date 2023/9/8 - 13:15
 */
//@Configuration
public class MyLocalResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String language = request.getParameter("l");

        Locale locale = Locale.getDefault();    //如果没有就使用默认的


        if (!StringUtils.isEmpty(language)){
            //zn_CN
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }


}
