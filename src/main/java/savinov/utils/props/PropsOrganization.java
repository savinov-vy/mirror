package savinov.utils.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savinov.dto.OrganizationDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropsOrganization {

    @JsonProperty("props")
    OrganizationDto organizationDto;

}
