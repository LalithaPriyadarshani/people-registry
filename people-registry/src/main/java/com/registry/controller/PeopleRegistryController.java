package com.registry.controller;


import com.registry.model.Child;
import com.registry.model.Person;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${base-url.context}")
public class PeopleRegistryController {


    @PostMapping(value = "/savePerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEntity> savePerson(@RequestBody(required = true)Person person) {
}


    @GetMapping("/retrievePerson")
    public ResponseEntity<Person> retrievePerson(@RequestParam long personalNum)
    {
    }

    @GetMapping("/retrieveOldestChild")
    public ResponseEntity<Child> retrieveOldestChild(@RequestParam long personalNum)
    {
    }
}

