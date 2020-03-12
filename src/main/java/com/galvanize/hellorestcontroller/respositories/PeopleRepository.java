package com.galvanize.hellorestcontroller.respositories;

import com.galvanize.hellorestcontroller.entities.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleRepository {

    List<Person> personDatabase=new ArrayList<>();
    long nextID = 1L;

    public Person addPerson(Person person){
        person.setId(nextID++);
        personDatabase.add(person);
        return person;
    }

    public Person save(Person person){
        if(person!=null){
            addPerson(person);
            return person;
        }
        else return null;
    }

    public Person update(Person person){
        if(personDatabase.size()>=person.getId()){
            personDatabase.get((int)person.getId()-1).update(person);
            return personDatabase.get((int)person.getId()-1);
        }
        else {
            return save(person);
        }
    }

    public List getDatabase(){
        return personDatabase;
    }

    public Person getPersonById(int id) {
        if(personDatabase.size()>=id) {
            return personDatabase.get(id - 1);
        }
        return null;
    }

    private int findPersonByName(String name){
        for(Person person : personDatabase){
            if(person.getName().equals(name)){
                return (int)person.getId()-1;
            }
        }
        return -1;
    }

    public Person getPersonByName(String name) {
        int foundIndex = findPersonByName(name);
        if(foundIndex!=-1){return personDatabase.get(foundIndex);}
        return null;
    }

    public Person delete(int id) {
        if(personDatabase.size()>=id){
            return personDatabase.remove(id-1);
        }
        return null;
    }

//    public Person deleteByName(String name) {
//        int foundIndex = findPersonByName(name);
//        if(foundIndex!=-1){return delete(foundIndex);}
//        return null;
//    }
}
