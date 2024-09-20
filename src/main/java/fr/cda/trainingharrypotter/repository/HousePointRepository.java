package fr.cda.trainingharrypotter.repository;

import fr.cda.trainingharrypotter.entity.HousePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousePointRepository extends JpaRepository<HousePoint, Integer> {

}
