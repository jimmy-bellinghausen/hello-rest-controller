package com.galvanize.hellorestcontroller.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Period;

public class Person{

    long id;
    String name;
    String email;
    @JsonFormat(pattern = "MM/dd/yyyy")
    LocalDate birthDate;

    public Person(){
    }

    public Person(String name, String email, LocalDate birthDate){

        this.name = name;
        this.email = email;
        this.birthDate = birthDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonFormat(pattern = "MM/dd/yyyy")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @JsonFormat(pattern = "MM/dd/yyyy")
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {

        return Period.between(this.birthDate, LocalDate.now()).getYears();

    }

    public void update(Person person) {
        if(person.getBirthDate()!=null){
            setBirthDate(person.getBirthDate());
        }
        if(person.getName()!=null){
            setName(person.getName());
        }
        if(person.getEmail()!=null){
            setEmail(person.getEmail());
        }
    }
}
