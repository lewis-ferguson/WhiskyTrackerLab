package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value ="/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String distilleryName,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String region
            ) {

        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year),HttpStatus.OK);
        } else if (distilleryName != null && age != null) {
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryName(age, distilleryName), HttpStatus.OK);
        } else if (region != null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(whiskyRepository.findAll(),HttpStatus.OK);

        }
    }

}


