package savinov.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savinov.dto.CountryDto;
import savinov.services.CountryService;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/Страны")
    public List<CountryDto> getCountry() {
        return countryService.getAllCountries();
    }

    @PostMapping(value = "/Страны")
    public CountryDto postCountry(@RequestBody String countryDto) throws JsonProcessingException {
        CountryDto saved = countryService.mapToCountryAndSave(countryDto);
        return saved;
    }

    @PostMapping(value = "/Страны/{id}")
    public CountryDto putCountry(@RequestBody String countryDto, @PathVariable Integer id) throws JsonProcessingException {
        CountryDto saved = countryService.mapToCountryAndUpdateById(countryDto, id);
        return saved;
    }

    @DeleteMapping (value = "/Страны/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryService.deleteById(id);
    }
}
