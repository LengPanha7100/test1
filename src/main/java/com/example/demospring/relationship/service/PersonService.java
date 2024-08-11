package com.example.demospring.relationship.service;

import com.example.demospring.relationship.model.Person;
import com.example.demospring.relationship.model.PersonRequest;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPerson();

    Optional<Person> getAllById(Integer id);

    Person createPerson(PersonRequest personRequest);

    Optional<Person> updatePerson(PersonRequest personRequest, Integer id);

    Optional<Person> deletePerson(Integer id);
}
