package com.example.demospring.relationship.controller;

import com.example.demospring.relationship.model.Person;
import com.example.demospring.relationship.model.PersonRequest;
import com.example.demospring.relationship.service.PersonService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/person")
@AllArgsConstructor

public class PersonController {
    private PersonService personService;

    @GetMapping
    public ResponseEntity<?> getAllPerson (){
        List<Person> person = personService.getAllPerson();
        return ResponseEntity.ok(person);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllById(@PathVariable Integer id){
        Optional<Person> person = personService.getAllById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<?> createPerson (@RequestBody PersonRequest personRequest){
        Person person = personService.createPerson(personRequest);
        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson (@RequestBody PersonRequest personRequest,@PathVariable Integer id){
        Optional<Person> person = personService.updatePerson(personRequest,id);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson (@PathVariable Integer id){
        Optional<Person> person = personService.deletePerson(id);
        return ResponseEntity.ok(person);
    }


}
