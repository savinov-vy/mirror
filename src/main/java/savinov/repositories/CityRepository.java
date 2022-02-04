package savinov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savinov.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    void deleteById(Integer id);

}
