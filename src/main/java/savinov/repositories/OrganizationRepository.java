package savinov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savinov.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    void deleteById(Integer id);

}
