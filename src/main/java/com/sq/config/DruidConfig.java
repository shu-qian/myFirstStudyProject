package com.sq.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sq ♥ovo♥
 * @date 2023/9/15 - 14:45
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //配置 Druid 监控管理后台的Servlet,写好的死的，拿来可用
    //相当于web.xml
    //因为sb内置了servlet容器，所以没有web.xml,替代方法：ServletRegistrationBean,以使用 Spring Boot 的注册 Servlet 方式
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台登录，账户密码配置
        HashMap<String,String> initParameters = new HashMap<>();

        //增加配置
        initParameters.put("loginUsername","admin");    //登录的两个key是固定的，loginUsername，loginPassword
        initParameters.put("loginPassword","123");

        //允许谁可访问
        initParameters.put("allow",""); //后面是""则所有人都可访问,"localhost"只能本机访问,或写一个具体的人

        //禁止谁访问
        initParameters.put("kuang","192.168.11.123");   //后面的ip不可以访问

        bean.setInitParameters(initParameters);   //设置初始化参数

        return bean;
    }

    //配置 Druid 监控 之 web 监控的 filter
    //WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
    //平时在工作中，按需求进行配置即可，主要用作监控！
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();

        //这些东西不进行统计
        //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*,/jdbc/*");

        bean.setInitParameters(initParameters);

        //"/*" 表示过滤所有请求
//        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
