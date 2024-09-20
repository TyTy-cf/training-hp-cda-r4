package fr.cda.trainingharrypotter.repository;

import fr.cda.trainingharrypotter.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

}
