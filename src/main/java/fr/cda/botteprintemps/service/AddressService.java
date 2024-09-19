package fr.cda.botteprintemps.service;

import fr.cda.botteprintemps.dto.AddressDTO;
import fr.cda.botteprintemps.entity.Address;
import fr.cda.botteprintemps.repository.AddressRepository;
import fr.cda.botteprintemps.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements ServiceListInterface<Address, Long, AddressDTO, AddressDTO> {

    private AddressRepository addressRepository;

    @Override
    public Address create(AddressDTO o) {
        return addressRepository.saveAndFlush(objectFromDTO(o));
    }

    @Override
    public Address update(AddressDTO o, Long id) {
        Address address = objectFromDTO(o);
        address.setId(id);
        addressRepository.flush();
        return address;
    }

    @Override
    public void delete(Address o) {
        addressRepository.delete(o);
    }

    @Override
    public Address findOneById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<?> list() {
        return addressRepository.findAll();
    }

    private Address objectFromDTO(AddressDTO o) {
        Address address = new Address();
        address.setNumber(o.getNumber());
        address.setStreet(o.getStreet());
        address.setCity(o.getCity());
        address.setCountry(o.getCountry());
        address.setLatitude(o.getLatitude());
        address.setLongitude(o.getLongitude());
        address.setZipcode(o.getZipcode());
        address.setMore(o.getMore());
        return address;
    }
}
