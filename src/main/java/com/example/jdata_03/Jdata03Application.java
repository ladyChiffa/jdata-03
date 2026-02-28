package com.example.jdata_03;

import com.example.jdata_03.entity.Person;
import com.example.jdata_03.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Jdata03Application {
	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(Jdata03Application.class, args);
	}

	@Bean  // Бин CommandLineRunner запускается после запуска приложения
	public CommandLineRunner demo (PersonRepository personRepository) {
		return (String[] args) -> {
			List<Person> personList = new ArrayList<>();
			personList.add(Person.builder().name("Elena").age(30).phoneNumber("+79052002020").cityOfLiving("Whiterun").build());
			personList.add(Person.builder().name("Anatoly").age(35).phoneNumber("+79059999999").cityOfLiving("Windhelm").build());
			personList.add(Person.builder().name("Sergey").age(15).phoneNumber("+79052112121").cityOfLiving("Solitude").build());
			personList.add(Person.builder().name("Dane").age(45).phoneNumber("+79052112121").cityOfLiving("Dawnstar").build());
			personList.add(Person.builder().name("Kassandra").age(33).phoneNumber("+79052112121").cityOfLiving("Solitude").build());
			personList.add(Person.builder().name("Senay").age(24).phoneNumber("+79052112121").cityOfLiving("Whiterun").build());
			personList.add(Person.builder().name("Michael").age(55).phoneNumber("+79052112121").cityOfLiving("Windhelm").build());
			personList.add(Person.builder().name("Lucy").age(26).phoneNumber("+79052112121").cityOfLiving("Dawnstar").build());
			personList.add(Person.builder().name("Elisabeth").age(39).phoneNumber("+79052112121").cityOfLiving("Solitude").build());
			personList.forEach(personRepository::save);

//			System.out.println("-------------- Демонстрация репозитория ----------------------");
//
//			List<Person> personList = new ArrayList<>();
//			personList.add(Person.builder().name("Elena").age(30).phoneNumber("+79052002020").build());
//			personList.add(Person.builder().name("Anatoly").age(35).phoneNumber("+79059999999").build());
//			personList.add(Person.builder().name("Sergey").age(15).phoneNumber("+79052112121").build());
//			personList.forEach(personRepository::save);
//
//			Optional<Person> p = personRepository.findById(personList.get(0).getId());
//			p.ifPresent( person -> System.out.println("Нашли! " + person) );
//
//			Iterable<Person> allPersons = personRepository.findAll();
//			System.out.println("Все люди:");
//			allPersons.forEach(System.out::println);
//
//			boolean exists = personRepository.existsById(personList.get(0).getId());
//			System.out.println("Человек с ID=" + personList.get(0).getId() + " существует? " + exists );
//
//			personList.get(0).setAge(40);
//			personRepository.save(personList.get(0));
//			System.out.println("После обновления возраста: " + personRepository.findById(personList.get(0).getId()).get());
//
//			personRepository.deleteById(personList.get(0).getId());
//			System.out.println("После удаления количество: " + personRepository.count());
//
//			System.out.println("-------------- THE END ----------------------");
			};

	};

}
