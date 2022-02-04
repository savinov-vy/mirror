package savinov.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import savinov.dto.CityDto;
import savinov.services.CityService;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @GetMapping("/Города")
    public @ResponseBody List<CityDto> getCity() {
        return cityService.getAllCountries();
    }

    @PostMapping(value = "/Города")
    public @ResponseBody CityDto postCity(@RequestBody String cityDto) throws JsonProcessingException {
        CityDto saved = cityService.mapToCityAndSave(cityDto);
        return saved;
    }

    @PostMapping(value = "/Города/{id}")
    public @ResponseBody CityDto putCity(@RequestBody String cityDto, @PathVariable Integer id) throws JsonProcessingException {
        CityDto saved = cityService.mapToCityAndUpdateById(cityDto, id);
        return saved;
    }

    @DeleteMapping (value = "/Города/{id}")
    public void deleteCity(@PathVariable Integer id) {
        cityService.deleteById(id);
    }
}
