package savinov.utils.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savinov.dto.CityDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropsCity {

    @JsonProperty("props")
    CityDto cityDto;

}
