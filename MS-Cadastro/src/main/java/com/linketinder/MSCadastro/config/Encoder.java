package com.linketinder.MSCadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Encoder {
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
