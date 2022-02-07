package savinov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savinov.dto.RegistryDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "registry")
public class Registry {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "organization")
    private Integer organization;

    @Column(name = "fcs")
    private String fcs;

    @Column(name = "short_fcs")
    private String shortFcs;

    @Column(name = "position")
    private Integer position;

    @Column(name = "citizenship")
    private Integer citizenship;

    @Column(name = "birth_year")
    private String birthYear;

    @Column(name = "path")
    private String path;

    @Column(name = "city")
    private Integer city;

    @Column(name = "treatmentplace")
    private String treatmentPlace;

    @Column(name = "hospital")
    private Integer hospital;

    @Column(name = "patient_status")
    private String patientStatus;

    @Column(name = "contacted_number")
    private Integer contactedNumber;

    @Column(name = "country")
    private Integer country;

    @Column(name = "status")
    private String status;

    @Column(name = "register_at")
    private LocalDateTime registerDate;

    @Column(name = "unregister_at")
    private LocalDateTime unregisterDate;

    @Column(name = "first_test_at")
    private LocalDateTime firstTestDate;

    @Column(name = "death_at")
    private LocalDateTime deathDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "disease_number")
    private String diseaseNumber;

    @Column(name = "is_fully_vaccinated")
    private String isFullyVaccinated;

    @Column(name = "fully_vaccinated_at")
    private LocalDateTime fullyVaccinatedDate;

    @Column(name = "is_first_component_vaccinated")
    private String isFirstComponentVaccinated;

    @Column(name = "first_vaccine_at")
    private LocalDateTime firstVaccineDate;


    public static Registry of(RegistryDto registryDto) {
        return Registry.builder()
                .id(registryDto.getId())
                .organization(registryDto.getOrganization())
                .fcs(registryDto.getFcs())
                .shortFcs(registryDto.getShortFcs())
                .position(registryDto.getPosition())
                .citizenship(registryDto.getCitizenship())
                .birthYear(registryDto.getBirthYear())
                .city(registryDto.getCity())
                .treatmentPlace(registryDto.getTreatmentPlace())
                .hospital(registryDto.getHospital())
                .patientStatus(registryDto.getPatientStatus())
                .contactedNumber(registryDto.getContactedNumber())
                .country(registryDto.getCountry())
                .status(registryDto.getStatus())
                .registerDate(registryDto.getRegisterDate())
                .unregisterDate(registryDto.getUnregisterDate())
                .firstTestDate(registryDto.getFirstTestDate())
                .deathDate(registryDto.getDeathDate())
                .comment(registryDto.getComment())
                .diseaseNumber(registryDto.getDiseaseNumber())
                .isFullyVaccinated(registryDto.getIsFullyVaccinated())
                .fullyVaccinatedDate(registryDto.getFullyVaccinatedDate())
                .isFirstComponentVaccinated(registryDto.getIsFirstComponentVaccinated())
                .firstVaccineDate(registryDto.getFirstVaccineDate())
                .build();
    }
}
