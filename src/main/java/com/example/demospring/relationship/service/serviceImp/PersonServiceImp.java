package com.example.demospring.relationship.service.serviceImp;
import com.example.demospring.relationship.exception.CustomNotfoundException;
import com.example.demospring.relationship.model.Passport;
import com.example.demospring.relationship.model.Person;
import com.example.demospring.relationship.model.PersonRequest;
import com.example.demospring.relationship.repository.PersonRepository;
import com.example.demospring.relationship.service.PassportService;
import com.example.demospring.relationship.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService {
    private final PersonRepository personRepository;
//    private final PassportService passportService;

    public PersonServiceImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
//        this.passportService = passportService;
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getAllById(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        if(!person.isPresent()){
            throw new EntityNotFoundException("Not Found");
        }
        return person;
    }

    @Override
    public Person createPerson(PersonRequest personRequest) {
//        Optional<Passport> passport = passportService.getAllById(personRequest.getPassportId());
//        if(!passport.isPresent()){
//            throw new CustomNotfoundException("Not Found");
//        }
        Person person = new Person();
        person.setName(personRequest.getName());
//        person.setPassport(passport.get());

        return personRepository.save(person);
    }

    @Override
    public Optional<Person> updatePerson(PersonRequest personRequest, Integer id) {
        Optional<Person> personById = personRepository.findById(id);
        Person person1 = personById.get();
        person1.setName(personRequest.getName());
        personRepository.save(person1);
        return Optional.of(person1);
    }

    @Override
    public Optional<Person> deletePerson(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        if(!person.isPresent()){
            throw new EntityNotFoundException("Not Found");
        }
        personRepository.deleteById(id);
        return person;
    }
}
