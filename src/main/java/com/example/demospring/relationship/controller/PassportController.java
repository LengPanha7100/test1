package com.example.demospring.relationship.controller;

import com.example.demospring.relationship.model.Passport;
import com.example.demospring.relationship.model.PassportRequest;
import com.example.demospring.relationship.service.PassportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/passport")
public class PassportController {
    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPassport(){
        List<Passport> passport = passportService.getAllPassport();
        return ResponseEntity.ok(passport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllById(@PathVariable Integer id){
        Optional<Passport> passport = passportService.getAllById(id);
        return ResponseEntity.ok(passport);
    }

    @PostMapping
    public ResponseEntity<?> createPassport(@RequestBody PassportRequest passportRequest){
        Passport passport = passportService.createPassport(passportRequest);
        return ResponseEntity.ok(passport);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updatePassport(@RequestBody PassportRequest passportRequest,@PathVariable Integer id){
        Passport passport = passportService.updatePassport(passportRequest,id);
        return ResponseEntity.ok(passport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePassport(@PathVariable Integer id){
        Passport passport = passportService.deletePassport(id);
        return ResponseEntity.ok(passport);
    }

}
