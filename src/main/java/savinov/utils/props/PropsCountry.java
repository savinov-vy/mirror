package savinov.utils.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savinov.dto.CountryDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropsCountry {

    @JsonProperty("props")
    CountryDto countryDto;

}
