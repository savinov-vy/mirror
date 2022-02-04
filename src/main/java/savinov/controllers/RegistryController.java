package savinov.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import savinov.dto.RegistryDto;
import savinov.services.RegistryService;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(value = "/list")
@AllArgsConstructor
public class RegistryController {

    private RegistryService registryService;

    @GetMapping("/Реестр")
    public @ResponseBody
    List<RegistryDto> getRegistry(@RequestParam(required = false) String folder,
                                  @RequestParam(required = false) String filter) {
        if (nonNull(filter)) {
            return registryService.findRegistryByFilter(filter);
        } else {
            return registryService.getAllRegistries();
        }
    }

    @PostMapping(value = "/Реестр")
    public @ResponseBody
    RegistryDto postRegistry(@RequestBody String registryDto) {
        RegistryDto saved = registryService.mapToRegistryAndSave(registryDto);
        return saved;
    }

    @PostMapping(value = "/Реестр/{id}")
    public @ResponseBody
    RegistryDto putRegistry(@RequestBody String registryDto, @PathVariable Integer id) {
        RegistryDto saved = registryService.mapToRegistryAndUpdateById(registryDto, id);
        return saved;
    }

    @DeleteMapping(value = "/Реестр/{id}")
    public void deleteRegistry(@PathVariable Integer id) {
        registryService.deleteById(id);
    }
}
