package fr.cda.trainingharrypotter.service;

import fr.cda.trainingharrypotter.dto.HouseDTO;
import fr.cda.trainingharrypotter.entity.House;
import fr.cda.trainingharrypotter.repository.HouseRepository;
import fr.cda.trainingharrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseService implements
        ServiceListInterface<House, Integer, HouseDTO, HouseDTO> {

    private HouseRepository houseRepository;

    @Override
    public House create(HouseDTO o) {
        House house = new House();
        house.setHouseName(o.getHouseName());
        house.setFounderFirstName(o.getFounderFirstName());
        house.setFounderLastName(o.getFounderLastName());
        return houseRepository.saveAndFlush(house);
    }

    @Override
    public House update(HouseDTO o, Integer id) {
        House house = findOneById(id);
        house.setHouseName(o.getHouseName());
        house.setFounderFirstName(o.getFounderFirstName());
        house.setFounderLastName(o.getFounderLastName());
        return houseRepository.saveAndFlush(house);
    }

    @Override
    public void delete(Integer id) {
        houseRepository.deleteById(id);
    }

    @Override
    public House findOneById(Integer id) {
        return houseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<House> list() {
        return houseRepository.findAll();
    }

    public House findBySearch(String search) {
        Optional<House> optional;
        try {
            Integer id = Integer.parseInt(search);
            optional = houseRepository.findById(id);
        } catch (NumberFormatException e) {
            optional = houseRepository.findByHouseNameContainingIgnoreCase(search);
        }
        return optional.orElseThrow(EntityNotFoundException::new);
    }
}
