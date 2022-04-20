package com.adocal.barkbrain.subject;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "subject_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private String title;
    private Integer coefficient;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Subject(String title, Integer coefficient) {
        this.title = title;
        this.coefficient = coefficient;
    }

    public Subject() {
    }
}
