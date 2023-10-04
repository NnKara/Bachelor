package com.kara.bachelorpapel.configuration;

import com.kara.bachelorpapel.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/registration").permitAll()
                                .requestMatchers("/**").permitAll()
                                .requestMatchers("/user").permitAll()
                                .requestMatchers("/user/**").permitAll()
                )
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .usernameParameter("username")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/user")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }


    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


}
