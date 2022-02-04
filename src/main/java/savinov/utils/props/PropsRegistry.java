package savinov.utils.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savinov.dto.RegistryDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropsRegistry {

    @JsonProperty("props")
    RegistryDto registryDto;

    public static RegistryDto getRegistryDto(String registryFields) {
        ObjectMapper mapper = new ObjectMapper();
        PropsRegistry propsRegistry = null;
        try {
            propsRegistry = mapper.readValue(registryFields, PropsRegistry.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return propsRegistry.getRegistryDto();
    }
}
