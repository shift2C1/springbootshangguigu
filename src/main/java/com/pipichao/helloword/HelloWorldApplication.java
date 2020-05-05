package com.pipichao.helloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class,args);
    }
}


/**
 * spring boot 自动配置原理：
 *
 * @EnableAutoConfiguration：中导入了一个配置类：AutoConfigurationImportSelector
 *
 * 将 springboot-autoconfig 包里的 spring.factoties 配置文件中的数据读取到，
 * 转换成一个全类名的list
 *
 * 将这个list包含的全类名 创建成对象，加载到ioc容器中（并不是所有在spring.factoties的类都装载到ioc）
 * 由@Condition 条件控制是否装载
 *
 * xxxAutoConfiguration 就是自动 该功能自动配置的类，它里边有的属性就是 yaml文件里的属性
 * 例如：
 *  @Configuration//这是一个配置类
 * @ConditionalOnWebApplication(type = Type.SERVLET)//满足条件才可以装载到ioc容器
 * @ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })//满足条件才可以装载到ioc容器
 * @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)//满足条件才可以装载到ioc容器
 * @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
 * @AutoConfigureAfter({ DispatcherServletAutoConfiguration.class,
 * 		ValidationAutoConfiguration.class })
 * public class WebMvcAutoConfiguration {
 *     @Bean
 *        @ConditionalOnMissingBean(HiddenHttpMethodFilter.class)
 *    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
 * 		return new OrderedHiddenHttpMethodFilter();
 *    }
 *    ///////
 *    @Configuration
 *        @Import(EnableWebMvcConfiguration.class)
 *    @EnableConfigurationProperties({ 【【【【WebMvcProperties.class】】】（即是下面的配置类）, ResourceProperties.class })
 *    @Order(0)
 *    public static class WebMvcAutoConfigurationAdapter
 * 			implements WebMvcConfigurer, ResourceLoaderAware {
 *
 * 		private static final Log logger = LogFactory.getLog(WebMvcConfigurer.class);
 *
 * 		private final ResourceProperties resourceProperties;
 *
 * 		private final WebMvcProperties mvcProperties;
 *
 * 		private final ListableBeanFactory beanFactory;
 *
 * 		private final HttpMessageConverters messageConverters;
 *
 * 		final ResourceHandlerRegistrationCustomizer resourceHandlerRegistrationCustomizer;
 *
 * 		private ResourceLoader resourceLoader;
 *
 * 		public WebMvcAutoConfigurationAdapter(ResourceProperties resourceProperties,
 * 				WebMvcProperties mvcProperties, ListableBeanFactory beanFactory,
 *                @Lazy HttpMessageConverters messageConverters,
 * 				ObjectProvider<ResourceHandlerRegistrationCustomizer> resourceHandlerRegistrationCustomizerProvider) {
 * 			this.resourceProperties = resourceProperties;
 * 			this.mvcProperties = mvcProperties;
 * 			this.beanFactory = beanFactory;
 * 			this.messageConverters = messageConverters;
 * 			this.resourceHandlerRegistrationCustomizer = resourceHandlerRegistrationCustomizerProvider
 * 					.getIfAvailable();
 *        }
 *
 *
 *        */

/**
 * 该类所制定的 prefix = "spring.mvc" 即是我们在yaml中配置的属性，
 *        @ConfigurationProperties(prefix = "spring.mvc")
 * public class WebMvcProperties {
 *
 * }
 * }
 *
 * */
