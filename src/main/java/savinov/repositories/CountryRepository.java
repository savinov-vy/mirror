package savinov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savinov.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    void deleteById(Integer id);

}
