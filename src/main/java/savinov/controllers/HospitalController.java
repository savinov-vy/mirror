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
import savinov.dto.HospitalDto;
import savinov.services.HospitalService;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
@AllArgsConstructor
public class HospitalController {

    private HospitalService hospitalService;

    @GetMapping("/Стационары")
    public List<HospitalDto> getHospital() {
        return hospitalService.getAllHospitals();
    }

    @PostMapping(value = "/Стационары")
    public HospitalDto postHospital(@RequestBody String hospitalDto) throws JsonProcessingException {
        HospitalDto saved = hospitalService.mapToHospitalAndSave(hospitalDto);
        return saved;
    }

    @PostMapping(value = "/Стационары/{id}")
    public HospitalDto putHospital(@RequestBody String hospitalDto, @PathVariable Integer id) throws JsonProcessingException {
        HospitalDto saved = hospitalService.mapToHospitalAndUpdateById(hospitalDto, id);
        return saved;
    }

    @DeleteMapping (value = "/Стационары/{id}")
    public void deleteHospital(@PathVariable Integer id) {
        hospitalService.deleteById(id);
    }
}
