package springDemo.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springDemo.com.interceptor.MyInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Bean
    public MyInterceptor getInterceptor() {
        return new MyInterceptor();
    }
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getInterceptor()).addPathPatterns("/demo/**");
        // registry.addInterceptor(new InterfaceAuthCheckInterceptor()).addPathPatterns("/api/**");
        // 如果interceptor中不注入redis或其他项目可以直接new，否则请使用上面这种方式
        super.addInterceptors(registry);
    }
}
