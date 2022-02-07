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
import savinov.dto.PositionDto;
import savinov.services.PositionService;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
@AllArgsConstructor
public class PositionController {

    private PositionService positionService;

    @GetMapping("/Должности")
    public List<PositionDto> getPosition() {
        return positionService.getAllPositions();
    }

    @PostMapping(value = "/Должности")
    public PositionDto postPosition(@RequestBody String positionDto) throws JsonProcessingException {
        PositionDto saved = positionService.mapToPositionAndSave(positionDto);
        return saved;
    }

    @PostMapping(value = "/Должности/{id}")
    public PositionDto putPosition(@RequestBody String positionDto, @PathVariable Integer id) throws JsonProcessingException {
        PositionDto saved = positionService.mapToPositionAndUpdateById(positionDto, id);
        return saved;
    }

    @DeleteMapping (value = "/Должности/{id}")
    public void deletePosition(@PathVariable Integer id) {
        positionService.deleteById(id);
    }
}
