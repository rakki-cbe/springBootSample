package com.example.sampleapi.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // Disabling CSRF
        http.authorizeHttpRequests((request) ->
                request.requestMatchers("/", "/home", "user/**", "/h2-console/**").permitAll().anyRequest().authenticated()).formLogin((form) -> form.loginPage("/login").permitAll()).logout(LogoutConfigurer::permitAll).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * This will fetch user from out local db for givent username and validate with password
     *
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }


   /*
   // for static authentication
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
    }*/

    /***
     * Used to ignore authantication for h2console
     * @return
     */
    @Bean
    WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**");
    }
}
