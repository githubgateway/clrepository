package com.hackathon.security.springsecurityoauthclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@EnableWebMvc
@Configuration
public class webConfig extends WebMvcConfigurerAdapter{
	@Override
	public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer ){
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
//		registry.addResourceHandler("/css/**").addResourceLocations("static/css/").setCachePeriod(31556926);
//		registry.addResourceHandler("/img/**").addResourceLocations("static/img/").setCachePeriod(31556926);
//		registry.addResourceHandler("/js/**").addResourceLocations("static/js/").setCachePeriod(31556926);
		
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
			
	}

	@Override 
	public void addViewControllers(ViewControllerRegistry registry) { 
		super.addViewControllers(registry); 
//		registry.addViewController("/login").setViewName("login");
//		registry.addViewController("/forgot").setViewName("forgot");
//		registry.addViewController("/questionAnswer").setViewName("questionAnswer");
//		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		registry.addViewController("/")
		.setViewName("forward:/index");
		
		registry.addViewController("/index");
		registry.addViewController("/secure");
	} 
	
	@Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
    /*    formatterRegistry.addFormatter(new WorkspaceFormatter());
        formatterRegistry.addFormatter(new AssetFormatter());
        formatterRegistry.addFormatter(new GraphFormatter());
        formatterRegistry.addFormatter(new CategoryFormatter()); */
//        formatterRegistry.addFormatter(new QuestionFormatter());
    }

	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getDefaultWorkspaceInterceptor());
	}
	
	@Bean
	public HandlerInterceptorAdapter getDefaultWorkspaceInterceptor(){
		return new DefaultWorkspaceSessionInterceptor();
	}*/
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfig(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public RequestContextListener requestContextListener(){
		return new RequestContextListener();
	}
}
