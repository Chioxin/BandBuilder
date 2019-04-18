package com.skilldistillery.bandbuilder.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

// this you get for free when you configure the db connection in application.properties file
@Autowired
private DataSource dataSource;

// this bean is created in the application starter class if you're looking for it
@Autowired
private PasswordEncoder encoder;

@Override
protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        	.antMatcher("/api/bands")
        .authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
	        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	        .and()
        .authorizeRequests()
//       	.antMatchers("/api/**").authenticated() 
        	.anyRequest().authenticated()               
//      	.anyRequest().permitAll()               
        .and()
        .httpBasic();                           // Use HTTP Basic Authentication

        http
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    String userQuery = "SELECT username, password, enabled FROM User WHERE username=?";
    String authQuery = "SELECT username, role FROM User WHERE username=?";
    auth
      .jdbcAuthentication()
      .dataSource(dataSource)
      .usersByUsernameQuery(userQuery)
      .authoritiesByUsernameQuery(authQuery)
      .passwordEncoder(encoder);
  }
}