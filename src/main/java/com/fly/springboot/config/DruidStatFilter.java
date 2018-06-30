package com.fly.springboot.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author fly
 * @date 2018/6/30 16:57
 * @description: Druid的拦截器
 **/
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/",
initParams = {@WebInitParam(name = "exclusions",
        value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")})
public class DruidStatFilter extends WebStatFilter {
}
