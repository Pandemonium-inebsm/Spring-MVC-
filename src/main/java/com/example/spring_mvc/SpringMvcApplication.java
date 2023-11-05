package com.example.spring_mvc;

import com.example.spring_mvc.entities.Patient;
import com.example.spring_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Ichraq",new Date(),false,12));
            patientRepository.save(new Patient(null,"Sabrine",new Date(),true,14));
            patientRepository.save(new Patient(null,"Mohammed",new Date(),false,13));
            patientRepository.save(new Patient(null,"Loubna",new Date(),true,16));
            patientRepository.save(new Patient(null,"Mustapha",new Date(),false,18));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }

}
