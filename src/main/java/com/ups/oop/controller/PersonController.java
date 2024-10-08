package com.ups.oop.controller;

import com.ups.oop.dto.PersonDTO;
import com.ups.oop.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
    public class PersonController {
        private final PersonService personService;

        public PersonController(PersonService personService){
            this.personService =  personService;
        }

        @GetMapping("/get-all-people")
        public ResponseEntity getAllPeople(){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person List not found");
        }

        @GetMapping("/get-person")
        public ResponseEntity getPersonById(@RequestParam String id){
            return this.personService.getPersonById(id);
    }
        @PostMapping("/templates/person")
        public ResponseEntity createPerson(@RequestBody PersonDTO person) {
        return this.personService.createPerson(person);
    }

    @PutMapping("/update-person")
    public PersonDTO updatePerson(@RequestParam String id, @RequestBody PersonDTO person){
            return this.personService.updatePerson(id, person);
    }

    @DeleteMapping("/remove-person")
    public String deletePerson(@RequestParam String id){
            return this.personService.deletePersonById(id);
    }
}
