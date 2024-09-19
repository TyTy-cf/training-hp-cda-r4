package fr.cda.botteprintemps.service.interfaces;

import java.util.Optional;

public interface ServiceInterface<T, L> {

    T create(T o);

    T update(T o, L id);

    void delete(T o);

    Optional<?> findOneById(L id);

}
