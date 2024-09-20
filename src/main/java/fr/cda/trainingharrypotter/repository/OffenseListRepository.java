package fr.cda.trainingharrypotter.repository;

import fr.cda.trainingharrypotter.entity.OffenseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenseListRepository extends JpaRepository<OffenseList, Integer> {

}
