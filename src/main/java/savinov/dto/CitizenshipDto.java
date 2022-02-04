package savinov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CitizenshipDto {

    @JsonProperty("Идентификатор")
    protected Integer id;

    @JsonProperty("Название")
    protected String name;

}
