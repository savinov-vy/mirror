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
import savinov.dto.OrganizationDto;
import savinov.services.OrganizationService;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @GetMapping("/Организации")
    public @ResponseBody List<OrganizationDto> getOrganization() {
        return organizationService.getAllOrganizations();
    }

    @PostMapping(value = "/Организации")
    public @ResponseBody OrganizationDto postOrganization(@RequestBody String organizationDto) throws JsonProcessingException {
        OrganizationDto saved = organizationService.mapToOrganizationAndSave(organizationDto);
        return saved;
    }

    @PostMapping(value = "/Организации/{id}")
    public @ResponseBody OrganizationDto putOrganization(@RequestBody String organizationDto, @PathVariable Integer id) throws JsonProcessingException {
        OrganizationDto saved = organizationService.mapToOrganizationAndUpdateById(organizationDto, id);
        return saved;
    }

    @DeleteMapping (value = "/Организации/{id}")
    public void deleteOrganization(@PathVariable Integer id) {
        organizationService.deleteById(id);
    }
}
