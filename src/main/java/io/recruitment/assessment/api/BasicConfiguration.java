package io.recruitment.assessment.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import io.recruitment.assessment.config.GlobalConstants;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder encoder = 
          PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	auth
          .inMemoryAuthentication()
          .withUser("user")
          .password(encoder.encode("userpass"))
          .roles(GlobalConstants.Roles.CUSTOMER)
          .and()
          .withUser("adminuser")
          .password(encoder.encode("adminpass"))
          .roles(GlobalConstants.Roles.CUSTOMER, GlobalConstants.Roles.ADMIN);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .formLogin()
        .and()
          .authorizeRequests()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }
}