package savinov.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import savinov.dto.PositionDto;
import savinov.entities.Position;
import savinov.repositories.PositionRepository;
import savinov.utils.props.PropsPosition;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PositionService {

    PositionRepository positionRepository;

    @Transactional
    public PositionDto mapToPositionAndSave(String positionFields) throws JsonProcessingException {
        PositionDto positionDto = mapToJavaObj(positionFields);
        String name = positionDto.getName();
        Position saved = positionRepository.save(Position.of(name));
        return buildToPositionDto(saved);
    }

    @Transactional
    public PositionDto mapToPositionAndUpdateById(String positionFields, Integer id) throws JsonProcessingException {
        PositionDto positionDto = mapToJavaObj(positionFields);
        String newName = positionDto.getName();
        Position position = positionRepository.getOne(id);
        position.setName(newName);
        return buildToPositionDto(position);
    }

    @Transactional
    public void deleteById(Integer id) {
        positionRepository.deleteById(id);
    }

    @Transactional
    public List<PositionDto> getAllPositions() {
        return positionRepository.findAll().stream()
                .map(this::buildToPositionDto)
                .collect(Collectors.toList());
    }


    private PositionDto buildToPositionDto(Position position) {
        PositionDto build = PositionDto.builder()
                .id(position.getId())
                .name(position.getName())
                .build();
        return build;
    }

    private PositionDto mapToJavaObj(String positionFields) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PropsPosition propsPosition = mapper.readValue(positionFields, PropsPosition.class);
        return propsPosition.getPositionDto();
    }
}
