package com.aver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mathew on 10/25/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
@EnableFeignClients
// @EnableHystrix
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    //
    // @Bean
    // public ConnectionFactory connectionFactory() {
    // CachingConnectionFactory connectionFactory = new
    // CachingConnectionFactory(
    // "localhost");
    // connectionFactory.setUsername("guest");
    // connectionFactory.setPassword("guest");
    // return connectionFactory;
    // }
    //
    // @Bean
    // public AmqpAdmin amqpAdmin() {
    // return new RabbitAdmin(connectionFactory());
    // }
}
