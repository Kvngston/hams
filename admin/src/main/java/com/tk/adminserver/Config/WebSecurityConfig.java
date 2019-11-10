package com.tk.adminserver.Config;

import com.tk.adminserver.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); //Cross Site request forgery
        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
                .antMatchers("/index","/dashboard").authenticated() // any url that isnt the ant matchers users can't access the page and it runs only when authenticated
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/dashboard", true)
                .and()
                .logout()
                .permitAll();


    }

    @Bean
    //this is for encrpting passwords in spring
    public BCryptPasswordEncoder encodePWD() {


        return new BCryptPasswordEncoder();
    }
}
