package com.adocal.barkbrain.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Subject addSubject(Subject subject) {
        Optional<Subject> optionalSubject = subjectRepository.
                findByTitle(subject);

        if(optionalSubject.isPresent()){
            throw new IllegalStateException("The subject already exists");
        }

        subjectRepository.save(subject);

        return subject;
    }
}
