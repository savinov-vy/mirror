package savinov.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import savinov.dto.HospitalDto;
import savinov.entities.Hospital;
import savinov.repositories.HospitalRepository;
import savinov.utils.props.PropsHospital;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalService {

    HospitalRepository hospitalRepository;

    @Transactional
    public HospitalDto mapToHospitalAndSave(String hospitalFields) throws JsonProcessingException {
        HospitalDto hospitalDto = mapToJavaObj(hospitalFields);
        String name = hospitalDto.getName();
        String fmba = hospitalDto.getFmba();
        Hospital saved = hospitalRepository.save(Hospital.of(name, fmba));
        return buildToHospitalDto(saved);
    }

    @Transactional
    public HospitalDto mapToHospitalAndUpdateById(String hospitalFields, Integer id) throws JsonProcessingException {
        HospitalDto hospitalDto = mapToJavaObj(hospitalFields);
        String newName = hospitalDto.getName();
        Hospital hospital = hospitalRepository.getOne(id);
        hospital.setName(newName);
        return buildToHospitalDto(hospital);
    }

    @Transactional
    public void deleteById(Integer id) {
        hospitalRepository.deleteById(id);
    }

    @Transactional
    public List<HospitalDto> getAllHospitals() {
        return hospitalRepository.findAll().stream()
                .map(this::buildToHospitalDto)
                .collect(Collectors.toList());
    }


    private HospitalDto buildToHospitalDto(Hospital hospital) {
        HospitalDto build = HospitalDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .fmba(hospital.getFmba())
                .build();
        return build;
    }

    private HospitalDto mapToJavaObj(String hospitalFields) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PropsHospital propsHospital = mapper.readValue(hospitalFields, PropsHospital.class);
        return propsHospital.getHospitalDto();
    }
}
