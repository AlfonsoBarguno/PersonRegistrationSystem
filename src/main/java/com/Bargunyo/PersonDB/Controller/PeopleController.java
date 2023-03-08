package com.Bargunyo.PersonDB.Controller;

import com.Bargunyo.PersonDB.Data.FileStorageRepository;
import com.Bargunyo.PersonDB.Data.PersonRepository;
import com.Bargunyo.PersonDB.Service.PersonService;
import com.Bargunyo.PersonDB.model.Person;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;


@Controller
@RequestMapping("/people")
@Log4j2 //for easy logging messages
public class PeopleController {

    public static final String DISPOSITION = """
            attachment; filename="%s"
            """;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FileStorageRepository fileStorageRepository;

    @Autowired
    private PersonService personService;

    public PeopleController(PersonRepository personRepository, FileStorageRepository fileStorageRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.fileStorageRepository = fileStorageRepository;
        this.personService = personService;
    }

    @ModelAttribute("people")
    public Page<Person> getPeople(@PageableDefault(size = 3) Pageable page) {

        return personService.findAll(page);
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

    @GetMapping("/images/{resource}")
    public ResponseEntity<Resource> getResource(@PathVariable String resource) throws MalformedURLException {

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, format(DISPOSITION, resource))
                .body(fileStorageRepository.findByName(resource));

    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public String savePerson(Model model, @Valid Person person, Errors errors, @RequestParam("photoFileName") MultipartFile photoFile) throws IOException {
        log.info(person);
        log.info("File name: " + photoFile.getOriginalFilename());
        log.info("File size: " + photoFile.getSize());
        log.info("Errors: " + errors);

        if (!errors.hasErrors()) {

            personService.save(person, photoFile.getInputStream());
            return "redirect:people";

        }

        return "people";
    }

    @PostMapping(params = "action=delete")
    public String deletePeople(@RequestParam Optional<List<Long>> selections) {

        log.info(selections);

        if (selections.isPresent()) {
            personService.deleteAllById(selections.get());
        }

        return "redirect:people";
    }

    @PostMapping(params = "action=edit")
    public String editPeople(@RequestParam Optional<List<Long>> selections, Model model) {

        log.info(selections);

        if (selections.isPresent()) {

            Optional<Person> person = personRepository.findById(selections.get().get(0));

            model.addAttribute("person", person);
        }

        return "people";
    }

    @PostMapping(params = "action=import")
    public String importCSV(@RequestParam("csvFile") MultipartFile csvFile) {

        log.info("File name: " + csvFile.getOriginalFilename());
        log.info("File size: " + csvFile.getSize());

        try {
            personService.importCSV(csvFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:people";
    }

}
