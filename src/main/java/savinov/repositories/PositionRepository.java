package savinov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savinov.entities.Organization;
import savinov.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

    void deleteById(Integer id);

}
