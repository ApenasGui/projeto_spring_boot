package com.cursojava.projeto_spring_boot.config;

import com.cursojava.projeto_spring_boot.entities.User;
import com.cursojava.projeto_spring_boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Melina Silva", "melina@email.test", "0800-0080", "123455", null);
        User u2 = new User("Spike Silva", "spike@silva.test", "9999-8888", "987654321", null);

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
