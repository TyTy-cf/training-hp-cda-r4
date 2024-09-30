package fr.cda.trainingharrypotter.repository;

import fr.cda.trainingharrypotter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}