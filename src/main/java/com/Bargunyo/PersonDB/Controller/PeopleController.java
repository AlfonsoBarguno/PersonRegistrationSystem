package com.Bargunyo.PersonDB.Controller;

import com.Bargunyo.PersonDB.Data.PersonRepository;
import com.Bargunyo.PersonDB.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople() {

        return personRepository.findAll();
    }

    @ModelAttribute
    public Person getPerson() {


        return new Person();
    }

    @GetMapping
    //@ResponseStatus(HttpStatus.FOUND)
    public String showPeoplePage(Model model) {

        return "people";

        //"people" se refiere al template people
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public String savePerson(@Valid Person person, Errors errors) {
        System.out.println(person);
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }

    @PostMapping(params="delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections){

        System.out.println(selections);

        if(selections.isPresent()) {
            personRepository.deleteAllById(selections.get());
        }

        return "redirect:people";
    }
}
