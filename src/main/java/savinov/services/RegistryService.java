package savinov.services;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import savinov.dto.RegistryDto;
import savinov.entities.Registry;
import savinov.repositories.RegistryRepository;
import savinov.utils.props.PropsRegistry;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegistryService {

    RegistryRepository registryRepository;

    @Transactional
    public RegistryDto mapToRegistryAndSave(String registryFields) {
        RegistryDto registryDto = PropsRegistry.getRegistryDto(registryFields);
        Registry saved = registryRepository.save(Registry.of(registryDto));
        return RegistryDto.of(saved);
    }

    @Transactional
    public RegistryDto mapToRegistryAndUpdateById(String registryFields, Integer id) {
        RegistryDto registryDto = PropsRegistry.getRegistryDto(registryFields);
        Registry registry = registryRepository.findById(id).get();
        registry.setId(registryDto.getId());
        registry.setOrganization(registryDto.getOrganization());
        registry.setFcs(registryDto.getFcs());
        registry.setShortFcs(registryDto.getShortFcs());
        registry.setPosition(registryDto.getPosition());
        registry.setCitizenship(registryDto.getCitizenship());
        registry.setBirthYear(registryDto.getBirthYear());
        registry.setCity(registryDto.getCity());
        registry.setTreatmentPlace(registryDto.getTreatmentPlace());
        registry.setHospital(registryDto.getHospital());
        registry.setPatientStatus(registryDto.getPatientStatus());
        registry.setContactedNumber(registryDto.getContactedNumber());
        registry.setCountry(registryDto.getCountry());
        registry.setStatus(registryDto.getStatus());
        registry.setRegisterDate(registryDto.getRegisterDate());
        registry.setUnregisterDate(registryDto.getUnregisterDate());
        registry.setFirstTestDate(registryDto.getFirstTestDate());
        registry.setDeathDate(registryDto.getDeathDate());
        registry.setComment(registryDto.getComment());
        registry.setDiseaseNumber(registryDto.getDiseaseNumber());
        registry.setIsFullyVaccinated(registryDto.getIsFullyVaccinated());
        registry.setFullyVaccinatedDate(registryDto.getFullyVaccinatedDate());
        registry.setIsFirstComponentVaccinated(registryDto.getIsFirstComponentVaccinated());
        registry.setFirstVaccineDate(registryDto.getFirstVaccineDate());
        return RegistryDto.of(registry);
    }

    @Transactional
    public void deleteById(Integer id) {
        registryRepository.deleteById(id);
    }

    @Transactional
    public List<RegistryDto> getAllRegistries() {
        return registryRepository.findAll().stream()
                .map(this::buildToRegistryDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<RegistryDto> findRegistryByFilter(String filter) {
        String shortFcs = null;
        String birthYear = null;
        String diseaseNumber = null;

        Matcher fcsMatcher = Pattern.compile("ФИОРаботника, '[а-яА-Я]*\\s[а-яА-Я]+.[а-яА-Я]+.").matcher(filter);
        while (fcsMatcher.find()) {
            shortFcs = fcsMatcher.group().substring(fcsMatcher.group().indexOf("'") + 1);
        }
        Matcher birthYearMatcher = Pattern.compile("ГодРождения eq '\\d+").matcher(filter);
        while (birthYearMatcher.find()) {
            birthYear = birthYearMatcher.group().substring(birthYearMatcher.group().indexOf("'") + 1);
        }
        Matcher diseaseMatcher = Pattern.compile("ПовторноеЗаболеваниеValue eq '\\d+").matcher(filter);
        while (diseaseMatcher.find()) {
            diseaseNumber = diseaseMatcher.group().substring(diseaseMatcher.group().indexOf("'") + 1);
        }
        return registryRepository.findRegistryByFilter(shortFcs, birthYear, diseaseNumber).stream()
                .map(this::buildToRegistryDto)
                .collect(Collectors.toList());
    }


    private RegistryDto buildToRegistryDto(Registry registry) {
        return RegistryDto.of(registry);
    }
}
