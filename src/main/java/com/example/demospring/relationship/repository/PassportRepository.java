package com.example.demospring.relationship.repository;

import com.example.demospring.relationship.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Integer> {
}
