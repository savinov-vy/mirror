package savinov.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import savinov.entities.Registry;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class RegistryDto {

    @JsonProperty("Идентификатор")
    protected Integer id;

    @JsonProperty("НаименованиеОрганизацииId")
    private Integer organization;

    @JsonIgnore
    private String fcs;

    @JsonProperty("ФИОРаботника")
    private String shortFcs;

    @JsonProperty("ДолжностьId")
    private Integer position;

    @JsonProperty("ГражданствоId")
    private Integer citizenship;

    @JsonProperty("ГодРождения")
    private String birthYear;

    @JsonProperty("Путь")
    private String path;

    @JsonProperty("ГородId")
    private Integer city;

    @JsonProperty("МестоПрохожденияЛеченияValue")
    private String treatmentPlace;

    @JsonProperty("НаименованиеСтационараId")
    private Integer hospital;

    @JsonProperty("СтепеньТяжестиЗаболеванияValue")
    private String patientStatus;

    @JsonProperty("КоличествоКонтактировавших")
    private Integer contactedNumber;

    @JsonProperty("СтранаId")
    private Integer country;

    @JsonProperty("СтатусУчётаValue")
    private String status;

    @DateTimeFormat
    @JsonProperty("ДатаПостановкиНаУчёт")
    private LocalDateTime registerDate;

    @DateTimeFormat
    @JsonProperty("ДатаСнятияСУчёта")
    private LocalDateTime unregisterDate;

    @JsonProperty("ДатаПолученияПоложительногоТеста")
    @DateTimeFormat
    private LocalDateTime firstTestDate;

    @DateTimeFormat
    @JsonProperty("ДатаСмерти")
    private LocalDateTime deathDate;

    @JsonProperty("Комментарий")
    private String comment;

    @JsonProperty("ПовторноеЗаболеваниеValue")
    private String diseaseNumber;

    @JsonProperty("ВакцинированПолностьюValue")
    private String isFullyVaccinated;

    @JsonProperty("ДатаВакцинированияПолностью")
    private LocalDateTime fullyVaccinatedDate;

    @JsonProperty("ВакцинированПервымКомпонентомValue")
    private String isFirstComponentVaccinated;

    @DateTimeFormat
    @JsonProperty("ДатаВакцинированияПервымКомпонентом")
    private LocalDateTime firstVaccineDate;

    public static RegistryDto of(Registry registry) {
        return RegistryDto.builder()
                .id(registry.getId())
                .organization(registry.getOrganization())
                .fcs(registry.getFcs())
                .shortFcs(registry.getShortFcs())
                .position(registry.getPosition())
                .citizenship(registry.getCitizenship())
                .birthYear(registry.getBirthYear())
                .path(registry.getPath())
                .city(registry.getCity())
                .treatmentPlace(registry.getTreatmentPlace())
                .hospital(registry.getHospital())
                .patientStatus(registry.getPatientStatus())
                .contactedNumber(registry.getContactedNumber())
                .country(registry.getCountry())
                .status(registry.getStatus())
                .registerDate(registry.getRegisterDate())
                .unregisterDate(registry.getUnregisterDate())
                .firstTestDate(registry.getFirstTestDate())
                .deathDate(registry.getDeathDate())
                .comment(registry.getComment())
                .diseaseNumber(registry.getDiseaseNumber())
                .isFullyVaccinated(registry.getIsFullyVaccinated())
                .fullyVaccinatedDate(registry.getFullyVaccinatedDate())
                .isFirstComponentVaccinated(registry.getIsFirstComponentVaccinated())
                .firstVaccineDate(registry.getFirstVaccineDate())
                .build();
    }
}
