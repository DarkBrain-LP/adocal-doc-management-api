package com.adocal.barkbrain.subject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubjectConfig {
    /*
    @Bean
    CommandLineRunner commandLineRunner(SubjectRepository repository){
        return args -> {
            Subject anaMaths = new Subject(
                    "Analyse Mathématiques",
                    3);
            Subject mathsDiscretes = new Subject(
                    "Mathématiques Discrète",
                    3);

            repository.saveAll(
                    List.of(anaMaths, mathsDiscretes)
            ) ;
        } ;
    }
    */
}
