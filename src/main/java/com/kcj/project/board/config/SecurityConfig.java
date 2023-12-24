package com.kcj.project.board.config;

import com.kcj.project.board.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new MemberService();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web
                .ignoring()
                .requestMatchers(new AntPathRequestMatcher("/img/**"))
                .requestMatchers(new AntPathRequestMatcher("/css/**"));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest()
                        .permitAll()
                )
                .userDetailsService(userDetailsService())
                .formLogin(loginSecurity -> {
                    loginSecurity
                            .loginPage("/login")
                            .loginProcessingUrl("login/sign")
                            .usernameParameter("memberId")
                            .passwordParameter("password")
                            .successHandler((request, response, authentication) -> {
                                response.sendRedirect("/board");
                            })
                            .failureHandler((request, response, exception) -> {
                                response.sendRedirect("/login");
                            })
                            .permitAll();
                })
                .logout(logoutSecurity -> {
                    logoutSecurity
                            .logoutUrl("/logout")
                            .logoutSuccessHandler((request, response, authentication) -> {
                                response.sendRedirect("/login");
                            })
                            .permitAll();
                })
                .rememberMe(rememberMeSecurity -> {
                    rememberMeSecurity
                            .rememberMeCookieName("cookie")
                            .alwaysRemember(true)
                            .tokenValiditySeconds(3600);
                });

        return http.build();
    }

}
