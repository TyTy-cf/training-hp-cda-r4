package fr.cda.botteprintemps.service;

import fr.cda.botteprintemps.dto.UserCreateDTO;
import fr.cda.botteprintemps.dto.UserUpdateDTO;
import fr.cda.botteprintemps.entity.User;
import fr.cda.botteprintemps.repository.UserRepository;
import fr.cda.botteprintemps.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements
        ServiceListInterface<User, String, UserCreateDTO, UserUpdateDTO> {

    private UserRepository userRepository;

    @Override
        public User create(UserCreateDTO o) {
        User u = getObjectsFromDTO(new User(), o);
        u.setCreatedAt(LocalDateTime.now());
        userRepository.save(u);
        return u;
    }

    @Override
    public User update(UserUpdateDTO o, String id) throws Exception {
        User u = getObjectsFromDTO(findOneById(id), o);
        u.setPhone(o.getPhone());
        u.setPhoto(o.getPhoto());
        userRepository.flush();
        return u;
    }

    @Override
    public void delete(User o) {
        userRepository.delete(o);
    }

    @Override
    public User findOneById(String id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    private User getObjectsFromDTO(User u, UserCreateDTO o) {
        u.setEmail(o.getEmail());
        u.setFirstName(o.getFirstName());
        u.setLastName(o.getLastName());
        u.setPassword(o.getPassword());
        u.setBirthAt(o.getBirthAt());
        return u;
    }

}
