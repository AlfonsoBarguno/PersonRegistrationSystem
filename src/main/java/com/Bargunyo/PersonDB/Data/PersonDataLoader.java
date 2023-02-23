package com.Bargunyo.PersonDB.Data;

import com.Bargunyo.PersonDB.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
//Comentamos el @Component porque cargaremos los datos manualmente
//@Component
public class PersonDataLoader implements ApplicationRunner {

    /*
    * Al empezar a ejecutarse el programa, Spring buscará todas las
    * clases que implemente ApplicationRunner y las ejecutará. Esto nos
    * permite hacer un setUp de la aplicación.
    * */

    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository){

        this.personRepository = personRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(personRepository.count()==0){
        List<Person> people = List.of(new Person(123L, "Jeremy", "Froome", "johnny@gmail.com", LocalDate.of(1950,1,1),new BigDecimal(2300)),
                new Person(124L, "Summer", "Froome", "johnny@gmail.com",LocalDate.of(1952,1,1),new BigDecimal(2700)),
                new Person(125L, "Sonia", "Rubinstein", "johnny@gmail.com",LocalDate.of(1960,1,1),new BigDecimal(3300)),
                new Person(126L, "Susana", "Faklin", "johnny@gmail.com",LocalDate.of(1956,1,1),new BigDecimal(2300)),
                new Person(127L, "Ruperta", "Sunier", "johnny@gmail.com",LocalDate.of(1965,1,1),new BigDecimal(1300)));

        personRepository.saveAll(people);}
    }
}
