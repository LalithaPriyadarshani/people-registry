package com.registry.controller;


import com.registry.model.Child;
import com.registry.model.OldestChild;
import com.registry.model.Person;
import com.registry.repository.PersonDao;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${base-url.context}")
public class PeopleRegistryController {


    @Autowired
    PersonDao personDao;


    @PostMapping(value = "/savePerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEntity> savePerson(@RequestBody(required = true)Person person)throws Exception {

        personDao.savePerson(person);
        return new ResponseEntity<>(HttpStatus.OK);

   }


    @GetMapping(value="/retrievePerson",produces = MediaType.APPLICATION_JSON_VALUE)
    public Person retrievePerson(@RequestParam long personalNum) throws Exception
    {
         return personDao.getPerson(personalNum);
    }

    @GetMapping(value="/retrieveOldestChild",produces = MediaType.APPLICATION_JSON_VALUE)
    public OldestChild retrieveOldestChild(@RequestParam long personalNum)
    {
        Child child=personDao.getOldestChild(personalNum);
        OldestChild oldestChild= new OldestChild();
        oldestChild.setChildName(child.getName());
        oldestChild.setPersonalNum(personalNum);

        return oldestChild;
    }
}

