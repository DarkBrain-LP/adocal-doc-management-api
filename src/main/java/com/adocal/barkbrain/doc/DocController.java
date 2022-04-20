package com.adocal.barkbrain.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/adocal/docs")
public class DocController {
    private final DocService docService;

    @Autowired
    public DocController(DocService docService) {
        this.docService = docService;
    }

    @GetMapping
    public List<Doc> getDocs(){
        return docService.getDocs();
    }

    @PostMapping
    public void registerNewDoc(@RequestBody Doc doc){
        docService.addNewDoc(doc);
    }

    @PutMapping(path = "{docId}")
    public Doc updateDoc(@PathVariable("docId") Integer docId,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String directoryName){
        return docService.putDoc(docId, name, directoryName);
    }

    @DeleteMapping(path = "{docId}")
    public void deleteDoc(@PathVariable("docId") Integer docId){
        docService.deleteDoc(docId);
    }
}
