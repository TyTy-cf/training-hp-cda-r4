package fr.cda.botteprintemps.configuration;

import fr.cda.botteprintemps.entity.User;
import fr.cda.botteprintemps.entity.redditish.UserRedditish;
import fr.cda.botteprintemps.repository.UserRedditishRepository;
import lombok.AllArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@AllArgsConstructor
public class InitDataLoaderConfig implements CommandLineRunner {

    private UserRedditishRepository userRedditishRepository;

    @Override
    public void run(String... args) {
        createUsers();
        userRedditishRepository.flush();
    }

    private void createUsers() {
        Faker faker = new Faker(Locale.of("fr"));
        List<String> duplicates = new ArrayList<>();
        if (userRedditishRepository.count() != 500) {
            for (long i = 1L; i <= 500L; i++) {
                UserRedditish user = new UserRedditish();
                String name;
                do {
                    name = faker.name().name().replace(" ", "");
                } while (duplicates.contains(name));
                duplicates.add(name);
                user.setId(i);
                user.setNickname(name);
                user.setEmail(faker.internet().emailAddress());
                user.setPassword(faker.internet().password(8, 12));
                user.setRegisteredAt(LocalDateTime.now());
                user.setSlug(name.toLowerCase());

                User u = new User();
                u.setFirstName(faker.name().firstName());
                u.setLastName(faker.name().lastName());
                u.setRoles("[\"ROLE_USER\"]");
                u.setEmail(faker.internet().emailAddress(u.getFirstName() + "." + u.getLastName()));

                userRedditishRepository.save(user);
            }
        }
    }

}
