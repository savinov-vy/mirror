package savinov.utils.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savinov.dto.HospitalDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropsHospital {

    @JsonProperty("props")
    HospitalDto hospitalDto;

}
