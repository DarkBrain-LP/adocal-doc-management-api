package com.adocal.barkbrain.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DocService {
    private final DocRepository docRepository;

    @Autowired
    public DocService(DocRepository docRepository) {
        this.docRepository = docRepository;
    }

    public List<Doc> getDocs(){
        return docRepository.findAll();
    }

    public void addNewDoc(Doc doc) {
        System.out.println(doc);
        Optional<Doc> checkedDoc =  docRepository.findDocByNameAndDirectoryName( doc.getName(), doc.getDirectoryName());

        if(checkedDoc.isPresent()){
            throw new IllegalStateException("This name already exists in that directory");
        }

        docRepository.save(doc);
    }

    public void deleteDoc(Integer docId) {
        boolean exists = docRepository.existsById(docId);

        if(!exists){
            throw new IllegalStateException("There is any document with id " + docId);
        }

        docRepository.deleteById(docId );
    }

    @Transactional
    public Doc putDoc(Integer docId, String name, String directoryName) {
        Doc doc = docRepository.findById(docId)
                .orElseThrow(() -> new IllegalStateException("There is any doc with the id " + docId));

        if(name != null && name.length() > 0 && !Objects.equals(doc.getName(), name)){
            doc.setName(name);
        }

        if(directoryName != null && directoryName.length() > 0 && !Objects.equals(doc.getDirectoryName(), directoryName)){
            Optional<Doc> docOptional = docRepository.findDocByNameAndDirectoryName(name, directoryName);

            if(docOptional.isPresent()){
                throw new IllegalStateException("Name already exists");
            }

            doc.setDirectoryName(directoryName);
        }

        return doc;
    }
}
