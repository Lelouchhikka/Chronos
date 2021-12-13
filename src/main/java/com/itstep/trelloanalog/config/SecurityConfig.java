package com.itstep.trelloanalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/css/**", "/js/**").permitAll()
            .antMatchers("/").permitAll();

    http.formLogin().loginPage("/").permitAll()
            .loginProcessingUrl("/auth").permitAll()
            .usernameParameter("email")
            .passwordParameter("password")
            .successForwardUrl("/")
            .defaultSuccessUrl("/")
            .failureUrl("/login?error");

    http.logout().logoutUrl("/logout")
            .logoutSuccessUrl("/login").permitAll();

  }



  @Bean
  public BCryptPasswordEncoder bcryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
