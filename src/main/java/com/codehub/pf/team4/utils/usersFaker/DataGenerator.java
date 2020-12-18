package com.codehub.pf.team4.utils.usersFaker;

import com.codehub.pf.team4.domains.Property;
import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import com.codehub.pf.team4.repository.PropertyRepository;
import com.codehub.pf.team4.repository.RepairRepository;
import com.codehub.pf.team4.repository.UserRepository;
import com.codehub.pf.team4.utils.RandomnessProvider;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class DataGenerator {
    @Bean
    public CommandLineRunner bun(UserRepository userRepository) throws Exception {
        return (String[] args) -> {

            Faker faker = new Faker();

            for (long i = 0; i < 17; i++) {
                User user1 = new User();
                user1.setFirstName(faker.name().firstName());
                user1.setLastName(faker.name().lastName());
                user1.setAddress(faker.address().streetAddress());
                user1.setAfm(RandomnessProvider.getRandomNumber(9));
                user1.setEmail(faker.pokemon().name() + RandomnessProvider.getRandomNumber(2,5) + "@gmail.com");
                user1.setPassword(String.valueOf(RandomnessProvider.getRandomNumber(9)));
                user1.setPhoneNumber(RandomnessProvider.getRandomNumber(10L));
                user1.setRoles(RandomnessProvider.getRoles());

                userRepository.save(user1);
            }
            userRepository.findAll().forEach(user -> System.out.println(user));
        };
    }

    @Autowired
    UserRepository userRepository;
    @Bean
    public CommandLineRunner run(RepairRepository repairRepository) throws Exception {
        return (String[] args) -> {

            Faker faker = new Faker();
            long id = 8;

            for (long a = 1 ; a < 25 ; a++) {
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

                    id++;
                }
            }
            repairRepository.findAll().forEach(repair -> System.out.println(repair));
        };

    }

    @Bean
    public CommandLineRunner run2(PropertyRepository propertyRepository) throws Exception{
        return (String[] args) -> {
            Faker faker = new Faker();

            for (long a = 1; a < 25 ; a++){
                for (long i = 0; i < RandomnessProvider.getRandomNumber(1,2); i++){
                    Property property1 = new Property();
                    property1.setUser(userRepository.getOne(a));
                    property1.setPropertyId(Long.valueOf(RandomnessProvider.getRandomNumber(9)));
                    property1.setAddress(faker.address().streetAddress());
                    property1.setYearOfConstruction(String.valueOf(RandomnessProvider.getRandomNumber(1952,2020)));
                    property1.setHouseType(RandomnessProvider.getRandomHouseType());

                    propertyRepository.save(property1);
                }
            }

            propertyRepository.findAll().forEach(property -> System.out.println(property));

        };
    }
}
