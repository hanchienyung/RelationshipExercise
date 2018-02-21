package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository <Country,Long> {
    Country findByCountryname(String countryname);
}

