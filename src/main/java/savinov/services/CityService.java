package savinov.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import savinov.dto.CityDto;
import savinov.entities.City;
import savinov.repositories.CityRepository;
import savinov.utils.props.PropsCity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {

    CityRepository cityRepository;

    @Transactional
    public CityDto mapToCityAndSave(String cityFields) throws JsonProcessingException {
        CityDto cityDto = mapToJavaObj(cityFields);
        City saved = cityRepository.save(City.of(cityDto.getName(), cityDto.getNpp()));
        return buildToCityDto(saved);
    }

    @Transactional
    public CityDto mapToCityAndUpdateById(String cityFields, Integer id) throws JsonProcessingException {
        CityDto cityDto = mapToJavaObj(cityFields);
        String newName = cityDto.getName();
        City city = cityRepository.getOne(id);
        city.setName(newName);
        return buildToCityDto(city);
    }

    @Transactional
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    @Transactional
    public List<CityDto> getAllCountries() {
        return cityRepository.findAll().stream()
                .map(this::buildToCityDto)
                .collect(Collectors.toList());
    }


    private CityDto buildToCityDto(City city) {
        CityDto build = CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .npp(city.getNpp())
                .build();
        return build;
    }

    private CityDto mapToJavaObj(String cityFields) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PropsCity propsCity = mapper.readValue(cityFields, PropsCity.class);
        return propsCity.getCityDto();
    }
}
