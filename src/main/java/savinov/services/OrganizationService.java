package savinov.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import savinov.dto.OrganizationDto;
import savinov.entities.Organization;
import savinov.repositories.OrganizationRepository;
import savinov.utils.props.PropsOrganization;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizationService {

    OrganizationRepository organizationRepository;

    @Transactional
    public OrganizationDto mapToOrganizationAndSave(String organizationFields) throws JsonProcessingException {
        OrganizationDto organizationDto = mapToJavaObj(organizationFields);
        String name = organizationDto.getName();
        Organization saved = organizationRepository.save(Organization.of(name));
        return buildToOrganizationDto(saved);
    }

    @Transactional
    public OrganizationDto mapToOrganizationAndUpdateById(String organizationFields, Integer id) throws JsonProcessingException {
        OrganizationDto organizationDto = mapToJavaObj(organizationFields);
        String newName = organizationDto.getName();
        Organization organization = organizationRepository.getOne(id);
        organization.setName(newName);
        return buildToOrganizationDto(organization);
    }

    @Transactional
    public void deleteById(Integer id) {
        organizationRepository.deleteById(id);
    }

    @Transactional
    public List<OrganizationDto> getAllOrganizations() {
        return organizationRepository.findAll().stream()
                .map(this::buildToOrganizationDto)
                .collect(Collectors.toList());
    }


    private OrganizationDto buildToOrganizationDto(Organization organization) {
        OrganizationDto build = OrganizationDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                .build();
        return build;
    }

    private OrganizationDto mapToJavaObj(String organizationFields) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PropsOrganization propsOrganization = mapper.readValue(organizationFields, PropsOrganization.class);
        return propsOrganization.getOrganizationDto();
    }
}
