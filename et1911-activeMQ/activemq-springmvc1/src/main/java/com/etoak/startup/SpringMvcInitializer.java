package com.etoak.startup;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.etoak.config.RootConfig;
import com.etoak.config.SpringMvcConfig;
//相当于web.xml
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	//spring root容器
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}
	//spring mvc容器
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMvcConfig.class};
	}
	//拦截路径
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
