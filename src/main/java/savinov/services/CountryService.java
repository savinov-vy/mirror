package savinov.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import savinov.dto.CountryDto;
import savinov.entities.Country;
import savinov.repositories.CountryRepository;
import savinov.utils.props.PropsCountry;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    CountryRepository countryRepository;

    @Transactional
    public CountryDto mapToCountryAndSave(String countryFields) throws JsonProcessingException {
        CountryDto countryDto = mapToJavaObj(countryFields);
        String name = countryDto.getName();
        Country saved = countryRepository.save(Country.of(name));
        return buildToCountryDto(saved);
    }

    @Transactional
    public CountryDto mapToCountryAndUpdateById(String countryFields, Integer id) throws JsonProcessingException {
        CountryDto countryDto = mapToJavaObj(countryFields);
        String newName = countryDto.getName();
        Country country = countryRepository.getOne(id);
        country.setName(newName);
        return buildToCountryDto(country);
    }

    @Transactional
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

    @Transactional
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(this::buildToCountryDto)
                .collect(Collectors.toList());
    }


    private CountryDto buildToCountryDto(Country country) {
        CountryDto build = CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
        return build;
    }

    private CountryDto mapToJavaObj(String countryFields) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PropsCountry propsCountry = mapper.readValue(countryFields, PropsCountry.class);
        return propsCountry.getCountryDto();
    }
}
