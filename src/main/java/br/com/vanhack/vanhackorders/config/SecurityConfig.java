package br.com.vanhack.vanhackorders.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.vanhack.vanhackorders.security.SecurityConstants;

@Configuration
@EnableWebSecurity
@ComponentScan({"br.com.vanhack.vanhackorders.security", "br.com.vanhack.vanhackorders.service"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        		.antMatchers("/api/v1/Cousine/**").permitAll()
        		.antMatchers("/api/v1/Store/**").permitAll()
        		.antMatchers("/api/v1/Product/**").permitAll()
				.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
                .anyRequest().authenticated();
    }
    
}