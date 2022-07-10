package org.wireless.woodmen.woodmall.api.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.wireless.woodmen.woodmall.api.logging.HttpLogInterceptor;

@RequiredArgsConstructor
@Configuration
public class ApiConfig extends WebMvcConfigurationSupport {
	private final HttpLogInterceptor httpLogInterceptor;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(httpLogInterceptor).addPathPatterns("/**");
	}
}
