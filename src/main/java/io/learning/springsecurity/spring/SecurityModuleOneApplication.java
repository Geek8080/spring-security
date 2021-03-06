package io.learning.springsecurity.spring;

import io.learning.springsecurity.persistence.InMemoryUserRepository;
import io.learning.springsecurity.persistence.UserRepository;
import io.learning.springsecurity.web.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
@ComponentScan("io.learning.springsecurity.web")
public class SecurityModuleOneApplication {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public Converter<String, User> messageConverter() {
        return new Converter<String, User>() {
            @Override
            public User convert(String id) {
                return userRepository().findUser(Long.valueOf(id));
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityModuleOneApplication.class, args);
    }

}
