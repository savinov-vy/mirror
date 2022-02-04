package savinov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    @JsonProperty("Идентификатор")
    protected Integer id;

    @JsonProperty("Название")
    protected String name;

    @JsonProperty("СтатусАтомногоГородаValue")
    private String npp;

}
