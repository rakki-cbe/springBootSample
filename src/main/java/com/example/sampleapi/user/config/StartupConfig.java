package com.example.sampleapi.user.config;

import com.example.sampleapi.user.data.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Components are the item registered under the context of application layer
 */
@Component
public class StartupConfig implements CommandLineRunner {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private CredentialsService userService;

    @Bean
    public BCryptPasswordEncoder BcryptPasswordEncoder() {
        return passwordEncoder;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        var list = userService.getAllUser();
    }
}
