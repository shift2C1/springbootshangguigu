package com.pipichao.helloword.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义springmvc的配置:合计springboot对mvc的配置和自定义的mvc配置
 * 是一种适配器模式，将自己的和spring 的配置适配起来
 *
 * */

@Configuration
//@EnableWebMvc//加上这个注解后spring自动配置的mvc将失效，这时，我们必须全部自己配置mvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
}
