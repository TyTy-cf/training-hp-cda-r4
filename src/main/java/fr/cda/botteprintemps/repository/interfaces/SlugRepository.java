package fr.cda.botteprintemps.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SlugRepository<T, ID> {

    Optional<T> findOneBySlug(String slug);

}
