package com.galvanize.hellorestcontroller.entities;

import java.time.LocalDate;
import java.time.Period;

public class Person{

    long age;
    String name;
    String email;
    LocalDate birthDate;

    private void getAge(LocalDate birthDate) {
        age = Period.between(birthDate, LocalDate.now()).getYears();
    }

    Person(){

        this.name = "";
        this.email = "";
        this.birthDate = LocalDate.now();
        this.getAge(birthDate);
    }

    Person(String name, String email, LocalDate birthDate){

        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.getAge(birthDate);

    }

}
