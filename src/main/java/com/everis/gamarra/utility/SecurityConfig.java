package com.everis.gamarra.utility;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

 // public static final String REALM_NAME = "memorynotfound.com";

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/api/v1.0/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
       // .realmName(REALM_NAME);
        //.authenticationEntryPoint(new CustomAuthenticationEntryPoint());

  }


}
