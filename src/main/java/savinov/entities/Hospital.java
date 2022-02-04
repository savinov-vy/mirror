package savinov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "hospital")
public class Hospital {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "fmba")
    private String fmba;


    public static Hospital of(String name, String fmba){
        Hospital hospital = new Hospital();
        hospital.setName(name);
        hospital.setFmba(fmba);
        return hospital;
    }

}
