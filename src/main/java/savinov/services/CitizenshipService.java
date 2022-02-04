package savinov.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import savinov.dto.CitizenshipDto;
import savinov.entities.Citizenship;
import savinov.repositories.CitizenshipRepository;
import savinov.utils.props.PropsCitizenship;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CitizenshipService {

    CitizenshipRepository citizenshipRepository;

    @Transactional
    public CitizenshipDto mapToCitizenshipAndSave(String citizenshipFields) throws JsonProcessingException {
        CitizenshipDto citizenshipDto = mapToJavaObj(citizenshipFields);
        String name = citizenshipDto.getName();
        Citizenship saved = citizenshipRepository.save(Citizenship.of(name));
        return buildToCitizenshipDto(saved);
    }

    @Transactional
    public CitizenshipDto mapToCitizenshipAndUpdateById(String citizenshipFields, Integer id) throws JsonProcessingException {
        CitizenshipDto citizenshipDto = mapToJavaObj(citizenshipFields);
        String newName = citizenshipDto.getName();
        Citizenship citizenship = citizenshipRepository.getOne(id);
        citizenship.setName(newName);
        return buildToCitizenshipDto(citizenship);
    }

    @Transactional
    public void deleteById(Integer id) {
        citizenshipRepository.deleteById(id);
    }

    @Transactional
    public List<CitizenshipDto> getAllCitizenships() {
        return citizenshipRepository.findAll().stream()
                .map(this::buildToCitizenshipDto)
                .collect(Collectors.toList());
    }


    private CitizenshipDto buildToCitizenshipDto(Citizenship citizenship) {
        CitizenshipDto build = CitizenshipDto.builder()
                .id(citizenship.getId())
                .name(citizenship.getName())
                .build();
        return build;
    }

    private CitizenshipDto mapToJavaObj(String citizenshipFields) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PropsCitizenship propsCitizenship = mapper.readValue(citizenshipFields, PropsCitizenship.class);
        return propsCitizenship.getCitizenshipDto();
    }
}
