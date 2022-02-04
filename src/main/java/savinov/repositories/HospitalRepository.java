package savinov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savinov.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    void deleteById(Integer id);

}
