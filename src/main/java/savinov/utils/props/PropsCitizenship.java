package savinov.utils.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savinov.dto.CitizenshipDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropsCitizenship {

    @JsonProperty("props")
    CitizenshipDto citizenshipDto;

}
