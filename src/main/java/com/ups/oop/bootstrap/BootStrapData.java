package com.ups.oop.bootstrap;

import com.ups.oop.dto.Person;
import com.ups.oop.entity.Animal;
import com.ups.oop.repository.AnimalRepository;
import com.ups.oop.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
private final PersonRepository personRepository;
private final AnimalRepository animalRepository;

public BootStrapData(PersonRepository personRepository, AnimalRepository animalRepository, AnimalRepository animalRepository1){
    this.personRepository = personRepository;
    this.animalRepository = animalRepository;
}

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person();
        p1.setPersonId("0958177933");
        p1.setName("Bryan");
        p1.setLastName("Plaza");
        p1.setAge(28);

        Person p2 = new Person();
        p2.setPersonId("0958177934");
        p2.setName("Juan");
        p2.setLastName("Pueblo");
        p2.setAge(39);

        Person p3 = new Person();
        p3.setPersonId("0958177935");
        p3.setName("Enner");
        p3.setLastName("Valencia");
        p3.setAge(34);

        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);

        // Animal

        Animal a1 = new Animal();
        a1.setName("Maxi");
        a1.setColor("White");
        a1.setLenght(1.25);
        a1.setBreed("Husky");
        a1.setHeight(0.80);
        a1.setWeight(10);

        Animal a2 = new Animal();
        a2.setName("Ramon");
        a2.setColor("Brown");
        a2.setLenght(1.30);
        a2.setBreed("German Shepperd");
        a2.setHeight(0.90);
        a2.setWeight(15);

        animalRepository.save(a1);
        animalRepository.save(a2);

        System.out.println("--------------Started BootstrapData -------------");
        System.out.println("Number of Persons: " + personRepository.count());
        System.out.println("Number of Animals: " + animalRepository.count());

    }

}
