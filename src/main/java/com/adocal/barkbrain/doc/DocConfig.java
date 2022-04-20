package com.adocal.barkbrain.doc;

import com.adocal.barkbrain.subject.Subject;
import com.adocal.barkbrain.subject.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DocConfig {
    // Initializing some docs
    @Bean
    CommandLineRunner commandLineRunner(DocRepository repository, SubjectRepository subjectRepository){
        return args -> {
            // Creating the docs
            Doc devJava = new Doc(
                    "Devoir2021",
                    15L,
                    "Java",
                    LocalDate.of(2022, Month.APRIL, 17)
            );
            Doc devPython = new Doc(
                    "Devoir2021",
                    18L,
                    "Python",
                    LocalDate.of(2022, Month.APRIL, 19)
            );

            // Saving them in the database
            repository.saveAll(
                    List.of(devJava, devPython)
            ) ;

            Subject anaMaths = new Subject(
                    "Analyse Mathématiques",
                    3);
            Subject mathsDiscretes = new Subject(
                    "Mathématiques Discrète",
                    3);

            subjectRepository.saveAll(
                    List.of(anaMaths, mathsDiscretes)
            ) ;
        } ;
    }
}
