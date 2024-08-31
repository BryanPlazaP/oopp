package com.ups.oop.bootstrap;

import com.ups.oop.dto.Person;
import com.ups.oop.entity.Animal;
import com.ups.oop.entity.Author;
import com.ups.oop.entity.Book;
import com.ups.oop.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
private final PersonRepository personRepository;
private final AnimalRepository animalRepository;
private final StudentRepository studentRepository;
private final AuthorRepository authorRepository;
private final BookRepository bookRepository;

    public BootStrapData(PersonRepository personRepository, AnimalRepository animalRepository, StudentRepository studentRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.animalRepository = animalRepository;
        this.studentRepository = studentRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        //Books
        // 1
        Author auth1 = new Author();
        auth1.setName("Juan");
        auth1.setLastName("Rulfo");
        authorRepository.save(auth1);

        Book b1 = new Book();
        b1.setTitle("El llano en Llamas");
        b1.setEditorial("Anagrama");
        b1.setAuthor(auth1);
        bookRepository.save(b1);

        auth1.getBooks().add(b1);
        authorRepository.save(auth1);

        //2
        Author auth2 = new Author();
        auth2.setName(" Antoine ");
        auth2.setLastName("de Saint-Exupéry");
        authorRepository.save(auth2);

        Book b2 = new Book();
        b2.setTitle("El Principito");
        b2.setEditorial("Reynal & Hitchcock");
        b2.setAuthor(auth2);
        bookRepository.save(b2);

        auth2.getBooks().add(b2);
        authorRepository.save(auth2);

        //3
        Author auth3 = new Author();
        auth3.setName("William");
        auth3.setLastName("Shakespear");
        authorRepository.save(auth3);

        Book b3 = new Book();
        b3.setTitle("Hamlet");
        b3.setEditorial("Simón and Schuster");
        b3.setAuthor(auth3);
        bookRepository.save(b3);

        auth3.getBooks().add(b3);
        authorRepository.save(auth3);



        System.out.println("--------------Started BootstrapData -------------");
        System.out.println("Number of Persons: " + personRepository.count());
        System.out.println("Number of Animals: " + animalRepository.count());
        System.out.println("Number of Books: " + animalRepository.count());
        System.out.println("Number of Authors: " + animalRepository.count());
    }
}
