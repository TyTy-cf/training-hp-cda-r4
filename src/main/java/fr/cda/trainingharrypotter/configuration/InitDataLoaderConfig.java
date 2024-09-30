package fr.cda.trainingharrypotter.configuration;

import fr.cda.trainingharrypotter.entity.Role;
import fr.cda.trainingharrypotter.entity.User;
import fr.cda.trainingharrypotter.repository.RoleRepository;
import fr.cda.trainingharrypotter.repository.UserRepository;
import lombok.AllArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@AllArgsConstructor
public class InitDataLoaderConfig implements CommandLineRunner {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        createRoles();
        createUsers();
    }

    private void createRoles() {
        if (roleRepository.count() == 0) {
            Role role = new Role();
            role.setLabel("ROLE_USER");
            roleRepository.saveAndFlush(role);

            Role admin = new Role();
            admin.setLabel("ROLE_ADMIN");
            roleRepository.saveAndFlush(admin);
        }
    }

    private void createUsers() {
        Faker faker = new Faker(Locale.of("fr"));
        List<String> duplicates = new ArrayList<>();
        if (userRepository.count() != 500) {
            for (long i = 1L; i <= 450; i++) {
                User user = new User();
                String name;
                do {
                    name = faker.name().name().replace(" ", "");
                } while (duplicates.contains(name));
                duplicates.add(name);
                user.setUsername(name);
                user.setPassword(passwordEncoder.encode("12345"));

                Role userRole = roleRepository.findById(1L).get();
                if (i == 1L) {
                    Role admin = roleRepository.findById(2L).get();
                    user.setRoles(List.of(admin, userRole));
                } else {
                    user.setRoles(List.of(userRole));
                }
                userRepository.save(user);
            }
        }
    }

    private LocalDateTime generateRandomDate() {
        Faker faker = new Faker();
        Instant randomDate = faker.timeAndDate().between(
                Instant.now().minusMillis(999999999),
                Instant.now());
        return randomDate.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
