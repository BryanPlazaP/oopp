package com.ups.oop.bootstrap;

import com.ups.oop.dto.Person;
import com.ups.oop.entity.Animal;
import com.ups.oop.repository.AnimalRepository;
import com.ups.oop.repository.PersonRepository;
import com.ups.oop.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
private final PersonRepository personRepository;
private final AnimalRepository animalRepository;
private final StudentRepository studentRepository;


    public BootStrapData(PersonRepository personRepository, AnimalRepository animalRepository, StudentRepository studentRepository) {
        this.personRepository = personRepository;
        this.animalRepository = animalRepository;
        this.studentRepository = studentRepository;
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
        a1.setPetName("Maxi");
        a1.setName("Siberian");
        a1.setBreed("Husky");
        a1.setColor("White");
        a1.setLength(1.25);
        a1.setHeight(0.80);
        a1.setWeight(10);

        Animal a2 = new Animal();
        a2.setPetName("Ramón");
        a2.setName("German");
        a2.setBreed("Shepperd");
        a2.setColor("Brown");
        a2.setLength(1.30);
        a2.setHeight(0.90);
        a2.setWeight(15);

        Animal a3 = new Animal();
        a3.setPetName("Chilly Willy");
        a3.setName("Emperor");
        a3.setBreed("Penguin");
        a3.setColor("White");
        a3.setLength(0.50);
        a3.setHeight(0.70);
        a3.setWeight(10);

        animalRepository.save(a1);
        animalRepository.save(a2);
        animalRepository.save(a3);

        System.out.println("--------------Started BootstrapData -------------");
        System.out.println("Number of Persons: " + personRepository.count());
        System.out.println("Number of Animals: " + animalRepository.count());

    }

    

}
