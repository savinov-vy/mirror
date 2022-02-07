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
import savinov.dto.CitizenshipDto;
import savinov.services.CitizenshipService;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
@AllArgsConstructor
public class CitizenshipController {

    private CitizenshipService citizenshipService;

    @GetMapping("/Гражданства")
    public List<CitizenshipDto> getCitizenship() {
        return citizenshipService.getAllCitizenships();
    }

    @PostMapping(value = "/Гражданства")
    public CitizenshipDto postCitizenship(@RequestBody String citizenshipDto) throws JsonProcessingException {
        CitizenshipDto saved = citizenshipService.mapToCitizenshipAndSave(citizenshipDto);
        return saved;
    }

    @PostMapping(value = "/Гражданства/{id}")
    public CitizenshipDto putCitizenship(@RequestBody String citizenshipDto, @PathVariable Integer id) throws JsonProcessingException {
        CitizenshipDto saved = citizenshipService.mapToCitizenshipAndUpdateById(citizenshipDto, id);
        return saved;
    }

    @DeleteMapping (value = "/Гражданства/{id}")
    public void deleteCitizenship(@PathVariable Integer id) {
        citizenshipService.deleteById(id);
    }
}
