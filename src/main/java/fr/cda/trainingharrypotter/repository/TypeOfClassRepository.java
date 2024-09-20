package fr.cda.trainingharrypotter.repository;

import fr.cda.trainingharrypotter.entity.TypeOfClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfClassRepository extends JpaRepository<TypeOfClass, Integer> {

}
