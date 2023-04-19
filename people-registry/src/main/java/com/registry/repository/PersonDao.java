package com.registry.repository;

import com.registry.exception.CustomExceptionHandler;
import com.registry.exception.InvalidPersonalNumException;
import com.registry.model.Child;
import com.registry.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonDao {

    static List<Person> personList = new ArrayList<>();
    public void savePerson(Person person)
    {
        personList.add(person);
    }

    public Person getPerson(long personalNum)
    {
        for(Person person:personList)
        {
            if(person.getPersonalNumber()==personalNum)
                return person;
        }
        throw new InvalidPersonalNumException("Invalid Personal Number", HttpStatus.NOT_FOUND) ;
    }

    public Child getOldestChild(long personalNum)
    {
        List<Child> children=null;
        for(Person person:personList)
        {
            if(person.getPersonalNumber()==personalNum)
            // Collections.sort(person.getChildren(),);
                children=person.getChildren();
            if(null!=children) {
                Collections.sort(children);
                return children.get(0);
            }
        }
        return null;
    }

}
