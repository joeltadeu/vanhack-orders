package br.com.vanhack.vanhackorders;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.vanhack.vanhackorders.security.JwtFilter;

@SpringBootApplication
public class VanhackOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(VanhackOrdersApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/v1/Order/*");
		registrationBean.addUrlPatterns("/api/v1/Customer/");
		return registrationBean;
	}
}
