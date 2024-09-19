package fr.cda.botteprintemps.service;

import fr.cda.botteprintemps.dto.LodgingDTO;
import fr.cda.botteprintemps.entity.Lodging;
import fr.cda.botteprintemps.repository.LodgingRepository;
import fr.cda.botteprintemps.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LodgingService implements ServiceListInterface<Lodging, String, LodgingDTO, LodgingDTO> {

    private LodgingRepository lodgingRepository;

    private AddressService addressService;

    @Override
    public Lodging create(LodgingDTO o) {
        return lodgingRepository.saveAndFlush(objectFromDTO(new Lodging(), o));
    }

    @Override
    public Lodging update(LodgingDTO o, String id) throws Exception {
        Lodging lodging = objectFromDTO(findOneById(id), o);
        lodging.setId(id);
        lodgingRepository.flush();
        return lodging;
    }

    @Override
    public void delete(Lodging o) {
        lodgingRepository.delete(o);
    }

    @Override
    public Lodging findOneById(String id) {
        return lodgingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<?> list() {
        return lodgingRepository.findAll();
    }

    private Lodging objectFromDTO(Lodging o, LodgingDTO dto) {
        o.setAccessible(dto.isAccessible());
        o.setCapacity(dto.getCapacity());
        o.setName(dto.getName());
        o.setNightPrice(dto.getNightPrice());
        o.setDescription(dto.getDescription());
        o.setAddress(addressService.create(dto.getAddressDTO()));
        return o;
    }
}
