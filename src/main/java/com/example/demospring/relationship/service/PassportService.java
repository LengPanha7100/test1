package com.example.demospring.relationship.service;

import com.example.demospring.relationship.model.Passport;
import com.example.demospring.relationship.model.PassportRequest;

import java.util.List;
import java.util.Optional;

public interface PassportService {
    List<Passport> getAllPassport();

    Passport createPassport(PassportRequest passportRequest);

    Passport updatePassport(PassportRequest passportRequest, Integer id);

    Passport deletePassport(Integer id);

    Optional<Passport> getAllById(Integer id);
}
