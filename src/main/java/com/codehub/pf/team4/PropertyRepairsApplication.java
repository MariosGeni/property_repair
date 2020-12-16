package com.codehub.pf.team4;

import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class PropertyRepairsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyRepairsApplication.class, args);

    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (String[] args) -> {

            Random rand = new Random();
            Faker faker = new Faker();

            for (long i = 0; i < 50; i++) {
                User user1 = new User();
                // user1.setId(10L+i);
                user1.setFirstName(faker.name().firstName());
                user1.setLastName(faker.name().lastName());
                user1.setAddress(faker.address().streetAddress());
                user1.setAfm(rand.nextInt(1000000000));
                user1.setEmail(faker.pokemon().name() + rand.nextInt(1000) + "@gmail.com");
                user1.setPassword(String.valueOf(rand.nextInt(100000000)));
                user1.setHouseType(HouseType.MAISONETTE);
                user1.setPhoneNumber(Long.valueOf(rand.nextInt(10000000)));

                userRepository.save(user1);
                userRepository.findAll().forEach(user -> System.out.println(user));
            }
        };

    }


}
