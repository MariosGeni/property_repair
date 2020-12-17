package com.codehub.pf.team4;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.repository.RepairRepository;
import com.codehub.pf.team4.repository.UserRepository;
import com.codehub.pf.team4.utils.RandomnessProvider;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PropertyRepairsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyRepairsApplication.class, args);

    }

    @Bean
    public CommandLineRunner bun(UserRepository userRepository) throws Exception {
        return (String[] args) -> {

            Faker faker = new Faker();

            for (long i = 0; i < 50; i++) {
                User user1 = new User();
                user1.setFirstName(faker.name().firstName());
                user1.setLastName(faker.name().lastName());
                user1.setAddress(faker.address().streetAddress());
                user1.setAfm(RandomnessProvider.getRandomNumber(9));
                user1.setEmail(faker.pokemon().name() + RandomnessProvider.getRandomNumber(2,5) + "@gmail.com");
                user1.setPassword(String.valueOf(RandomnessProvider.getRandomNumber(9)));
                user1.setHouseType(RandomnessProvider.getRandomHouseType());
                user1.setPhoneNumber(RandomnessProvider.getRandomNumber(10L));

                userRepository.save(user1);
                userRepository.findAll().forEach(user -> System.out.println(user));
            }
        };

    }

    @Autowired
    UserRepository userRepository;

    @Bean
    public CommandLineRunner run(RepairRepository repairRepository) throws Exception {
        return (String[] args) -> {

            Faker faker = new Faker();
            long id = 8;

            for (long a = 1 ; a < 18; a++) {
                for (long i = 0; i < RandomnessProvider.getRandomNumber(1,2); i++) {
                    Repair repair1 = new Repair();
                    repair1.setId(id);
                    repair1.setUser(userRepository.getOne(a));
                    repair1.setDate(LocalDate.of(2020,RandomnessProvider.getMonthGiver(),RandomnessProvider.getDayGiver()));
                    repair1.setState(RandomnessProvider.getRandomState());
                    repair1.setRepairType(RandomnessProvider.getRandomRepairType());
                    repair1.setCost(RandomnessProvider.getCost());
                    repair1.setAddress(faker.address().streetAddress());
                    repair1.setDescription(faker.lorem().sentence());

                    repairRepository.save(repair1);
                    repairRepository.findAll().forEach(repair -> System.out.println(repair));
                    id++;
                }
            }
        };

    }


}
