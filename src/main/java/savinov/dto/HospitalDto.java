package savinov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {

    @JsonProperty("ФМБАValue")
    private String fmba;

    @JsonProperty("Идентификатор")
    protected Integer id;

    @JsonProperty("Название")
    protected String name;

}
