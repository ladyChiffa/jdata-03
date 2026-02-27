package com.example.jdata_03;

import com.example.jdata_03.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Jdata03Application implements CommandLineRunner {
	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(Jdata03Application.class, args);
	}

	@Override
	//@Transactional // без аннотации EntityManager откажется сохранять данные в БД, читать будет
	public void run(String... args) throws Exception {
		// Создание записей
		/*
		List<Person> personList = new ArrayList<>();
		personList.add(Person.builder().name("Elena").age(30).phone_number("+79052002020").build());
		personList.add(Person.builder().name("Anatoly").age(35).phone_number("+79059999999").build());
		personList.add(Person.builder().name("Sergey").age(15).phone_number("+79052112121").build());

		// сохранять можно так
		personList.forEach( city -> entityManager.persist(city) ); // но хочется, чтобы это все происходило менее явно
		*/

		// Выборка и изменение
		/*
		var person = entityManager.find(Person.class, 52); // Если поле Id long - здесь нужно будет приведение типа
		person.setSurname("Tarantino");
		// entityManager.persist(person); // если блок Transactional - здесь не нужен entityManager.persist, он будет вызван автоматом
		System.out.println(person);
		*/

		// Выборка и попытка изменения с refresh
		/*
		var person = entityManager.find(Person.class, 52); // Если поле Id long - здесь нужно будет приведение типа
		System.out.println(person);
		person.setSurname("Mishuk");
		System.out.println(person);
		entityManager.refresh(person);
		System.out.println(person); // Т.к. транзакция заканчивается только в конце метода - здесь будет перепрочитан
									// объект из БД, который еще не изменен. Получим значение до setSurname.
		*/

		// Detach
		/*
		var person = entityManager.find(Person.class, 52); // Если поле Id long - здесь нужно будет приведение типа
		System.out.println(person);
		person.setSurname("Mishuk");
		System.out.println(person);
		entityManager.detach(person); // После этого оператора сохранения в БД в конце метода не произойдет
		System.out.println(person); // Значение будет измененное, но оно не попадет в БД
		*/
	}
}
