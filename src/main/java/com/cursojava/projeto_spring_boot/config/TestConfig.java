package com.cursojava.projeto_spring_boot.config;

import com.cursojava.projeto_spring_boot.entities.Order;
import com.cursojava.projeto_spring_boot.entities.User;
import com.cursojava.projeto_spring_boot.entities.enums.OrderStatus;
import com.cursojava.projeto_spring_boot.repositories.OrderRepository;
import com.cursojava.projeto_spring_boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Melina Silva", "melina@email.test", "0800-0080", "123455", null);
        User u2 = new User("Spike Silva", "spike@silva.test", "9999-8888", "987654321", null);

        Order o1 = new Order(null, Instant.parse("2025-01-15T15:13:00Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2025-01-13T16:13:00Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2025-01-14T20:13:00Z"), OrderStatus.DELIVERED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
