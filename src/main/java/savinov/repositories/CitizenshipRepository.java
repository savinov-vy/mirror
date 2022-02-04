package savinov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savinov.entities.Citizenship;

@Repository
public interface CitizenshipRepository extends JpaRepository<Citizenship, Integer> {

    void deleteById(Integer id);

}
