package com.galvanize.hellorestcontroller.controllers;

import com.galvanize.hellorestcontroller.entities.Person;
import com.galvanize.hellorestcontroller.respositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
public class HelloRestController {

    @Autowired
    PeopleRepository peopleRepository;

    @GetMapping("/hello")
    public Person helloPerson(@RequestParam String name, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate, @RequestParam String email){
        return new Person(name, email, birthDate);
    }

    //------------------Create---------------------------

    @PostMapping
    public Person postPerson(@RequestBody Person person){
        return peopleRepository.save(person);
    }

    //------------------Read-----------------------------

    @GetMapping
    public List findAllPeople(){
        return peopleRepository.getDatabase();
    }

    @GetMapping("/id/{id}")
    public Person findById(@PathVariable int id){
        return peopleRepository.getPersonById(id);
    }

    @GetMapping("/person")
    public Person findByName(@RequestParam(required = false) String name){
        return peopleRepository.getPersonByName(name);
    }

    //------------------Update-----------------------------

    @PatchMapping("/{id}")
    public Person updateByID(@PathVariable long id, @RequestBody Person person){
        person.setId(id);
        return peopleRepository.update(person);
    }

    //-----------------Destroy-----------------------------

    @DeleteMapping("/id/{id}")
    public Person deleteById(@PathVariable int id){
        return peopleRepository.delete(id);
    }

    //Not yet implemented
//    @DeleteMapping("/{name}")
//    public Person deleteByName(@PathVariable String name){
//        return peopleRepository.deleteByName(name);
//    }

}
