package savinov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import savinov.entities.Registry;

import java.util.List;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {

    void deleteById(Integer id);


    @Query("select reg from Registry reg where reg.shortFcs = :short_fcs " +
            "and reg.birthYear = :birth_year " +
            "and reg.diseaseNumber = :disease_number")
    List<Registry> findRegistryByFilter(@Param("short_fcs") String shortFcs,
                                       @Param("birth_year") String birthYear,
                                       @Param("disease_number") String diseaseNumber);

}