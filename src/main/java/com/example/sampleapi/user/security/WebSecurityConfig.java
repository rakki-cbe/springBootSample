package com.example.sampleapi.user.security;

import com.example.sampleapi.user.data.model.CredentialsDataModel;
import com.example.sampleapi.user.data.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public CredentialsService credentialsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf -> csrf.disable()) ; // Disabling CSRF
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/","/home","user/**").permitAll().anyRequest().authenticated())
                .formLogin((form)-> form.loginPage("/login").permitAll())
                .logout(LogoutConfigurer::permitAll).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<CredentialsDataModel> data = credentialsService.getAllUser();
        List<UserDetails> userDetails = data.stream().map( userDate -> {
            return User.builder()
                    .username(userDate.uerName)
                    .password(passwordEncoder().encode(userDate.password))
                    .roles("USER")
                    .build();

                }
        ).toList();
        UserDetails dataStatic = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        //userDetails.add(dataStatic);
        return new InMemoryUserDetailsManager(dataStatic);
    }

    @Bean
    WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**");
    }
}
