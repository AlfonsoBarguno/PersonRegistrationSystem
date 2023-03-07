package com.Bargunyo.PersonDB.Service;

import com.Bargunyo.PersonDB.Data.FileStorageRepository;
import com.Bargunyo.PersonDB.Data.PersonRepository;
import com.Bargunyo.PersonDB.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final FileStorageRepository fileStorageRepository;

    public PersonService(PersonRepository personRepository, FileStorageRepository fileStorageRepository) {
        this.personRepository = personRepository;
        this.fileStorageRepository = fileStorageRepository;
    }


    //The transaction will not be committed until the whole method is applied.
    //This means that if there is an exception on the fileStorage the transaction will not execute.
    //If anything goes wrong in the method, @Transactional undoes whatever is done, particularly
    //to the dataBase.
    @Transactional
    public Person save(Person person, InputStream photoStream) throws IOException {

        Person savedPerson = personRepository.save(person);

        fileStorageRepository.save(person.getPhotoFileName(),photoStream);

        return savedPerson;
    }

    public <S extends Person> Iterable<S> saveAll(Iterable<S> entities) {
        return personRepository.saveAll(entities);
    }

    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void deleteById(Long aLong) {
        personRepository.deleteById(aLong);
    }


    public void deleteAllById(Iterable<Long> ids) {

        /*
        * Before, we used the code commented above for deleting by id. But after the custom sql query method
        * that we have written in the personRepository interface, we can skip all this code
        * and apply the method findFilesNamesByIds().
        * */

        /*Iterable<Person> personsToDelete = personRepository.findAllById(ids);

        Stream<Person> peopleStream = StreamSupport.stream(personsToDelete.spliterator(), false);

        Set<String> fileNames = peopleStream
                .map(Person::getPhotoFileName).collect(Collectors.toSet());*/

        Set<String> fileNames = personRepository.findFileNamesByIds(ids);

        personRepository.deleteAllById(ids);
        fileStorageRepository.deleteAllByName(fileNames);
    }

    //Page extends from Iterable, so it works like an Iterable
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
