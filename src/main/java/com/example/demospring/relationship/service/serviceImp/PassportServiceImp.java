package com.example.demospring.relationship.service.serviceImp;

import com.example.demospring.relationship.exception.CustomNotfoundException;
import com.example.demospring.relationship.model.Passport;
import com.example.demospring.relationship.model.PassportRequest;
import com.example.demospring.relationship.model.Person;
import com.example.demospring.relationship.repository.PassportRepository;
import com.example.demospring.relationship.repository.PersonRepository;
import com.example.demospring.relationship.service.PassportService;
import com.example.demospring.relationship.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PassportServiceImp implements PassportService {

    private final PassportRepository passportRepository;
    private final PersonService personService;

    public PassportServiceImp(PassportRepository passportRepository, PersonService personService) {
        this.passportRepository = passportRepository;

        this.personService = personService;
    }

    @Override
    public List<Passport> getAllPassport() {
        return passportRepository.findAll();
    }

//    @Override
//    public Optional<Passport> getAllById(Integer id) {
//        Optional<Passport> passport = passportRepository.findById(id);
//        if(!passport.isPresent()){
//            throw new RuntimeException("Not Found");
//        }
//        return passport;
//    }

    @Override
    public Passport createPassport(PassportRequest passportRequest) {
        Optional<Person> person = personService.getAllById(passportRequest.getPersonId());
        if(!person.isPresent()){
            throw new EntityNotFoundException("Not Found");
        }
        Passport passport = new Passport();
        passport.setNumber(passportRequest.getNumber());
        passport.setPerson(person.get());
        return passportRepository.save(passport);
    }

    @Override
    public Passport updatePassport(PassportRequest passportRequest, Integer id) {
        Optional<Person> person = personService.getAllById(passportRequest.getPersonId());
        Passport passport = passportRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Not Found")
        );
        Passport passport1 = new Passport();
        passport1.setNumber(passportRequest.getNumber());
        passport1.setPerson(person.get());
        return passportRepository.save(passport1);
    }

    @Override
    public Passport deletePassport(Integer id) {
        Passport passport = passportRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Not Found")
        );
        passportRepository.deleteById(id);
        return passport;
    }
    @Override
    public Optional<Passport> getAllById(Integer id) {
        Optional<Passport> passport = passportRepository.findById(id);
        if(!passport.isPresent()){
            throw new RuntimeException("Not Found");
        }
        return passport;
    }
}
