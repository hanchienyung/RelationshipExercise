package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    PersonRepository  personRepository;

    @Autowired
    CountryRepository countryRepository;

    @RequestMapping("/")
    public String listpersoncountry(Model model){
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("countries", countryRepository.findAll());
        return "listpersoncountry";
    }


    @RequestMapping("/addperson")
    public String addPerson(Model model){
        model.addAttribute("Person", new Person());
        return "personform";
    }

    @PostMapping("/processperson")
    public String processForm(@Valid Person person, BindingResult result)
    {
        if (result.hasErrors()){
            return "personform";
        }
        personRepository.save(person);
        return "redirect:/";
    }


    @RequestMapping("/addcountry")
    public String addCountry(Model model){
        model.addAttribute("Country", new Country());
        return "countryform";
    }

    @PostMapping("/processcountry")
    public String processForm(@Valid Country country, BindingResult result)
    {
        if (result.hasErrors()){
            return "countryform";
        }
        personRepository.save(country);
        return "redirect:/";
    }

}
