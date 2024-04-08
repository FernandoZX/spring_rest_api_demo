package com.fcabrera89.rest_api_demo.Person;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public List<Person> findAll() {
    return personRepository.findAll();
  }
  public void createPerson(Person person) {
    personRepository.save(person);
  }

  public Optional<Person> getPerson(Integer id){

    return personRepository.findById(id);
  }

  public void deletePerson(int id) {
    personRepository.deleteById(id);
  }
  public void updatePerson(int id, Person person) {
    var existingPerson = personRepository.findById(id);
    if(existingPerson.isPresent()){
      personRepository.save(personObject(person, existingPerson.get()));
    }else{
      System.out.println("No existe el usuario con ID " + id);
    }
  }

  private Person personObject(Person entryPerson, Person existingPerson) {
    System.out.println("firstname blank?"+ entryPerson.getFirstname());
    if (entryPerson.getFirstname()!=null){
      existingPerson.setFirstname(entryPerson.getFirstname());
    }
    existingPerson.setLastname(entryPerson.getLastname());
    existingPerson.setEmail(entryPerson.getEmail());
    existingPerson.setAge(entryPerson.getAge());

    return existingPerson;
  }

}
