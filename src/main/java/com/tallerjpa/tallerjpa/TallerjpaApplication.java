package com.tallerjpa.tallerjpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.tallerjpa.tallerjpa.entities.Person;
import com.tallerjpa.tallerjpa.repositories.PersonRepository;


@SpringBootApplication
public class TallerjpaApplication implements  CommandLineRunner{

	@Autowired
    private PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TallerjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//create();
		// List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguage("Java");
		// persons.stream().forEach(person->System.out.println(person));
		List<Person> persons = (List<Person>) personRepository.buscarByProgrammingLanguage("Java","Johlver");
		persons.stream().forEach(person -> System.out.println(person));
	}

	@Transactional
	public void create(){
            String name;
            String lastname;
            String programmingLenguaje;
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Ingrese el nombre: ");
                name = sc.next();
                System.out.println("Ingrese el apellido: ");
                lastname = sc.next();
                System.out.println("Ingrese el lenguaje de programacion");
                programmingLenguaje = sc.next();
            }

		Person person = new Person(null, name, lastname, programmingLenguaje);

		Person personNew = personRepository.save(person);
		System.out.println(personNew);
		personRepository.findById(personNew.getId()).ifPresent(System.out::println);
	}
}
