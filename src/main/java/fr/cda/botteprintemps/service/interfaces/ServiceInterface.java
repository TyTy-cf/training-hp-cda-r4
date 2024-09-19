package fr.cda.botteprintemps.service.interfaces;

import java.util.Optional;

public interface ServiceInterface<T, L, C, U> {

    T create(C o);

    T update(U o, L id) throws Exception;

    void delete(T o);

    T findOneById(L id) throws Exception;

}
