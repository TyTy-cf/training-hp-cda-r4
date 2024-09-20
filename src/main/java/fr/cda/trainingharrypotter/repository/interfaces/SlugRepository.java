package fr.cda.trainingharrypotter.repository.interfaces;

import java.util.Optional;

public interface SlugRepository<T, ID> {

    Optional<T> findOneBySlug(String slug);

}
