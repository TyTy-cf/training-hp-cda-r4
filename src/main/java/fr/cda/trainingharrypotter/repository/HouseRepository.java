package fr.cda.trainingharrypotter.repository;

import fr.cda.trainingharrypotter.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    Optional<House> findByHouseNameContainingIgnoreCase( String house);

}
