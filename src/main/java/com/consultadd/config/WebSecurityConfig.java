package com.consultadd.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((req)->req.requestMatchers("/","/employee").permitAll().anyRequest().authenticated())

                .formLogin();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
//        UserDetails user= User.withDefaultPasswordEncoder().username("abc").password("123").roles().build();
//        UserDetails user1= User.withDefaultPasswordEncoder().username("abc1").password("123").roles().build();
//        UserDetails user2= User.withDefaultPasswordEncoder().username("abc2").password("123").roles().build();
//        return new InMemoryUserDetailsManager(user,user2,user1);
        return new CustomUserDetailService();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(8);
//    }
}
