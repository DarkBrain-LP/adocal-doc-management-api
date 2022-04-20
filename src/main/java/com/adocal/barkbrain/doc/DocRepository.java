package com.adocal.barkbrain.doc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocRepository extends JpaRepository<Doc, Integer> {

    // Select all docs that match the name and dir passed in the parameters
    Optional<Doc> findDocByNameAndDirectoryName(String name, String directoryName);
}
