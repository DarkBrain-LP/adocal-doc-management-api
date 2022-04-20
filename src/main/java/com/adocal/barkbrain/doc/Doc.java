package com.adocal.barkbrain.doc;

import com.adocal.barkbrain.subject.Subject;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Doc {
    @Id
    @SequenceGenerator(
            name = "doc_sequence",
            sequenceName = "doc_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doc_sequence"
    )
    private Integer id;
    private String name;
    public Long size;
    public String directoryName;
    private LocalDate uploadedDate;

    //private Subject subject;
    //nom, date d'upload, taille du fichier, repertoire


    public Doc(String name, Long size, String directoryName, LocalDate uploadedDate) {
        this.name = name;
        this.size = size;
        this.directoryName = directoryName;
        this.uploadedDate = uploadedDate;
    }

    public Doc() {
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", directoryName='" + directoryName + '\'' +
                ", uploadedDate=" + uploadedDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public LocalDate getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(LocalDate uploadedDate) {
        this.uploadedDate = uploadedDate;
    }
}
